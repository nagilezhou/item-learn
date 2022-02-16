//Design and implement a data structure for a Least Frequently Used (LFU) cache.
//
//
// Implement the LFUCache class:
//
//
// LFUCache(int capacity) Initializes the object with the capacity of the data s
//tructure.
// int get(int key) Gets the value of the key if the key exists in the cache. Ot
//herwise, returns -1.
// void put(int key, int value) Update the value of the key if present, or inser
//ts the key if not already present. When the cache reaches its capacity, it shoul
//d invalidate and remove the least frequently used key before inserting a new ite
//m. For this problem, when there is a tie (i.e., two or more keys with the same f
//requency), the least recently used key would be invalidated.
//
//
// To determine the least frequently used key, a use counter is maintained for e
//ach key in the cache. The key with the smallest use counter is the least frequen
//tly used key.
//
// When a key is first inserted into the cache, its use counter is set to 1 (due
// to the put operation). The use counter for a key in the cache is incremented ei
//ther a get or put operation is called on it.
//
// The functions get and put must each run in O(1) average time complexity.
//
//
// Example 1:
//
//
//Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element is
//  most recent)
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalid
//ate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
//.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // return 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3
//
//
//
// Constraints:
//
//
// 0 <= capacity <= 104
// 0 <= key <= 105
// 0 <= value <= 109
// At most 2 * 105 calls will be made to get and put.
//
//
//
// Related Topics 设计 哈希表 链表 双向链表
// 👍 472 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashSet;

//Java：LFU Cache
public class P460LfuCache {
    public static void main(String[] args) {
        //Solution solution = new P460LfuCache().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {

        // key 到 value 的映射（一对一）
        private final HashMap<Integer, Integer> keyToValMap;
        // key 到 frequency 的映射（一对一）
        private final HashMap<Integer, Integer> keyToFreqMap;
        // frequency 到 key 的映射（一对多）
        private final HashMap<Integer, LinkedHashSet<Integer>> freqToKeysMap;
        // 记录最小频次
        private int minFrequency;
        // 缓存容量
        private int cap;

        public LFUCache(int capacity) {
            keyToValMap = new HashMap<>();
            keyToFreqMap = new HashMap<>();
            freqToKeysMap = new HashMap<>();
            this.cap = capacity;
            this.minFrequency = 0;
        }

        public int get(int key) {
            if (!keyToValMap.containsKey(key)) {
                return -1;
            }
            increaseFreq(key);
            return keyToValMap.get(key);
        }

        public void put(int key, int value) {
            if (this.cap <= 0) {
                return;
            }
            // 给定的 key 在 KV 中不存在
            if (!keyToValMap.containsKey(key)) {
                // 容量已经满了，删掉一个
                if (this.cap == keyToValMap.size()) {
                    removeOne();
                }
                keyToValMap.put(key, value);
                keyToFreqMap.put(key, 1);
                freqToKeysMap.putIfAbsent(1, new LinkedHashSet<Integer>());
                freqToKeysMap.get(1).add(key);
                this.minFrequency = 1;
            } else {
                // 给定的 key 在 KV 中已经存在
                keyToValMap.put(key, value);
                increaseFreq(key);
            }
        }

        // 增加相应 key 的频数
        private void increaseFreq(int key) {
            int oldFreq = keyToFreqMap.get(key);
            int newFreq = oldFreq + 1;
            keyToFreqMap.put(key, newFreq);
            if (!freqToKeysMap.containsKey(newFreq)) {
                LinkedHashSet<Integer> sameFreqKey = new LinkedHashSet<>();
                sameFreqKey.add(key);
                freqToKeysMap.put(newFreq, sameFreqKey);
            } else {
                freqToKeysMap.get(newFreq).add(key);
            }
            freqToKeysMap.get(oldFreq).remove(key);
            if (freqToKeysMap.get(oldFreq).isEmpty()) {
                freqToKeysMap.remove(oldFreq);
                if (oldFreq == this.minFrequency) {
                    this.minFrequency++;
                }
            }
        }

        // 删掉使用频率最低的值
        private void removeOne() {
            LinkedHashSet<Integer> keyList = freqToKeysMap.get(this.minFrequency);
            int deletedKey = keyList.iterator().next();
            keyToValMap.remove(deletedKey);
            keyToFreqMap.remove(deletedKey);
            keyList.remove(deletedKey);
            if (keyList.isEmpty()) {
                freqToKeysMap.remove(this.minFrequency);
            }
        }
    }
}



