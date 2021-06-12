//Given a string s and an integer k, reverse the first k characters for every 2k
// characters counting from the start of the string.
//
// If there are fewer than k characters left, reverse all of them. If there are
//less than 2k but greater than or equal to k characters, then reverse the first k
// characters and left the other as original.
//
//
// Example 1:
// Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
// Example 2:
// Input: s = "abcd", k = 2
//Output: "bacd"
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of only lowercase English letters.
// 1 <= k <= 104
//
// Related Topics 字符串
// 👍 126 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Reverse String II
public class P541ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new P541ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcdefg",2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            int start = 0;
            char[] c = s.toCharArray();
            while (start < s.length()) {
                int left = start;
                int right = Math.min(start + k - 1, (s.length() - 1));
                while (left < right) {
                    char temp = c[right];
                    c[right] = c[left];
                    c[left] = temp;
                    left++;
                    right--;
                }
                start += 2 * k;
            }
            return new String(c);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



