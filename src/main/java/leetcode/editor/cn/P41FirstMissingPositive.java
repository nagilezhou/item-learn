//Given an unsorted integer array nums, return the smallest missing positive int
//eger.
//
// You must implement an algorithm that runs in O(n) time and uses constant extr
//a space.
//
//
// Example 1:
// Input: nums = [1,2,0]
//Output: 3
// Example 2:
// Input: nums = [3,4,-1,1]
//Output: 2
// Example 3:
// Input: nums = [7,8,9,11,12]
//Output: 1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5 * 105
// -231 <= nums[i] <= 231 - 1
//
// Related Topics 数组 哈希表
// 👍 1362 👎 0

package leetcode.editor.cn;

//Java：First Missing Positive
public class P41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new P41FirstMissingPositive().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            // [1, -1, 3, 4]
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            // 都正确则返回数组长度 + 1
            return n + 1;

        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



