//Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue.
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and b
//lue, respectively.
//
//
// Example 1:
// Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// Example 2:
// Input: nums = [2,0,1]
//Output: [0,1,2]
// Example 3:
// Input: nums = [0]
//Output: [0]
// Example 4:
// Input: nums = [1]
//Output: [1]
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] is 0, 1, or 2.
//
//
//
// Follow up:
//
//
// Could you solve this problem without using the library's sort function?
// Could you come up with a one-pass algorithm using only O(1) constant space?
//
// Related Topics 排序 数组 双指针
// 👍 872 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Sort Colors
public class P75SortColors {
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        int[] nums = new int[] {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            sortOneColors(nums, left, right, 2, 0);
            sortOneColors(nums, 0, right, 1, 0);
            sortOneColors(nums, left, nums.length - 1, 2, 1);
        }

        private void sortOneColors(int[] nums, int left, int right, int leftNum, int rightNum) {
            while (true) {
                while (left < nums.length && nums[left] != leftNum) {
                    left++;
                }
                while (right >= 0 && nums[right] != rightNum) {
                    right--;
                }
                if(left >= right){
                    break;
                }
                swap(nums, left, right);
            }
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



