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
// 2021-08-11 review 1
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
            int n = nums.length;
            int max = nums[0];
            int min = nums[0];
            int res = nums[0];
            for (int i = 1; i < n; i++) {
                int tempMax = max;
                max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
                min = Math.min(tempMax * nums[i], Math.min(min * nums[i], nums[i]));
                res = Math.max(res, max);
            }
            return res;
        }

        public int maxProduct2(int[] nums) {
            int n = nums.length;
            int[] maxs = new int[n];
            int[] mins = new int[n];
            maxs[0] = nums[0];
            mins[0] = nums[0];

            int res = nums[0];
            for (int i = 1; i < n; i++) {
                maxs[i] = Math.max(maxs[i - 1] * nums[i], Math.max(mins[i - 1] * nums[i], nums[i]));
                mins[i] = Math.min(maxs[i - 1] * nums[i], Math.min(mins[i - 1] * nums[i], nums[i]));
                res = Math.max(res, maxs[i]);
            }
            return res;
        }



}
//leetcode submit region end(Prohibit modification and deletion)

}



