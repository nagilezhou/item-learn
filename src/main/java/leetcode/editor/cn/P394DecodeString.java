//Given an encoded string, return its decoded string.
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the
//square brackets is being repeated exactly k times. Note that k is guaranteed to
//be a positive integer.
//
// You may assume that the input string is always valid; No extra white spaces,
//square brackets are well-formed, etc.
//
// Furthermore, you may assume that the original data does not contain any digit
//s and that digits are only for those repeat numbers, k. For example, there won't
// be input like 3a or 2[4].
//
//
// Example 1:
// Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
// Example 2:
// Input: s = "3[a2[c]]"
//Output: "accaccacc"
// Example 3:
// Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// Example 4:
// Input: s = "abc3[cd]xyz"
//Output: "abccdcdcdxyz"
//
//
// Constraints:
//
//
// 1 <= s.length <= 30
// s consists of lowercase English letters, digits, and square brackets '[]'.
// s is guaranteed to be a valid input.
// All the integers in s are in the range [1, 300].
//
// Related Topics 栈 深度优先搜索
// 👍 744 👎 0

package leetcode.editor.cn;

//Java：Decode String 栈 递归
// 2021-08-17 review 1
public class P394DecodeString {
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            return dfs(s, 0)[0];
        }

        private String[] dfs(String s, int i) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            while (i < s.length()) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                } else if (s.charAt(i) == '[') {
                    String[] tmp = dfs(s, i + 1);
                    i = Integer.parseInt(tmp[0]);
                    while (multi > 0) {
                        res.append(tmp[1]);
                        multi--;
                    }
                } else if (s.charAt(i) == ']') { return new String[] {String.valueOf(i), res.toString()}; } else {
                    res.append(s.charAt(i));
                }
                i++;
            }
            return new String[] {res.toString()};
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



