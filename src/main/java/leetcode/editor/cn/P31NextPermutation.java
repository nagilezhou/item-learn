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

//Java：Next Permutation
public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return;
            }
            int firstIndex = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    firstIndex = i;
                    break;
                }
            }
            if (firstIndex == -1) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
            int secondIndex = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[firstIndex]) {
                    secondIndex = i;
                    break;
                }
            }
            swap(nums, firstIndex, secondIndex);
            reverse(nums, firstIndex + 1, nums.length - 1);
        }

        private void reverse(int[] nums, int i, int j) {
            while (i < j) {
                swap(nums, i++, j--);
            }
        }

        private void swap(int[] nums, int i, int i1) {
            int tmp = nums[i];
            nums[i] = nums[i1];
            nums[i1] = tmp;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



