//Given an integer array nums, design an algorithm to randomly shuffle the array
//.
//
// Implement the Solution class:
//
//
// Solution(int[] nums) Initializes the object with the integer array nums.
// int[] reset() Resets the array to its original configuration and returns it.
//
// int[] shuffle() Returns a random shuffling of the array.
//
//
//
// Example 1:
//
//
//Input
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//Output
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//Explanation
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any
// permutation of [1,2,3] must be equally likely to be returned. Example: return [
//3, 1, 2]
//solution.reset();      // Resets the array back to its original configuration
//[1,2,3]. Return [1, 2, 3]
//solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Examp
//le: return [1, 3, 2]
//
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 200
// -106 <= nums[i] <= 106
// All the elements of nums are unique.
// At most 5 * 104 calls will be made to reset and shuffle.
//
// Related Topics 数组 数学 随机化
// 👍 140 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：Shuffle an Array 洗牌算法
// 2021-08-17 review 1
public class P384ShuffleAnArray {
    public static void main(String[] args) {
        Solution solution = new P384ShuffleAnArray().new Solution(new int[] {1, 2, 3});
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            array = original;
            original = original.clone();
            return array;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                swapAt(i, randRange(i, array.length));
            }
            return array;
        }

        private int[] array;
        private int[] original;

        private Random rand = new Random();

        private int randRange(int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private void swapAt(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}



