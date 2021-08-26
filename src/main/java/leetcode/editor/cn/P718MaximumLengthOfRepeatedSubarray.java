//Given two integer arrays nums1 and nums2, return the maximum length of a subar
//ray that appears in both arrays.
//
//
// Example 1:
//
//
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
//
//
// Example 2:
//
//
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
//
//
//
// Constraints:
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 100
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希
// 👍 520 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Maximum Length of Repeated Subarray
public class P718MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 2, 7};
        System.out.println(solution.findLength(nums1, nums2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int maxRight = 0;
            int[][] dp = new int[n + 1][m + 1];
            int res = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (res < dp[i][j]) {
                        res = dp[i][j];
                        maxRight = i;
                    }
                }
            }
            int[] test = Arrays.copyOfRange(nums1, maxRight - res, maxRight);
            System.out.println(Arrays.toString(test));
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



