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

//Java：Regular Expression Matching dp
// 2021-07-28 review 1
public class P10RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("ab",".*"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            // 技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始，而且可以使得 f[0][0] = true，可以将 true 这个结果滚动下去
            int n = s.length(), m = p.length();
            s = " " + s;
            p = " " + p;
            char[] ss = s.toCharArray();
            char[] pp = p.toCharArray();
            // f(i,j) 代表考虑 s 中的 1~i 字符和 p 中的 1~j 字符 是否匹配
            boolean[][] dp = new boolean[n + 1][m + 1];
            dp[0][0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
                    if (j + 1 <= m && pp[j + 1] == '*') {
                        continue;
                    }

                    // 对应了 p[j] 为普通字符和 '.' 的两种情况
                    if (i - 1 >= 0 && pp[j] != '*') {
                        dp[i][j] = dp[i - 1][j - 1] && (ss[i] == pp[j] || pp[j] == '.');
                    } else if (pp[j] == '*') {
                        // 对应了 p[j] 为 '*' 的情况
                        if(i - 1 >= 0 && (ss[i] == pp[j - 1] || pp[j - 1] == '.')){
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                        }else {
                            dp[i][j] = j - 2 >= 0 && dp[i][j - 2];
                        }
                        //dp[i][j] = (j - 2 >= 0 && dp[i][j - 2]) || (i - 1 >= 0 && dp[i - 1][j] && (ss[i] == pp[j - 1] || pp[j - 1] == '.'));
                    }
                }
            }
            return dp[n][m];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



