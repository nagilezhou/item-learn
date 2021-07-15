//Given an integer n, return the count of all numbers with unique digits, x, whe
//re 0 <= x < 10n.
//
//
// Example 1:
//
//
//Input: n = 2
//Output: 91
//Explanation: The answer should be the total numbers in the range of 0 ≤ x < 10
//0, excluding 11,22,33,44,55,66,77,88,99
//
//
// Example 2:
//
//
//Input: n = 0
//Output: 1
//
//
//
// Constraints:
//
//
// 0 <= n <= 8
//
// Related Topics 数学 动态规划 回溯
// 👍 142 👎 0

package leetcode.editor.cn;

//Java：Count Numbers with Unique Digits
public class P357CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Solution solution = new P357CountNumbersWithUniqueDigits().new Solution();
        System.out.println(solution.countNumbersWithUniqueDigits(4));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] * 10 + (9 * (int)Math.pow(10, i - 2) - dp[i - 1]) * (i - 1);
            }
            int res = 0;
            for(int num : dp){
                res += num;
            }
            return (int)Math.pow(10, n) - res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



