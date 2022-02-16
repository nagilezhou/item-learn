//You are given an integer array coins representing coins of different denominat
//ions and an integer amount representing a total amount of money.
//
// Return the fewest number of coins that you need to make up that amount. If th
//at amount of money cannot be made up by any combination of the coins, return -1.
//
//
// You may assume that you have an infinite number of each kind of coin.
//
//
// Example 1:
//
//
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//
//
// Example 2:
//
//
//Input: coins = [2], amount = 3
//Output: -1
//
//
// Example 3:
//
//
//Input: coins = [1], amount = 0
//Output: 0
//
//
// Example 4:
//
//
//Input: coins = [1], amount = 1
//Output: 1
//
//
// Example 5:
//
//
//Input: coins = [1], amount = 2
//Output: 2
//
//
//
// Constraints:
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 1285 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Java：Coin Change 完全背包
// 2021-08-17 review 1
public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[] {2, 5, 10, 1}, 27));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int coinChange(int[] coins, int amount) {
            int INF = 0x3f3f3f3f;
            int n = coins.length;
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                dp[i] = INF;
            }
            for (int i = 1; i <= n; i++) {
                int val = coins[i - 1];
                for (int j = val; j <= amount; j++) {
                    dp[j] = Math.min(dp[j], dp[j - val] + 1);
                }
            }
            return dp[amount] == INF ? -1 : dp[amount];
        }


        public int coinChange2(int[] coins, int amount) {
            int INF = 0x3f3f3f3f;
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            for (int i = 1; i <= amount; i++) { dp[0][i] = INF; }

            for (int i = 1; i <= n; i++) {
                int val = coins[i - 1];
                for (int j = 0; j <= amount; j++) {
                    dp[i][j] = dp[i - 1][j];
                    for (int k = 1; k * val <= j; k++) {
                        if (dp[i - 1][j - k * val] != INF) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * val] + k);
                        }
                    }
                }
            }
            return dp[n][amount] == INF ? -1 : dp[n][amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



