## 基本分析

前两天我们刚讲过 [146. LRU 缓存机制](https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247486820&idx=1&sn=2055864e10848bce55afc4e2feda79a7&chksm=fd9ca67bcaeb2f6d2038706e32cafffd701d3d6b71b60c52a568ed6dc0e268d93f8a78498105&token=672687058&lang=zh_CN#rd) ，简单理解 LRU 就是「移除最久不被使用的元素」。

因此对于 LRU 我们只需要在使用「哈希表」的同时，维护一个「双向链表」即可：

* 每次发生 `get` 或 `put` 的时候就将元素存放双向链表头部
* 当需要移除元素时，则从双向链表尾部开始移除

LFU 简单理解则是指「移除使用次数最少的元素」，如果存在多个使用次数最小的元素，则移除「最近不被使用的那个」（LRU 规则）。同样的 `get` 和 `put` 都算作一次使用。

因此，我们需要记录下每个元素的使用次数，并且在 *O(1)* 的复杂度内「修改某个元素的使用次数」和「找到使用次数最小的元素」。

---

## 桶排序 + 双向链表

**我们可以使用「桶排序」的思路，搭配「双向链表」实现 *O(1)* 操作。**

**在 `LFUCache` 中，我们维护一个由 `Bucket` 作为节点的双向链表，每个 `Bucket` 都有一个 `idx` 编号，代表当前桶存放的是「使用了多少次」的键值对**（`idx = 1` 的桶存放使用一次的键值对；`idx = 2` 的桶存放的是使用两次的键值对 ... ）。

同时 `LFUCache` 持有一个「哈希表」，用来记录哪些 `key` 在哪个桶内。

**在 `Bucket` 内部则是维护了一条以 `Item` 作为节点的双向链表，`Item` 是用作存放真实键值对的。**

同样的，`Bucket` 也持有一个「哈希表」，用来记录 `key` 与 `Item` 的映射关系。

因此 `LFUCache` 其实是一个「链表套链表」的数据结构：

![image.png](https://pic.leetcode-cn.com/1622691938-yPgKna-image.png)

对应到 `LFUCache` 的几种操作：

* `get` ：先通过 `LFUCache` 持有的哈希表进行查找，如果不存在返回 *-1*，如果存在找到键值对所在的桶 `cur`：
    * 调用对应的 `cur` 的 `remove` 操作，得到键值对对应的 `item`（移除代表当前键值对使用次数加一了，不会在存在于原来的桶中）。
    * 将 `item` 放到 `idx` 为 *cur.idx + 1* 的桶 `target` 中（代表代表当前键值对使用次数加一，应该放到新的目标桶中）。
    * 如果目标桶 `target` 不存在，则创建；如果原来桶 `cur` 移除键值对后为空，则销毁。
    * 更新 `LFUCache` 中哈希表的信息。
* `put` ： 先通过 `LFUCache` 持有的哈希表进行查找：
    * 如果存在：找到键值对所在的桶 `cur`，调用 `cur` 的 `put` 操作，更新键值对，然后调用 `LFUCache` 的 `get` 操作实现使用次数加一。
    * 如果不存在：先检查容量是否达到数量：
        * 容量达到数量的话需要调用「编号最小的桶」的 `clear` 操作，在 `clear` 操作内部，会从 `item` 双向链表的尾部开始移除元素。完成后再执行插入操作。
    * 插入操作：将键值对添加到 *idx = 1* 的桶中（代表当前键值对使用次数为 *1*），如果桶不存在则创建。

代码：

```Java []
class LFUCache {

    class Item {
        Item l, r;
        int k, v;
        public Item(int _k, int _v) {
            k = _k;
            v = _v;
        }
    }

    class Bucket {
        Bucket l, r;
        int idx;
        Item head, tail;
        Map<Integer, Item> map = new HashMap<>();
        public Bucket(int _idx) {
            idx = _idx;
            head = new Item(-1, -1);
            tail = new Item(-1, -1);
            head.r = tail;
            tail.l = head;
        }
        void put(int key, int value) {
            Item item = null;
            if (map.containsKey(key)) {
                item = map.get(key);
                // 更新值
                item.v = value;
                // 在原来的双向链表位置中移除
                item.l.r = item.r;
                item.r.l = item.l;
            } else {
                item = new Item(key, value);
                // 添加到哈希表中
                map.put(key, item);
            }
            // 增加到双向链表头部
            item.r = head.r;
            item.l = head;
            head.r.l = item;
            head.r = item;
        }
        Item remove(int key) {
            if (map.containsKey(key)) {
                Item item = map.get(key);
                // 从双向链表中移除
                item.l.r = item.r;
                item.r.l = item.l;
                // 从哈希表中移除
                map.remove(key);
                return item;
            }
            return null; // never
        }
        Item clear() {
            // 从双向链表尾部找到待删除的节点
            Item item = tail.l;
            item.l.r = item.r;
            item.r.l = item.l;
            // 从哈希表中移除
            map.remove(item.k);
            return item;
        }
        boolean isEmpty() {
            return map.size() == 0;
        }
    }

    Map<Integer, Bucket> map = new HashMap<>();
    Bucket head, tail;
    int n;
    int cnt;
    public LFUCache(int capacity) {
        n = capacity;
        cnt = 0;
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.r = tail;
        tail.l = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Bucket cur = map.get(key);
            
            Bucket target = null;
            if (cur.r.idx != cur.idx + 1) { 
                // 目标桶空缺
                target = new Bucket(cur.idx + 1);
                target.r = cur.r;
                target.l = cur;
                cur.r.l = target;
                cur.r = target;
            } else {
                target = cur.r;
            }

            // 将当前键值对从当前桶移除，并加入新的桶
            Item remove = cur.remove(key);
            target.put(remove.k, remove.v);
            // 更新当前键值对所在桶信息
            map.put(key, target);

            // 如果在移除掉当前键值对后，当前桶为空，则将当前桶删除（确保空间是 O(n) 的）
            // 也确保调用编号最小的桶的 clear 方法，能够有效移除掉一个元素
            deleteIfEmpty(cur);

            return remove.v;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if (n == 0) return;
        if (map.containsKey(key)) {
            // 元素已存在，修改一下值
            Bucket cur = map.get(key);
            cur.put(key, value);
            // 调用一下 get 实现「使用次数」+ 1
            get(key); 
        } else {
            // 容器已满，需要先删除元素
            if (cnt == n) {
                // 从第一个桶（编号最小、使用次数最小）中进行清除
                Bucket cur = head.r;
                Item clear = cur.clear();
                map.remove(clear.k);
                cnt--;

                // 如果在移除掉键值对后，当前桶为空，则将当前桶删除（确保空间是 O(n) 的）
                // 也确保调用编号最小的桶的 clear 方法，能够有效移除掉一个元素
                deleteIfEmpty(cur);
            } 

            // 需要将当前键值对增加到 1 号桶
            Bucket first = null;

            // 如果 1 号桶不存在则创建
            if (head.r.idx != 1) {
                first = new Bucket(1);
                first.r = head.r;
                first.l = head;
                head.r.l = first;
                head.r = first;
            } else {
                first = head.r;
            }

            // 将键值对添加到 1 号桶
            first.put(key, value);
            // 更新键值对所在桶信息
            map.put(key, first);
            // 计数器加一
            cnt++;
        }
    }

    void deleteIfEmpty(Bucket cur) {
        if (cur.isEmpty()) {
            cur.l.r = cur.r;
            cur.r.l = cur.l;
            cur = null; // help GC
        }
    }
}
```
* 时间复杂度：各操作均为 *O(1)*
* 时间复杂度：*O(n)*

---

## 最后

**如果有帮助到你，请给题解点个赞和收藏，让更多的人看到 ~ ("▔□▔)/**

也欢迎你 [关注我](https://oscimg.oschina.net/oscnet/up-19688dc1af05cf8bdea43b2a863038ab9e5.png) 和 加入我们的[「组队打卡」](https://leetcode-cn.com/u/ac_oier/)小群 ，提供写「证明」&「思路」的高质量题解。

所有题解已经加入 [刷题指南](https://github.com/SharingSource/LogicStack-LeetCode/wiki)，欢迎 star 哦 ~ 


