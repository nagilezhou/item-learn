//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*' where:
//
//
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
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
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore,
//by repeating 'a' once, it becomes "aa".
//
//
// Example 3:
//
//
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
//
//
// Example 4:
//
//
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
//
//
// Example 5:
//
//
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 20
// 0 <= p.length <= 30
// s contains only lowercase English letters.
// p contains only lowercase English letters, '.', and '*'.
// It is guaranteed for each appearance of the character '*', there will be a pr
//evious valid character to match.
//
// Related Topics 字符串 动态规划 回溯算法
// 👍 2088 👎 0

package leetcode.editor.cn;

//Java：Regular Expression Matching
public class P10RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) != '*') {
                        dp[i][j] = dp[i - 1][j - 1] && p.charAt(j - 1) == s.charAt(i - 1);
                    } else if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                    }
                }
            }
            return dp[m][n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



