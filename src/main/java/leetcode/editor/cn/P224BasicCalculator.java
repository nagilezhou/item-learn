//Given a string s representing a valid expression, implement a basic calculator
// to evaluate it, and return the result of the evaluation.
//
// Note: You are not allowed to use any built-in function which evaluates string
//s as mathematical expressions, such as eval().
//
//
// Example 1:
//
//
//Input: s = "1 + 1"
//Output: 2
//
//
// Example 2:
//
//
//Input: s = " 2-1 + 2 "
//Output: 3
//
//
// Example 3:
//
//
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 3 * 105
// s consists of digits, '+', '-', '(', ')', and ' '.
// s represents a valid expression.
// '+' is not used as a unary operation.
// '-' could be used as a unary operation but it has to be inside parentheses.
// There will be no two consecutive operators in the input.
// Every number and running calculation will fit in a signed 32-bit integer.
//
// Related Topics 栈 递归 数学 字符串
// 👍 610 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Java：Basic Calculator 栈
// 2021-08-14 review 1
public class P224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new P224BasicCalculator().new Solution();
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            // 存放所有的数字
            Deque<Integer> numsStack = new LinkedList<>();
            // 为了防止第一个数为负数，先往 numsStack 加个 0
            numsStack.push(0);
            // 将所有的空格去掉
            s = s.replaceAll(" ", "");
            // 存放所有的操作，包括 +/-
            Deque<Character> opsStack = new LinkedList<>();
            int n = s.length();
            char[] cs = s.toCharArray();
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if (c == '(') {
                    opsStack.push(c);
                } else if (c == ')') {
                    // 计算到最近一个左括号为止
                    while (!opsStack.isEmpty()) {
                        char op = opsStack.peek();
                        if (op != '(') {
                            calc(numsStack, opsStack);
                        } else {
                            opsStack.poll();
                            break;
                        }
                    }
                } else if (isNum(c)) {
                        int u = 0;
                        int j = i;
                        // 将从 i 位置开始后面的连续数字整体取出，加入 numsStack
                        while (j < n && isNum(cs[j])) {
                            u = u * 10 + (int)(cs[j++] - '0');
                        }
                        numsStack.push(u);
                        i = j - 1;
                    } else {
                        if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                            numsStack.push(0);
                        }
                        // 有一个新操作要入栈时，先把栈内可以算的都算了
                        while (!opsStack.isEmpty() && opsStack.peek() != '(') {
                            calc(numsStack, opsStack);
                        }
                        opsStack.push(c);
                    }
                }

            while (!opsStack.isEmpty()) { calc(numsStack, opsStack); }
            return numsStack.peek();
        }

        void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2) { return; }
            if (ops.isEmpty()) { return; }
            int b = nums.poll(), a = nums.poll();
            char op = ops.poll();
            nums.push(op == '+' ? a + b : a - b);
        }

        boolean isNum(char c) {
            return Character.isDigit(c);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
            put('%', 2);
            put('^', 3);
        }};
        public int calculate(String s) {
            s = s.replaceAll(" ", "");
            char[] cs = s.toCharArray();
            int n = s.length();
            Deque<Integer> nums = new ArrayDeque<>();
            nums.addLast(0);
            Deque<Character> ops = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if (c == '(') {
                    ops.addLast(c);
                } else if (c == ')') {
                    while (!ops.isEmpty()) {
                        if (ops.peekLast() != '(') {
                            calc(nums, ops);
                        } else {
                            ops.pollLast();
                            break;
                        }
                    }
                } else {
                    if (isNumber(c)) {
                        int u = 0;
                        int j = i;
                        while (j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
                        nums.addLast(u);
                        i = j - 1;
                    } else {
                        if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                            nums.addLast(0);
                        }
                        while (!ops.isEmpty() && ops.peekLast() != '(') {
                            char prev = ops.peekLast();
                            if (map.get(prev) >= map.get(c)) {
                                calc(nums, ops);
                            } else {
                                break;
                            }
                        }
                        ops.addLast(c);
                    }
                }
            }
            while (!ops.isEmpty() && ops.peekLast() != '(') calc(nums, ops);
            return nums.peekLast();
        }
        void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2) return;
            if (ops.isEmpty()) return;
            int b = nums.pollLast(), a = nums.pollLast();
            char op = ops.pollLast();
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
            nums.addLast(ans);
        }
        boolean isNumber(char c) {
            return Character.isDigit(c);
        }
    }


}



