//You are given an array prices where prices[i] is the price of a given stock on
// the ith day.
//
// You want to maximize your profit by choosing a single day to buy one stock an
//d choosing a different day in the future to sell that stock.
//
// Return the maximum profit you can achieve from this transaction. If you canno
//t achieve any profit, return 0.
//
//
// Example 1:
//
//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must
// buy before you sell.
//
//
// Example 2:
//
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
//
//
//
// Constraints:
//
//
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104
//
// Related Topics 数组 动态规划
// 👍 1565 👎 0

package leetcode.editor.cn;

//Java：Best Time to Buy and Sell Stock
public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit(new int[] {7, 6, 4, 3, 1}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dp
        public int maxProfit2(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 持股状态只能由从来没有持股状态转化过来,不是dp[i-1][0]
                dp[i][1] = Math.max(dp[i - 1][1], dp[0][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }

        // dp + 空间优化
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[0] = Math.max(dp[0], dp[1] + prices[i]);
                dp[1] = Math.max(dp[1],  - prices[i]);
            }
            return dp[0];
        }



    }
    //leetcode submit region end(Prohibit modification and deletion)

}



