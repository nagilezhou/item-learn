//Given two non-negative integers num1 and num2 represented as strings, return t
//he product of num1 and num2, also represented as a string.
//
// Note: You must not use any built-in BigInteger library or convert the inputs
//to integer directly.
//
//
// Example 1:
// Input: num1 = "2", num2 = "3"
//Output: "6"
// Example 2:
// Input: num1 = "123", num2 = "456"
//Output: "56088"
//
//
// Constraints:
//
//
// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading zero, except the number 0 itsel
//f.
//
// Related Topics 数学 字符串 模拟
// 👍 835 👎 0

package leetcode.editor.cn;
//Java：Multiply Strings
public class P43MultiplyStrings{
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && result.length() == 0) continue;
            result.append(res[i]);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



