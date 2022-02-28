//Under the grammar given below, strings can represent a set of lowercase words.
// Let R(expr) denote the set of words the expression represents.
//
// The grammar can best be understood through simple examples:
//
//
// Single letters represent a singleton set containing that word.
//
// R("a") = {"a"}
// R("w") = {"w"}
//
//
// When we take a comma-delimited list of two or more expressions, we take the u
//nion of possibilities.
//
// R("{a,b,c}") = {"a","b","c"}
// R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each w
//ord at most once)
//
//
// When we concatenate two expressions, we take the set of possible concatenatio
//ns between two words where the first word comes from the first expression and th
//e second word comes from the second expression.
//
// R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
// R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh
//", "acefg", "acefh"}
//
//
//
//
// Formally, the three rules for our grammar:
//
//
// For every lowercase letter x, we have R(x) = {x}.
// For expressions e1, e2, ... , ek with k >= 2, we have R({e1, e2, ...}) = R(e1
//) ∪ R(e2) ∪ ...
// For expressions e1 and e2, we have R(e1 + e2) = {a + b for (a, b) in R(e1) ×
//R(e2)}, where + denotes concatenation, and × denotes the cartesian product.
//
//
// Given an expression representing a set of words under the given grammar, retu
//rn the sorted list of words that the expression represents.
//
//
// Example 1:
//
//
//Input: expression = "{a,b}{c,{d,e}}"
//Output: ["ac","ad","ae","bc","bd","be"]
//
//
// Example 2:
//
//
//Input: expression = "{{a,z},a{b,c},{ab,z}}"
//Output: ["a","ab","ac","z"]
//Explanation: Each distinct word is written only once in the final answer.
//
//
//
// Constraints:
//
//
// 1 <= expression.length <= 60
// expression[i] consists of '{', '}', ','or lowercase English letters.
// The given expression represents a set of words based on the grammar given in
//the description.
//
// Related Topics 栈 广度优先搜索 字符串 回溯
// 👍 53 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Java：Brace Expansion II
public class P1096BraceExpansionIi{
    public static void main(String[] args) {
        Solution solution = new P1096BraceExpansionIi().new Solution();
        System.out.println(solution.braceExpansionII("{a,b}{c,{d,e}}"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.add(expression);

        Set<String> res = new HashSet<>();
        while (!queue.isEmpty()) {
            // 拿到需要处理的表达式
            String exp = queue.poll();


            // 如果表达式中没有 {，则将这个表达式加入结果中
            if (exp.indexOf("{") == -1) {
                res.add(exp);
                continue;
            }

            // 找到表达式中第一对 {}
            int i = 0;
            int left = 0;
            int right = 0;
            while (exp.charAt(i) != '}') {
                if (exp.charAt(i) == '{') left = i;
                i++;
            }
            right = i;


            // 拿到第一对括号中的前面部分 (不包括 {)
            String before = exp.substring(0, left);
            // 拿到第一对括号中的后面部分 (不包括 })
            String after = exp.substring(right + 1);
            // 按照 , 分割第一对括号中的元素 (不包括 {})
            String[] strs = exp.substring(left + 1, right).split(",");

            // 将 before 、 strs 中的每个元素以及 after 拼接成字符串放入到队列中，方便后面处理
            for (String str : strs) {
                StringBuilder sb = new StringBuilder();
                queue.add(sb.append(before).append(str).append(after).toString());
            }
        }
        // 结果处理
        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



