//We can scramble a string s to get a string t using the following algorithm:
//
//
// If the length of the string is 1, stop.
// If the length of the string is > 1, do the following:
//
// Split the string into two non-empty substrings at a random index, i.e., if th
//e string is s, divide it to x and y where s = x + y.
// Randomly decide to swap the two substrings or to keep them in the same order.
// i.e., after this step, s may become s = x + y or s = y + x.
// Apply step 1 recursively on each of the two substrings x and y.
//
//
//
//
// Given two strings s1 and s2 of the same length, return true if s2 is a scramb
//led string of s1, otherwise, return false.
//
//
// Example 1:
//
//
//Input: s1 = "great", s2 = "rgeat"
//Output: true
//Explanation: One possible scenario applied on s1 is:
//"great" --> "gr/eat" // divide at random index.
//"gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and
// keep them in order.
//"gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both subs
//trings. divide at ranom index each of them.
//"g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substri
//ng and to keep the second substring in the same order.
//"r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divi
//de "at" to "a/t".
//"r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substring
//s in the same order.
//The algorithm stops now and the result string is "rgeat" which is s2.
//As there is one possible scenario that led s1 to be scrambled to s2, we return
// true.
//
//
// Example 2:
//
//
//Input: s1 = "abcde", s2 = "caebd"
//Output: false
//
//
// Example 3:
//
//
//Input: s1 = "a", s2 = "a"
//Output: true
//
//
//
// Constraints:
//
//
// s1.length == s2.length
// 1 <= s1.length <= 30
// s1 and s2 consist of lower-case English letters.
//
// Related Topics 字符串 动态规划
// 👍 383 👎 0

package leetcode.editor.cn;

//Java：Scramble String
public class P87ScrambleString {
    public static void main(String[] args) {
        Solution solution = new P87ScrambleString().new Solution();
        System.out.println(solution.isScramble("abcdbdacbdac", "bdacabcdbdac"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dp
        public boolean isScramble(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            if (s1.length() != s2.length()) {
                return false;
            }
            int n = s1.length();
            char[] cs1 = s1.toCharArray();
            char[] cs2 = s2.toCharArray();
            boolean[][][] dp = new boolean[n][n][n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j][1] = cs1[i] == cs2[j];
                }
            }

            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    for (int j = 0; j <= n - len; j++) {
                        for (int k = 1; k < len; k++) {
                            boolean a = dp[i][j][k] && dp[i + k][j + k][len - k];
                            boolean b = dp[i][j + len - k][k] && dp[i + k][j][len - k];
                            if(a || b){
                                dp[i][j][len] = true;
                            }
                        }
                    }
                }
            }

            return dp[0][0][n];
        }

        // 递归备忘录
        String str1;
        String str2;
        int n;
        int[][][] cache;
        int N = -1, Y = 1, EMPTY = 0;

        public boolean isScramble2(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            if (s1.length() != s2.length()) {
                return false;
            }
            str1 = s1;
            str2 = s2;
            n = s1.length();
            cache = new int[n][n][n + 1];
            return dfs(0, 0, n);
        }

        private boolean dfs(int i, int j, int len) {
            if (cache[i][j][len] != EMPTY) {
                return cache[i][j][len] == Y;
            }
            String a = str1.substring(i, i + len);
            String b = str2.substring(j, j + len);
            if (a.equals(b)) {
                cache[i][j][len] = Y;
                return true;
            }
            if (!check(a, b)) {
                cache[i][j][len] = N;
                return false;
            }

            for (int k = 1; k < len; k++) {
                // 直接拼凑
                if (dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                    cache[i][j][len] = Y;
                    return true;
                }
                // 交换顺序拼凑
                if (dfs(i, j + len - k, k) && dfs(i + k, j, len - k)) {
                    cache[i][j][len] = Y;
                    return true;
                }
            }
            return false;
        }

        // 检查 s1 和 s2 词频是否相同
        private boolean check(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int n = s1.length();
            int[] cnt1 = new int[26], cnt2 = new int[26];
            char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
            for (int i = 0; i < n; i++) {
                cnt1[cs1[i] - 'a']++;
                cnt2[cs2[i] - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt1[i] != cnt2[i]) { return false; }
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



