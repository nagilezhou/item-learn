//You are given an array prices where prices[i] is the price of a given stock on
// the ith day.
//
// Find the maximum profit you can achieve. You may complete at most two transac
//tions.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again).
//
//
// Example 1:
//
//
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit =
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
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
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
//
// Example 4:
//
//
//Input: prices = [1]
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 105
//
// Related Topics 数组 动态规划
// 👍 744 👎 0

package leetcode.editor.cn;

//Java：Best Time to Buy and Sell Stock III
public class P123BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new P123BestTimeToBuyAndSellStockIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int[][][] dp = new int[prices.length][3][2];
            dp[0][1][1] = -prices[0];
            dp[0][2][1] = Integer.MIN_VALUE;
            for (int i = 1; i < prices.length; i++) {
                //如果今天要持有股票，应该比较继续持有昨天的股票好，还是今天才开始买股票好
                //(此时只交易了一次，所以是今天才买入的)
                dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
                //如果今天持有现金，应该比较昨天持有现金好，还是昨天持有股票加上今天的股价好
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
                //如果今天要持有股票，应该比较继续持有昨天股票好，还是今天才开始买股票好
                //(此时交易了两次，所以用昨天的现金买股票)
                dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
                //如果今天要持有现金，应该比较昨天持有现金好，还是昨天持有股票加上今天的股价好
                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            }
            return Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][2][0]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



