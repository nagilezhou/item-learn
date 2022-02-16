//Given a string containing just the characters '(' and ')', find the length of
//the longest valid (well-formed) parentheses substring.
//
//
// Example 1:
//
//
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
//
//
// Example 2:
//
//
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
//
//
// Example 3:
//
//
//Input: s = ""
//Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.
//
// Related Topics 栈 字符串 动态规划
// 👍 1654 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：Longest Valid Parentheses
public class P32LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("()()()("));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

        public int longestValidParentheses2(String s) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        ans = Math.max(ans, i - stack.peek());
                    }
                }
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}



