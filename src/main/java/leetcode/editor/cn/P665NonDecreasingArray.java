//Given an array nums with n integers, your task is to check if it could become
//non-decreasing by modifying at most one element.
//
// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for ever
//y i (0-based) such that (0 <= i <= n - 2).
//
//
// Example 1:
//
//
//Input: nums = [4,2,3]
//Output: true
//Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
//
//
// Example 2:
//
//
//Input: nums = [4,2,1]
//Output: false
//Explanation: You can't get a non-decreasing array by modify at most one elemen
//t.
//
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 104
// -105 <= nums[i] <= 105
//
// Related Topics 数组
// 👍 586 👎 0

package leetcode.editor.cn;

//Java：Non-decreasing Array
public class P665NonDecreasingArray {
    public static void main(String[] args) {
        Solution solution = new P665NonDecreasingArray().new Solution();
        System.out.println(solution.checkPossibility(new int[] {4, 2, 3}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPossibility(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return true;
            }
            int pre = 0;
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (pre <= nums[i + 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                    count++;
                }
                pre = nums[i];
            }
            return count <= 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



