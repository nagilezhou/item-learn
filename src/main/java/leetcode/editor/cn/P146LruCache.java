//Design a data structure that follows the constraints of a Least Recently Used
//(LRU) cache.
//
// Implement the LRUCache class:
//
//
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1.
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key.
//
//
// The functions get and put must each run in O(1) average time complexity.
//
//
// Example 1:
//
//
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
//
//
//
// Constraints:
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 104
// 0 <= value <= 105
// At most 2 * 105 calls will be made to get and put.
//
// Related Topics 设计
// 👍 1445 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import leetcode.editor.cn.P148SortList.ListNode;

//Java：LRU Cache 哈希链表 map+链表+双端队列
// 2021-08-09 review 1
public class P146LruCache {
    public static void main(String[] args) {
        //Solution solution = new P146LruCache().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class LRUCache {

        public class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;

            public LinkedNode() {

            }

            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private LinkedNode head;

        private LinkedNode tail;

        private Map<Integer, LinkedNode> map;

        private int size;

        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new HashMap<>();
            this.head = new LinkedNode();
            this.tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            LinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            LinkedNode node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                if (++size > capacity) {
                    LinkedNode temp = removeTail();
                    map.remove(temp.key);
                    size--;
                }
                node = new LinkedNode(key, value);
                addToHead(node);
                map.put(node.key, node);
            }
        }

        private void moveToHead(LinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(LinkedNode node) {
            node.prev = head;
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
        }

        private void removeNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private LinkedNode removeTail() {
            LinkedNode temp = tail.prev;
            removeNode(temp);
            return temp;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}



