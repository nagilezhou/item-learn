//You are given an array prices where prices[i] is the price of a given stock on
// the ith day.
//
// Find the maximum profit you can achieve. You may complete as many transaction
//s as you like (i.e., buy one and sell one share of the stock multiple times) wit
//h the following restrictions:
//
//
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldo
//wn one day).
//
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again).
//
//
// Example 1:
//
//
//Input: prices = [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
//
//
// Example 2:
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
// 1 <= prices.length <= 5000
// 0 <= prices[i] <= 1000
//
// Related Topics å¨æè§å
// ð 766 ð 0

package leetcode.editor.cn;

//Javaï¼Best Time to Buy and Sell Stock with Cooldown dp
// 2021-08-07 review 1
public class P309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 0) {
                return 0;
            }
            int n = prices.length;
            int[][] dp = new int[n][3];
            dp[0][0] = -prices[0];
            // dp[i][0]: æä¸ææè¡ç¥¨çæå¤§æ¶ç
            // dp[i][1]: æä¸ä¸ææè¡ç¥¨ï¼å¹¶ä¸å¤äºå·å»æä¸­çç´¯è®¡æå¤§æ¶ç
            // dp[i][2]: æä¸ä¸ææè¡ç¥¨ï¼å¹¶ä¸ä¸å¨å·å»æä¸­çç´¯è®¡æå¤§æ¶ç
            for (int i = 1; i < n; i++) {
                // ä¹åä¹°çè¡ç¥¨,æèä»å¤©ä¹°çè¡ç¥¨
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
            return Math.max(dp[n - 1][1], dp[n - 1][2]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



