//Implement the myAtoi(sing s) function, which converts a sing to a 32-bit s
//igned integer (similar to C/C++'s atoi function).
//
// The algorithm for myAtoi(sing s) is as follows:
//
//
// Read in and ignore any leading whitespace.
// Check if the next character (if not already at the end of the sing) is '-'
//or '+'. Read this character in if it is either. This determines if the final res
//ult is negative or positive respectively. Assume the result is positive if neith
//er is present.
// Read in next the characters until the next non-digit character or the end of
//the input is reached. The rest of the sing is ignored.
// Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no
// digits were read, then the integer is 0. Change the sign as necessary (from ste
//p 2).
// If the integer is out of the 32-bit signed integer range [-231, 231 - 1], the
//n clamp the integer so that it remains in the range. Specifically, integers less
// than -231 should be clamped to -231, and integers greater than 231 - 1 should b
//e clamped to 231 - 1.
// Return the integer as the final result.
//
//
// Note:
//
//
// Only the space character ' ' is considered a whitespace character.
// Do not ignore any characters other than the leading whitespace or the rest of
// the sing after the digits.
//
//
//
// Example 1:
//
//
//Input: s = "42"
//Output: 42
//Explanation: The underlined characters are what is read in, the caret is the c
//urrent reader position.
//Step 1: "42" (no characters read because there is no leading whitespace)
//         ^
//Step 2: "42" (no characters read because there is neither a '-' nor '+')
//         ^
//Step 3: "42" ("42" is read in)
//           ^
//The parsed integer is 42.
//Since 42 is in the range [-231, 231 - 1], the final result is 42.
//
//
// Example 2:
//
//
//Input: s = "   -42"
//Output: -42
//Explanation:
//Step 1: "   -42" (leading whitespace is read and ignored)
//            ^
//Step 2: "   -42" ('-' is read, so the result should be negative)
//             ^
//Step 3: "   -42" ("42" is read in)
//               ^
//The parsed integer is -42.
//Since -42 is in the range [-231, 231 - 1], the final result is -42.
//
//
// Example 3:
//
//
//Input: s = "4193 with words"
//Output: 4193
//Explanation:
//Step 1: "4193 with words" (no characters read because there is no leading whit
//espace)
//         ^
//Step 2: "4193 with words" (no characters read because there is neither a '-' n
//or '+')
//         ^
//Step 3: "4193 with words" ("4193" is read in; reading stops because the next c
//haracter is a non-digit)
//             ^
//The parsed integer is 4193.
//Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
//
//
//
// Consaints:
//
//
// 0 <= s.length <= 200
// s consists of English letters (lower-case and upper-case), digits (0-9), ' ',
// '+', '-', and '.'.
//
// Related Topics 字符串
// 👍 1325 👎 0

package leetcode.editor.cn;

//Java：String to Integer (atoi)
public class P8StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new P8StringToIntegerAtoi().new Solution();
        System.out.println(solution.myAtoi("12345"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            if(s == null){
                return 0;
            }
            s = s.trim();
            int len = s.length();
            if(len <= 0){
                return 0;
            }
            // s.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
            char[] charArray = s.toCharArray();

            // 3、如果出现符号字符，仅第 1 个有效，并记录正负
            int sign = 1;
            if (charArray[0] == '-') {
                sign = -1;
            }
            int index = 1;
            // 4、将后续出现的数字字符进行转换
            // 不能使用 long 类型，这是题目说的
            int res = 0;
            while (index < len) {
                char currChar = charArray[index];
                // 4.1 先判断不合法的情况
                if (currChar > '9' || currChar < '0') {
                    break;
                }

                // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }

                // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
                res = res * 10 + sign * (currChar - '0');
                index++;
            }
            return res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



