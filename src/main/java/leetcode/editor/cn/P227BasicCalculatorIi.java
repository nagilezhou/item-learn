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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Java：Basic Calculator II 栈
// 2021-08-14 review 1
public class P227BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new P227BasicCalculatorIi().new Solution();
        System.out.println(solution.calculate("3 + 2 * 5"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 使用 map 维护一个运算符优先级
        // 这里的优先级划分按照「数学」进行划分即可
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
            put('%', 2);
            put('^', 3);
        }};

        public int calculate(String s) {
            // 将所有的空格去掉
            s = s.replaceAll(" ", "");
            char[] cs = s.toCharArray();
            int n = s.length();
            // 存放所有的数字
            Deque<Integer> numsStack = new LinkedList<>();
            // 为了防止第一个数为负数，先往 numsStack 加个 0
            numsStack.push(0);
            // 存放所有「非数字以外」的操作
            Deque<Character> opsStack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if (c == '(') {
                    opsStack.push(c);
                } else if (c == ')') {
                    // 计算到最近一个左括号为止
                    while (!opsStack.isEmpty()) {
                        if (opsStack.peek() != '(') {
                            calc(numsStack, opsStack);
                        } else {
                            opsStack.poll();
                            break;
                        }
                    }
                } else {
                    if (isNumber(c)) {
                        int u = 0;
                        int j = i;
                        // 将从 i 位置开始后面的连续数字整体取出，加入 numsStack
                        while (j < n && isNumber(cs[j])) { u = u * 10 + (cs[j++] - '0'); }
                        numsStack.push(u);
                        i = j - 1;
                    } else {
                        if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                            numsStack.push(0);
                        }
                        // 有一个新操作要入栈时，先把栈内可以算的都算了
                        // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                        while (!opsStack.isEmpty() && opsStack.peek() != '(') {
                            char prev = opsStack.peek();
                            if (map.get(prev) >= map.get(c)) {
                                calc(numsStack, opsStack);
                            } else {
                                break;
                            }
                        }
                        opsStack.push(c);
                    }
                }
            }
            // 将剩余的计算完
            while (!opsStack.isEmpty()) { calc(numsStack, opsStack); }
            return numsStack.peek();
        }

        void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2) { return; }
            if (ops.isEmpty()) { return; }
            int b = nums.poll(), a = nums.poll();
            char op = ops.poll();
            int ans = 0;
            if (op == '+') {
                ans = a + b;
            } else if (op == '-') {
                ans = a - b;
            } else if (op == '*') {
                ans = a * b;
            } else if (op == '/') {
                ans = a / b;
            } else if (op == '^') {
                ans = (int)Math.pow(a, b);
            } else if (op == '%') {
                ans = a % b;
            }
            nums.push(ans);
        }

        boolean isNumber(char c) {
            return Character.isDigit(c);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}



