//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence.
//
// A subsequence is a sequence that can be derived from an array by deleting som
//e or no elements without changing the order of the remaining elements. For examp
//le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//
//
// Example 1:
//
//
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
//length is 4.
//
//
// Example 2:
//
//
//Input: nums = [0,1,0,3,2,3]
//Output: 4
//
//
// Example 3:
//
//
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
//
//
//
// Follow up:
//
//
// Could you come up with the O(n2) solution?
// Could you improve it to O(n log(n)) time complexity?
//
// Related Topics 二分查找 动态规划
// 👍 1597 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Longest Increasing Subsequence
public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[] {4, 10, 4, 3, 8, 9}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];
            Arrays.fill(dp, 1);
            int maxLength = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
            return maxLength;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



