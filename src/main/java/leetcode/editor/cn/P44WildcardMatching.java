//Given an input string (s) and a pattern (p), implement wildcard pattern matchi
//ng with support for '?' and '*' where:
//
//
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
//
//
// The matching should cover the entire input string (not partial).
//
//
// Example 1:
//
//
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
//
//
// Example 2:
//
//
//Input: s = "aa", p = "*"
//Output: true
//Explanation: '*' matches any sequence.
//
//
// Example 3:
//
//
//Input: s = "cb", p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not mat
//ch 'b'.
//
//
// Example 4:
//
//
//Input: s = "adceb", p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' ma
//tches the substring "dce".
//
//
// Example 5:
//
//
//Input: s = "acdcb", p = "a*c?b"
//Output: false
//
//
//
// Constraints:
//
//
// 0 <= s.length, p.length <= 2000
// s contains only lowercase English letters.
// p contains only lowercase English letters, '?' or '*'.
//
// Related Topics 贪心 递归 字符串 动态规划
// 👍 709 👎 0

package leetcode.editor.cn;

//Java：Wildcard Matching
public class P44WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new P44WildcardMatching().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int n = s.length(), m = p.length();
            s = " " + s;
            p = " " + p;
            char[] ss = s.toCharArray();
            char[] pp = p.toCharArray();
            boolean[][] dp = new boolean[n + 1][m + 1];
            dp[0][0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (pp[j] == '*') {
                        dp[i][j] = dp[i][j - 1] || (i - 1 >= 0 && dp[i - 1][j]);
                    } else {
                        dp[i][j] = i - 1 >= 0 && dp[i - 1][j - 1] && (ss[i] == pp[j] || pp[j] == '?');
                    }
                }
            }
            return dp[n][m];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



