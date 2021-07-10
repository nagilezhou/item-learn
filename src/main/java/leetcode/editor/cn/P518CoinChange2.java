//You are given an integer array coins representing coins of different denominat
//ions and an integer amount representing a total amount of money.
//
// Return the number of combinations that make up that amount. If that amount of
// money cannot be made up by any combination of the coins, return 0.
//
// You may assume that you have an infinite number of each kind of coin.
//
// The answer is guaranteed to fit into a signed 32-bit integer.
//
//
// Example 1:
//
//
//Input: amount = 5, coins = [1,2,5]
//Output: 4
//Explanation: there are four ways to make up the amount:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
//
//
// Example 2:
//
//
//Input: amount = 3, coins = [2]
//Output: 0
//Explanation: the amount of 3 cannot be made up just with coins of 2.
//
//
// Example 3:
//
//
//Input: amount = 10, coins = [10]
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// All the values of coins are unique.
// 0 <= amount <= 5000
//
// Related Topics 数组 动态规划
// 👍 552 👎 0

package leetcode.editor.cn;

//Java：Coin Change 2
public class P518CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new P518CoinChange2().new Solution();
        System.out.println(solution.change(500, new int[] {1, 2, 5}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                int t = coins[i - 1];
                for (int j = t; j <= amount; j++) {
                    dp[j] = dp[j] + dp[j - t];
                }

            }
            return dp[amount];
        }

        public int change2(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int t = coins[i - 1];
                for (int j = 0; j <= amount; j++) {
                    dp[i][j] = dp[i - 1][j];
                    for (int k = 1; k * t <= j; k++) {
                        dp[i][j] += dp[i - 1][j - k * t];
                    }
                }
            }
            return dp[n][amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



