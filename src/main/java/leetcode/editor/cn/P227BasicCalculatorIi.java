//Given a string s which represents an expression, evaluate this expression and
//return its value.
//
// The integer division should truncate toward zero.
//
// Note: You are not allowed to use any built-in function which evaluates string
//s as mathematical expressions, such as eval().
//
//
// Example 1:
// Input: s = "3+2*2"
//Output: 7
// Example 2:
// Input: s = " 3/2 "
//Output: 1
// Example 3:
// Input: s = " 3+5 / 2 "
//Output: 5
//
//
// Constraints:
//
//
// 1 <= s.length <= 3 * 105
// s consists of integers and operators ('+', '-', '*', '/') separated by some n
//umber of spaces.
// s represents a valid expression.
// All the integers in the expression are non-negative integers in the range [0,
// 231 - 1].
// The answer is guaranteed to fit in a 32-bit integer.
//
// Related Topics 栈 字符串
// 👍 395 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：Basic Calculator II
public class P227BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new P227BasicCalculatorIi().new Solution();
        System.out.println(solution.calculate("6/3"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Deque<Integer> stack = new LinkedList<>();
            int num = 0;
            char symbol = '+';
            for(int i = 0; i < s.length(); i++){
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
                    switch (symbol) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        default:
                            stack.push(stack.pop() / num);
                    }
                    symbol = s.charAt(i);
                    num = 0;
                }
            }

            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }


        private int getNumber(Deque<Character> numberStack) {
            int res = 0;
            int i = 0;
            while (!numberStack.isEmpty()) {
                res += i * 10 + numberStack.pop();
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



