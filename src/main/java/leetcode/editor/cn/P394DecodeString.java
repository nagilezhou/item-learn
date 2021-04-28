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

import java.util.Deque;
import java.util.LinkedList;

//Java：Decode String
public class P394DecodeString{
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //public String decodeString(String s) {
        //    if (s == null || s.length() == 0) {
        //        return s;
        //    }
        //    StringBuilder result = new StringBuilder();
        //    int multi = 0;
        //    Deque<StringBuilder> strStack = new LinkedList<>();
        //    Deque<Integer> numStack = new LinkedList<>();
        //    for (char c : s.toCharArray()) {
        //        if (c >= 'a' && c <= 'z') {
        //            result.append(c);
        //        }
        //        if (c >= '0' && c <= '9') {
        //            multi = multi * 10 + Integer.parseInt(String.valueOf(c));
        //        }
        //        if ('[' == c) {
        //            numStack.push(multi);
        //            strStack.push(new StringBuilder(result));
        //            multi = 0;
        //            result = new StringBuilder();
        //        }
        //        if (']' == c) {
        //            StringBuilder temp = new StringBuilder();
        //            int repeatNum = numStack.pop();
        //            for (int i = 0; i < repeatNum; i++) {
        //                temp.append(result);
        //            }
        //            result = new StringBuilder(strStack.pop().append(temp));
        //        }
        //    }
        //    return result.toString();
        //}

        //public String decodeString(String s) {
        //    return recursionDecodeString(s, 0)[0];
        //}

        //public String [] recursionDecodeString(String s, int length){
        //
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}



