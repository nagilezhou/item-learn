//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
//Input: s = "()"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: s = "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: s = "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: s = "{[]}"
//Output: true
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
//
// Related Topics 栈 字符串
// 👍 2362 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Java：Valid Parentheses
// 2021-07-30 review 1
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        System.out.println(solution.isValid("(("));
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();
            Map<Character, Character> map = new HashMap<>();
            map.put('(',')');
            map.put('[',']');
            map.put('{','}');
            int n = s.length();
            for(int i = 0; i < n; i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    stack.push(c);
                }else{
                    if(stack.isEmpty() || c != map.get(stack.pop())){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



