//Given two non-negative longegers, num1 and num2 represented as string, return t
//he sum of num1 and num2 as a string.
//
// You must solve the problem without using any built-in library for handling la
//rge longegers (such as Biglongeger). You must also not convert the inputs to longeg
//ers directly.
//
//
// Example 1:
//
//
//Input: num1 = "11", num2 = "123"
//Output: "134"
//
//
// Example 2:
//
//
//Input: num1 = "456", num2 = "77"
//Output: "533"
//
//
// Example 3:
//
//
//Input: num1 = "0", num2 = "0"
//Output: "0"
//
//
//
// Constralongs:
//
//
// 1 <= num1.length, num2.length <= 104
// num1 and num2 consist of only digits.
// num1 and num2 don't have any leading zeros except for the zero itself.
//
// Related Topics 数学 字符串 模拟
// 👍 386 👎 0

package leetcode.editor.cn;

//Java：Add Strings 字符串
// 2021-08-21 review 1
public class P415AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        System.out.println(solution.addStrings("6913259244","71103343"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int n = num1.length() - 1;
            int m = num2.length() - 1;
            int carry = 0;
            StringBuilder res = new StringBuilder();
            while (n >= 0 || m >= 0) {
                int count = 0;
                if (n >= 0) {
                    count += getNum(num1.charAt(n));
                    n--;
                }
                if (m >= 0) {
                    count += getNum(num2.charAt(m));
                    m--;
                }
                count += carry;
                carry = count / 10;
                res.append(count % 10);
            }
            if(carry == 1){
                res.append(1);
            }
            return res.reverse().toString();
        }

        private int getNum(char c) {
            return c - '0';
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



