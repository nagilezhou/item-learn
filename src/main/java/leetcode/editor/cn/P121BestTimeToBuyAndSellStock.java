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
public class P121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int lowPrice = prices[0];
        for(int i = 0; i < prices.length; i++){
            int profit = prices[i] - lowPrice;
            if(profit >= 0){
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }else {
                lowPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



