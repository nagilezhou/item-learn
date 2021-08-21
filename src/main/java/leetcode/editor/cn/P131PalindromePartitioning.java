//Given a string s, partition s such that every substring of the partition is a
//palindrome. Return all possible palindrome partitioning of s.
//
// A palindrome string is a string that reads the same backward as forward.
//
//
// Example 1:
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2:
// Input: s = "a"
//Output: [["a"]]
//
//
// Constraints:
//
//
// 1 <= s.length <= 16
// s contains only lowercase English letters.
//
// Related Topics 深度优先搜索 动态规划 回溯算法
// 👍 738 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Palindrome Partitioning dp+回溯
// 2021-08-09 review 1
public class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        System.out.println(solution.partition("abababa"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> partition(String s) {
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j <= i; j++) {
                    if ((s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]))) {
                        dp[j][i] = true;
                    }
                }
            }
            List<List<String>> res = new ArrayList<>();
            List<String> ans = new ArrayList<>();
            backtrack(s, 0, dp, res, ans);
            return res;
        }

        public void backtrack(String s, int i, boolean[][] dp, List<List<String>> res, List<String> ans) {
            if (s.length() == i) {
                res.add(new ArrayList<>(ans));
                return;
            }
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    backtrack(s, j + 1, dp, res, ans);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



