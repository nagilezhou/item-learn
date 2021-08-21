//You have d dice and each die has f faces numbered 1, 2, ..., f.
//
// Return the number of possible ways (out of fd total ways) modulo 109 + 7 to r
//oll the dice so the sum of the face-up numbers equals target.
//
//
// Example 1:
//
//
//Input: d = 1, f = 6, target = 3
//Output: 1
//Explanation:
//You throw one die with 6 faces.  There is only one way to get a sum of 3.
//
//
// Example 2:
//
//
//Input: d = 2, f = 6, target = 7
//Output: 6
//Explanation:
//You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
//1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
//
//
// Example 3:
//
//
//Input: d = 2, f = 5, target = 10
//Output: 1
//Explanation:
//You throw two dice, each with 5 faces.  There is only one way to get a sum of
//10: 5+5.
//
//
// Example 4:
//
//
//Input: d = 1, f = 2, target = 3
//Output: 0
//Explanation:
//You throw one die with 2 faces.  There is no way to get a sum of 3.
//
//
// Example 5:
//
//
//Input: d = 30, f = 30, target = 500
//Output: 222616187
//Explanation:
//The answer must be returned modulo 10^9 + 7.
//
//
//
// Constraints:
//
//
// 1 <= d, f <= 30
// 1 <= target <= 1000
//
// Related Topics 动态规划
// 👍 92 👎 0

package leetcode.editor.cn;

//Java：Number of Dice Rolls With Target Sum 分组背包
// 2021-08-21 review 1
public class P1155NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        Solution solution = new P1155NumberOfDiceRollsWithTargetSum().new Solution();
        System.out.println(solution.numRollsToTarget(30, 30, 500));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 分组背包
        public int numRollsToTarget(int d, int f, int target) {
            int mod = 1000000007;
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= d; i++) {
                for (int j = target; j >= 0; j--) {
                    dp[j] = 0;
                    for (int k = 1; k <= f; k++) {
                        if (j - k >= 0) {
                            dp[j] += dp[j - k];
                            dp[j] %= mod;
                        }
                    }
                }
            }
            return dp[target];
        }

        public int numRollsToTarget2(int d, int f, int target) {
            int mod = 1000000007;
            int[][] dp = new int[d + 1][target + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= d; i++) {
                for (int j = 0; j <= target; j++) {
                    for (int k = 1; k <= f; k++) {
                        if (j - k >= 0) {
                            dp[i][j] += dp[i - 1][j - k];
                            dp[i][j] %= mod;
                        }
                    }
                }
            }
            return dp[d][target];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



