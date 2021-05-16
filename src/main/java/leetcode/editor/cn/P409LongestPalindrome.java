//Given a string s which consists of lowercase or uppercase letters, return the
//length of the longest palindrome that can be built with those letters.
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome
//here.
//
//
// Example 1:
//
//
//Input: s = "abccccdd"
//Output: 7
//Explanation:
//One longest palindrome that can be built is "dccaccd", whose length is 7.
//
//
// Example 2:
//
//
//Input: s = "a"
//Output: 1
//
//
// Example 3:
//
//
//Input: s = "bb"
//Output: 2
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.
//
// Related Topics 哈希表
// 👍 293 👎 0

package leetcode.editor.cn;
//Java：Longest Palindrome
public class P409LongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new P409LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
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



