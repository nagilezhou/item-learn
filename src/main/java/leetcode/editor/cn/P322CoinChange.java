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

//Java：Coin Change
public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[] {294, 128, 316, 466, 108, 463, 321, 490}, 7130));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int coinChange(int[] coins, int amount) {
            // 自底向上的动态规划
            if (coins.length == 0) {
                return -1;
            }

            // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
            int[] memo = new int[amount + 1];
            memo[0] = 0;
            for (int i = 1; i <= amount; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0 && memo[i - coins[j]] < min) {
                        min = memo[i - coins[j]] + 1;
                    }
                }
                // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
                memo[i] = min;
            }

            return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];

        }

        // 呆瓜dp
        public int coinChange2(int[] coins, int amount) {
            Set<Integer> coinSet = new HashSet<>();
            for (int coin : coins) {
                coinSet.add(coin);
            }
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                if (coinSet.contains(i)) {
                    dp[i] = 1;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (dp[j] == -1 || dp[i - j] == -1) {
                        continue;
                    }
                    int temp = dp[j] + dp[i - j];
                    if (dp[i] == -1) {
                        dp[i] = temp;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
            return dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



