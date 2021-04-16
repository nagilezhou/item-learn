//Given a string s, return the longest palindromic substring in s.
//
//
// Example 1:
//
//
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: s = "cbbd"
//Output: "bb"
//
//
// Example 3:
//
//
//Input: s = "a"
//Output: "a"
//
//
// Example 4:
//
//
//Input: s = "ac"
//Output: "a"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consist of only digits and English letters (lower-case and/or upper-case),
//
// Related Topics 字符串 动态规划
// 👍 3516 👎 0

package leetcode.editor.cn;
//Java：Longest Palindromic Substring
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();

        String s = "PATZJUUUUUJZTACCBCC";
        System.out.println(solution.longestPalindrome(s));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        int length = s.length();
        int begin = 0;
        int end = 0;
        int maxLength = 1;
        boolean dp[][] = new boolean[length][length];
        for(int i = 1; i < length; i++){
            for(int j = 0; j < i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])){
                    dp[j][i] = true;
                    if(i - j + 1 > maxLength){
                        begin = j;
                        end = i;
                        maxLength = i - j + 1;
                    }
                }
            }
        }
        return s.substring(begin,end + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



