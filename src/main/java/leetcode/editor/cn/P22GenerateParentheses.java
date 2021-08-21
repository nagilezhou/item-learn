//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
// Example 1:
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
//Output: ["()"]
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
// 👍 1820 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：Generate Parentheses
// 2021-07-30 review 1
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(3).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            List<Character> temp = new LinkedList<>();
            backtrack(0, 0, n, temp, res);
            return res;
        }

        public void backtrack(int leftSize, int rightSize, int n, List<Character> temp, List<String> res) {
            if (temp.size() == 2 * n) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : temp) {
                    stringBuilder.append(c);
                }
                res.add(stringBuilder.toString());
                return;
            }

            if (leftSize == 0 || leftSize == rightSize) {
                temp.add('(');
                backtrack(leftSize + 1, rightSize, n, temp, res);
                temp.remove(temp.size() - 1);
            } else if (leftSize == n) {
                temp.add(')');
                backtrack(leftSize , rightSize + 1, n, temp, res);
                temp.remove(temp.size() - 1);
            } else {
                temp.add('(');
                backtrack(leftSize + 1, rightSize, n, temp, res);
                temp.remove(temp.size() - 1);

                temp.add(')');
                backtrack(leftSize, rightSize + 1, n, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



