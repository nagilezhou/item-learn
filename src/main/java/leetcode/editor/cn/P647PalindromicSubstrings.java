//Given a string s, return the number of palindromic substrings in it.
//
// A string is a palindrome when it reads the same backward as forward.
//
// A substring is a contiguous sequence of characters within the string.
//
//
// Example 1:
//
//
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//
//
// Example 2:
//
//
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consists of lowercase English letters.
//
// Related Topics 字符串 动态规划
// 👍 576 👎 0

package leetcode.editor.cn;
//Java：Palindromic Substrings 字符串 dp
// 2021-08-21 review 1
public class P647PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new P647PalindromicSubstrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean dp[][] = new boolean[length][length];
        int res = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j <= i; j++){
                if((s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]))){
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



