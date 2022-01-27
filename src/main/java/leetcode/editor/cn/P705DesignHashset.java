//Design a HashSet without using any built-in hash table libraries.
//
// Implement MyHashSet class:
//
//
// void add(key) Inserts the value key into the HashSet.
// bool contains(key) Returns whether the value key exists in the HashSet or not
//.
// void remove(key) Removes the value key in the HashSet. If key does not exist
//in the HashSet, do nothing.
//
//
//
// Example 1:
//
//
//Input
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove
//", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//Output
//[null, null, null, true, false, null, true, null, false]
//
//Explanation
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // return True
//myHashSet.contains(3); // return False, (not found)
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // return True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // return False, (already removed)
//
//
// Constraints:
//
//
// 0 <= key <= 106
// At most 104 calls will be made to add, remove, and contains.
//
// Related Topics 设计 数组 哈希表 链表 哈希函数
// 👍 212 👎 0

package leetcode.editor.cn;
//Java：Design HashSet
public class P705DesignHashset{
    public static void main(String[] args) {
        //Solution solution = new P705DesignHashset().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {

        private int[] nums;
        public MyHashSet() {
            nums = new int[1000001];
        }

        public void add(int key) {
            nums[key] = 1;
        }

        public void remove(int key) {
            if(nums[key] != 0){
                nums[key] = 0;
            }
        }

        public boolean contains(int key) {
            return nums[key] != 0;
        }
}

// 桶 + bitmap

    class MyHashSet2 {

        int[] bs = new int[40000];
        public void add(int key) {
            int bucketIdx = key / 32;
            int bitIdx = key % 32;
            setVal(bucketIdx, bitIdx, true);
        }

        public void remove(int key) {
            int bucketIdx = key / 32;
            int bitIdx = key % 32;
            setVal(bucketIdx, bitIdx, false);
        }

        public boolean contains(int key) {
            int bucketIdx = key / 32;
            int bitIdx = key % 32;
            return getVal(bucketIdx, bitIdx);
        }

        void setVal(int bucket, int loc, boolean val) {
            if (val) {
                int u = bs[bucket] | (1 << loc);
                bs[bucket] = u;
            } else {
                int u = bs[bucket] & ~(1 << loc);
                bs[bucket] = u;
            }
        }

        boolean getVal(int bucket, int loc) {
            int u = (bs[bucket] >> loc) & 1;
            return u == 1;
        }
    }




/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}



