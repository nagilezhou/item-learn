//You are given an array prices where prices[i] is the price of a given stock on
// the ith day.
//
// Find the maximum profit you can achieve. You may complete as many transaction
//s as you like (i.e., buy one and sell one share of the stock multiple times).
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again).
//
//
// Example 1:
//
//
//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit =
//5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//
//
//
// Example 2:
//
//
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you ar
//e engaging multiple transactions at the same time. You must sell before buying a
//gain.
//
//
// Example 3:
//
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e., max profit = 0.
//
//
//
// Constraints:
//
//
// 1 <= prices.length <= 3 * 104
// 0 <= prices[i] <= 104
//
// Related Topics 贪心算法 数组
// 👍 1231 👎 0

package leetcode.editor.cn;

//Java：Best Time to Buy and Sell Stock II dp
// 2021-08-01 review 1
public class P122BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new P122BestTimeToBuyAndSellStockIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // gd
        public int maxProfit4(int[] prices) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }

        // dp
        public int maxProfit3(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }

        // dp + 分开设置
        public int maxProfit2(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int[] cash = new int[prices.length];
            int[] hold = new int[prices.length];
            cash[0] = 0;
            hold[0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
                hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
            }
            return cash[prices.length - 1];
        }


        // dp + 分开设置 + 空间优化
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int cash = 0;
            int hold = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                cash = Math.max(cash, hold + prices[i]);
                hold = Math.max(hold, cash - prices[i]);
            }
            return cash;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



