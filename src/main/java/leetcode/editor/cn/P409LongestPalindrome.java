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

//Java：Longest Palindrome 贪心
public class P409LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new P409LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];
            int length = s.length();
            for (int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                count[c]++;
            }

            int ans = 0;
            for (int v : count) {
                ans += v / 2 * 2;
                if (v % 2 == 1 && ans % 2 == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



