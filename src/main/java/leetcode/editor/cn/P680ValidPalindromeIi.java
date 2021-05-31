//Given a string s, return true if the s can be palindrome after deleting at mos
//t one character from it.
//
//
// Example 1:
//
//
//Input: s = "aba"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
//
//
// Example 3:
//
//
//Input: s = "abc"
//Output: false
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s consists of lowercase English letters.
//
// Related Topics 字符串
// 👍 354 👎 0

package leetcode.editor.cn;

//Java：Valid Palindrome II
public class P680ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new P680ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome(
            "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int low = 0;
            int high = s.length() - 1;
            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                    boolean valid = false;
                    if (s.charAt(low + 1) == s.charAt(high)) {
                        valid = valid(s.substring(low + 1, high + 1));
                    }
                    if (s.charAt(high - 1) == s.charAt(low)) {
                        valid = valid || valid(s.substring(low, high));
                    }
                    return valid;
                }
                low++;
                high--;
            }
            return true;
        }

        private boolean valid(String s) {
            int low = 0;
            int high = s.length() - 1;
            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                    return false;
                }
                low++;
                high--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



