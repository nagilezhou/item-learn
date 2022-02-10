//Given two integers representing the numerator and denominator of a fraction, r
//eturn the fraction in string format.
//
// If the fractional part is repeating, enclose the repeating part in parenthese
//s.
//
// If multiple answers are possible, return any of them.
//
// It is guaranteed that the length of the answer string is less than 104 for al
//l the given inputs.
//
//
// Example 1:
//
//
//Input: numerator = 1, denominator = 2
//Output: "0.5"
//
//
// Example 2:
//
//
//Input: numerator = 2, denominator = 1
//Output: "2"
//
//
// Example 3:
//
//
//Input: numerator = 4, denominator = 333
//Output: "0.(012)"
//
//
//
// Constraints:
//
//
// -231 <= numerator, denominator <= 231 - 1
// denominator != 0
//
// Related Topics 哈希表 数学 字符串
// 👍 354 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：Fraction to Recurring Decimal
public class P166FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new P166FractionToRecurringDecimal().new Solution();
        System.out.println(solution.fractionToDecimal(10, 3));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 转 long 计算，防止溢出
        long a = numerator, b = denominator;
        // 如果本身能够整除，直接返回计算结果
        if (a % b == 0) return String.valueOf(a / b);
        StringBuilder sb = new StringBuilder();
        // 如果其一为负数，先追加负号
        if (a * b < 0) sb.append('-');
        a = Math.abs(a); b = Math.abs(b);
        // 计算小数点前的部分，并将余数赋值给 a
        sb.append(String.valueOf(a / b) + ".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            // 记录当前余数所在答案的位置，并继续模拟除法运算
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



