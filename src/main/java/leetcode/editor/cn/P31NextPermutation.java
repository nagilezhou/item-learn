//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers.
//
// If such an arrangement is not possible, it must rearrange it as the lowest po
//ssible order (i.e., sorted in ascending order).
//
// The replacement must be in place and use only constant extra memory.
//
//
// Example 1:
// Input: nums = [1,2,3]
//Output: [1,3,2]
// Example 2:
// Input: nums = [3,2,1]
//Output: [1,2,3]
// Example 3:
// Input: nums = [1,1,5]
//Output: [1,5,1]
// Example 4:
// Input: nums = [1]
//Output: [1]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组
// 👍 1151 👎 0

package leetcode.editor.cn;

//Java：Next Permutation 链表
// 2021-07-31 review 1
public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



