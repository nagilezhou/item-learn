//Given an integer array nums, move all 0's to the end of it while maintaining t
//he relative order of the non-zero elements.
//
// Note that you must do this in-place without making a copy of the array.
//
//
// Example 1:
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// Example 2:
// Input: nums = [0]
//Output: [0]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
//
//
//
//Follow up: Could you minimize the total number of operations done? Related Top
//ics 数组 双指针
// 👍 1078 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Move Zeroes
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        int[] test = new int[]{0,1,0,3,12};
        solution.moveZeroes(test);
        System.out.println(Arrays.toString(test));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        public void swap(int nums[], int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



