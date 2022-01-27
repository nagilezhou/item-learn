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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

        //public List<List<String>> partition(String s) {
        //    int len = s.length();
        //    boolean[][] dp = new boolean[len][len];
        //    for (int i = 0; i < len; i++) {
        //        for (int j = 0; j <= i; j++) {
        //            if ((s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]))) {
        //                dp[j][i] = true;
        //            }
        //        }
        //    }
        //    List<List<String>> res = new ArrayList<>();
        //    List<String> ans = new ArrayList<>();
        //    backtrack(s, 0, dp, res, ans);
        //    return res;
        //}
        //
        //public void backtrack(String s, int i, boolean[][] dp, List<List<String>> res, List<String> ans) {
        //    if (s.length() == i) {
        //        res.add(new ArrayList<>(ans));
        //        return;
        //    }
        //    for (int j = i; j < s.length(); j++) {
        //        if (dp[i][j]) {
        //            ans.add(s.substring(i, j + 1));
        //            backtrack(s, j + 1, dp, res, ans);
        //            ans.remove(ans.size() - 1);
        //        }
        //    }
        //}

        public List<List<String>> partition(String s) {
            if(s == null){
                return null;
            }
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for(int i = n - 1; i >= 0; i--){
                for(int j = i; j < n; j++){
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }
            List<List<String>> res = new ArrayList<>();
            Deque<String> temp = new ArrayDeque<>();
            backtrack(0, s, dp, temp, res);
            return res;
        }


        private void backtrack(int start, String s, boolean[][] dp, Deque<String> temp, List<List<String>> res){
            if(start >= s.length()){
                res.add(new ArrayList<>(temp));
                return;
            }
            for(int i = start; i < s.length(); i++){
                if(dp[start][i]){
                    temp.addLast(s.substring(start, i + 1));
                    backtrack(i + 1, s, dp, temp, res);
                    temp.removeLast();
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



