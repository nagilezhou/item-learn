//Given two strings s and t, return the number of distinct subsequences of s whi
//ch equals t.
//
// A string's subsequence is a new string formed from the original string by del
//eting some (can be none) of the characters without disturbing the remaining char
//acters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC"
// is not).
//
// It is guaranteed the answer fits on a 32-bit signed integer.
//
//
// Example 1:
//
//
//Input: s = "rabbbit", t = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from S.
//rabbbit
//rabbbit
//rabbbit
//
//
// Example 2:
//
//
//Input: s = "babgbag", t = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from S.
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.
//
// Related Topics 字符串 动态规划
// 👍 548 👎 0

package leetcode.editor.cn;
//Java：Distinct Subsequences 动态规划 双字符串
// 2021-08-01 review 1
public class P115DistinctSubsequences{
    public static void main(String[] args) {
        Solution solution = new P115DistinctSubsequences().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        char[] ss = (" " + s).toCharArray();
        char[] tt = (" " + t).toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i - 1][j];
                if(ss[i] == tt[j]){
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



