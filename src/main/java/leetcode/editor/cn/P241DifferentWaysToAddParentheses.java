//Given a string expression of numbers and operators, return all possible result
//s from computing all the different possible ways to group numbers and operators.
// You may return the answer in any order.
//
//
// Example 1:
//
//
//Input: expression = "2-1-1"
//Output: [0,2]
//Explanation:
//((2-1)-1) = 0
//(2-(1-1)) = 2
//
//
// Example 2:
//
//
//Input: expression = "2*3-4*5"
//Output: [-34,-14,-10,-10,10]
//Explanation:
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10
//
//
//
// Constraints:
//
//
// 1 <= expression.length <= 20
// expression consists of digits and the operator '+', '-', and '*'.
//
// Related Topics 分治算法
// 👍 373 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：Different Ways to Add Parentheses 记忆化dfs dp
// 2021-08-16 review 1
public class P241DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new P241DifferentWaysToAddParentheses().new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 正常分治
         * @param expression
         * @return
         */
        public List<Integer> diffWaysToCompute2(String expression) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (int l : left) {
                        for (int r : right) {
                            switch (c) {
                                case '+':
                                    res.add(l + r);
                                    break;
                                case '-':
                                    res.add(l - r);
                                    break;
                                case '*':
                                    res.add(l * r);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }
            if (res.isEmpty()) {
                res.add(Integer.valueOf(expression));
            }
            return res;
        }

        /**
         * 记忆化+分治
         */
        private Map<String, List<Integer>> map = new HashMap<>();
        public List<Integer> diffWaysToCompute3(String expression) {
            if(map.containsKey(expression)){
                return map.get(expression);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (int l : left) {
                        for (int r : right) {
                            switch (c) {
                                case '+':
                                    res.add(l + r);
                                    break;
                                case '-':
                                    res.add(l - r);
                                    break;
                                case '*':
                                    res.add(l * r);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }
            if (res.isEmpty()) {
                res.add(Integer.valueOf(expression));
            }
            map.put(expression, res);
            return res;
        }

        /**
         * 自底向上 迭代 动态规划
         * @param expression
         * @return
         */
        public List<Integer> diffWaysToCompute(String expression) {
            // TODO moxu
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



