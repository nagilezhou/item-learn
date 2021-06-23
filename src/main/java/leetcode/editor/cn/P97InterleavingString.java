//Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
//s1 and s2.
//
// An interleaving of two strings s and t is a configuration where they are divi
//ded into non-empty substrings such that:
//
//
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 +
//t3 + s3 + ...
//
//
// Note: a + b is the concatenation of strings a and b.
//
//
// Example 1:
//
//
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//Output: true
//
//
// Example 2:
//
//
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//Output: false
//
//
// Example 3:
//
//
//Input: s1 = "", s2 = "", s3 = ""
//Output: true
//
//
//
// Constraints:
//
//
// 0 <= s1.length, s2.length <= 100
// 0 <= s3.length <= 200
// s1, s2, and s3 consist of lowercase English letters.
//
//
//
// Follow up: Could you solve it using only O(s2.length) additional memory space
//?
// Related Topics 字符串 动态规划
// 👍 471 👎 0

package leetcode.editor.cn;

//Java：Interleaving String
public class P97InterleavingString {
    public static void main(String[] args) {
        Solution solution = new P97InterleavingString().new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n = s1.length();
            int m = s2.length();
            int t = s3.length();
            if (n + m != t) {
                return false;
            }
            boolean[][] dp = new boolean[n + 1][m + 1];
            dp[0][0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    int p = i + j - 1;
                    if (i > 0) {
                        dp[i][j] = dp[i][j] || (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(p)));
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(p)));
                    }
                }
            }
            return dp[n][m];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



