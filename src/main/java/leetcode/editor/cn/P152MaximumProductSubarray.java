//Given an integer array nums, find a contiguous non-empty subarray within the a
//rray that has the largest product, and return the product.
//
// It is guaranteed that the answer will fit in a 32-bit integer.
//
// A subarray is a contiguous subsequence of the array.
//
//
// Example 1:
//
//
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
//
//
// Example 2:
//
//
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 104
// -10 <= nums[i] <= 10
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
//integer.
//
// Related Topics 数组 动态规划
// 👍 1121 👎 0

package leetcode.editor.cn;

//Java：Maximum Product Subarray
public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        System.out.println(solution.maxProduct(
            new int[] {-5, 2, 4, 1, -2, 2, -6, 3, -1, -1, -1, -2, -3, 5, 1, -3, -4, 2, -4, 6, -1, 5, -6, 1, -1, -1, 1,
                1, -1}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE, imax = 1, imin = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }
                imax = Math.max(imax * nums[i], nums[i]);
                imin = Math.min(imin * nums[i], nums[i]);

                max = Math.max(max, imax);
            }
            return max;
        }

        // 呆瓜dp
        public int maxProduct2(int[] nums) {
            int[][] dp = new int[nums.length + 1][nums.length + 1];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (i - j <= 1) {
                        dp[j][i] = nums[i - 1];
                    } else {
                        dp[j][i] = dp[j][i - 1] * nums[i - 1];
                    }
                    max = Math.max(max, dp[j][i]);
                }
            }
            return max;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



