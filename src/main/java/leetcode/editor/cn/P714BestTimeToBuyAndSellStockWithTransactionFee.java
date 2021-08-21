//You are given an array prices where prices[i] is the price of a given stock on
// the ith day, and an integer fee representing a transaction fee.
//
// Find the maximum profit you can achieve. You may complete as many transaction
//s as you like, but you need to pay the transaction fee for each transaction.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again).
//
//
// Example 1:
//
//
//Input: prices = [1,3,2,8,4,9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//- Buying at prices[0] = 1
//- Selling at prices[3] = 8
//- Buying at prices[4] = 4
//- Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//
//
// Example 2:
//
//
//Input: prices = [1,3,7,5,10,3], fee = 3
//Output: 6
//
//
//
// Constraints:
//
//
// 1 <= prices.length <= 5 * 104
// 1 <= prices[i] < 5 * 104
// 0 <= fee < 5 * 104
//
// Related Topics 贪心算法 数组 动态规划
// 👍 487 👎 0

package leetcode.editor.cn;

//Java：Best Time to Buy and Sell Stock with Transaction Fee dp
// 2021-08-07 review 1
public class P714BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new P714BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



