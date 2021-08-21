//You are given an integer array prices where prices[i] is the price of a given
//stock on the ith day, and an integer k.
//
// Find the maximum profit you can achieve. You may complete at most k transacti
//ons.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again).
//
//
// Example 1:
//
//
//Input: k = 2, prices = [2,4,1]
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit =
//4-2 = 2.
//
//
// Example 2:
//
//
//Input: k = 2, prices = [3,2,6,5,0,3]
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit =
//6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
//
//
//
// Constraints:
//
//
// 0 <= k <= 100
// 0 <= prices.length <= 1000
// 0 <= prices[i] <= 1000
//
// Related Topics 数组 动态规划
// 👍 555 👎 0

package leetcode.editor.cn;
//Java：Best Time to Buy and Sell Stock IV] dp
// 2021-08-07 review 1
public class P188BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
        Solution solution = new P188BestTimeToBuyAndSellStockIv().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][][] dp = new int[prices.length][k][2];
        dp[0][1][1] = -prices[0];
        for(int i = 2; i <= k; i++){
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < prices.length; i++) {
            for(int j = 1; j <= k; j++){
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j -1][0] - prices[i]);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            }

        }
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= k; i++){
            res = Math.max(res, dp[prices.length - 1][i][0]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



