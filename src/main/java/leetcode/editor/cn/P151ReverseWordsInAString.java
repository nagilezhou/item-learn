//Given an input string s, reverse the order of the words.
//
// A word is defined as a sequence of non-space characters. The words in s will
//be separated by at least one space.
//
// Return a string of the words in reverse order concatenated by a single space.
//
//
// Note that s may contain leading or trailing spaces or multiple spaces between
// two words. The returned string should only have a single space separating the w
//ords. Do not include any extra spaces.
//
//
// Example 1:
//
//
//Input: s = "the sky is blue"
//Output: "blue is sky the"
//
//
// Example 2:
//
//
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing space
//s.
//
//
// Example 3:
//
//
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single
//space in the reversed string.
//
//
// Example 4:
//
//
//Input: s = "  Bob    Loves  Alice   "
//Output: "Alice Loves Bob"
//
//
// Example 5:
//
//
//Input: s = "Alice does not even like bob"
//Output: "bob like even not does Alice"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s contains English letters (upper-case and lower-case), digits, and spaces '
//'.
// There is at least one word in s.
//
//
//
// Follow-up: If the string data type is mutable in your language, can you solve
// it in-place with O(1) extra space?
// Related Topics 字符串
// 👍 328 👎 0

package leetcode.editor.cn;
//Java：Reverse Words in a String
public class P151ReverseWordsInAString{
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);
        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

        public StringBuilder trimSpaces(String s) {
            int left = 0, right = s.length() - 1;
            // 去掉字符串开头的空白字符
            while (left <= right && s.charAt(left) == ' ') {
                ++left;
            }

            // 去掉字符串末尾的空白字符
            while (left <= right && s.charAt(right) == ' ') {
                --right;
            }

            // 将字符串间多余的空白字符去除
            StringBuilder sb = new StringBuilder();
            while (left <= right) {
                char c = s.charAt(left);

                if (c != ' ') {
                    sb.append(c);
                } else if (sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(c);
                }

                ++left;
            }
            return sb;
        }

        public void reverse(StringBuilder sb, int left, int right) {
            while (left < right) {
                char tmp = sb.charAt(left);
                sb.setCharAt(left++, sb.charAt(right));
                sb.setCharAt(right--, tmp);
            }
        }

        public void reverseEachWord(StringBuilder sb) {
            int n = sb.length();
            int start = 0, end = 0;

            while (start < n) {
                // 循环至单词的末尾
                while (end < n && sb.charAt(end) != ' ') {
                    ++end;
                }
                // 翻转单词
                reverse(sb, start, end - 1);
                // 更新start，去找下一个单词
                start = ++end;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}



