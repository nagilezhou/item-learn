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

//Java：Sort Colors 数组 双指针
// 2021-08-01 review 1
public class P75SortColors {
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        int[] nums = new int[] {2, 0, 1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int len = nums.length;
            //if (len < 2) {
            //    return;
            //}

            // all in [0, zero) = 0
            // all in [zero, i) = 1
            // all in [two, len - 1] = 2

            // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
            // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
            // 所以下面遍历到 0 的时候，先交换，再加
            int zero = 0;

            // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
            // 所以下面遍历到 2 的时候，先减，再交换
            int two = len;
            int i = 0;
            // 当 i == two 上面的三个子区间正好覆盖了全部数组
            // 因此，循环可以继续的条件是 i < two
            while (i < two) {
                if (nums[i] == 0) {
                    swap(nums, i, zero);
                    zero++;
                    i++;
                } else if (nums[i] == 1) {
                    i++;
                } else {
                    two--;
                    swap(nums, i, two);
                }
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



