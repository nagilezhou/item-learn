//Convert a non-negative integer num to its English words representation.
//
//
// Example 1:
//
//
//Input: num = 123
//Output: "One Hundred Twenty Three"
//
//
// Example 2:
//
//
//Input: num = 12345
//Output: "Twelve Thousand Three Hundred Forty Five"
//
//
// Example 3:
//
//
//Input: num = 1234567
//Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
//"
//
//
//
// Constraints:
//
//
// 0 <= num <= 231 - 1
//
// Related Topics 递归 数学 字符串
// 👍 260 👎 0

package leetcode.editor.cn;

//Java：Integer to English Words
public class P273IntegerToEnglishWords {

    public static void main(String[] args) {
        Solution solution = new P273IntegerToEnglishWords().new Solution();
        System.out.println(solution.numberToWords(234325234));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] num2str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] num2str_medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        String[] num2str_large = {
            "Billion", "Million", "Thousand", "",
        };

        String num2Str(int x) {
            String ans = "";
            if (x >= 100) {
                ans += num2str_small[x / 100] + " Hundred ";
                x %= 100;
            }
            if (x >= 20) {
                ans += num2str_medium[x / 10] + " ";
                x %= 10;
            }
            if (x != 0) { ans += num2str_small[x] + " "; }
            return ans;
        }

        public String numberToWords(int num) {
            if (num == 0) { return num2str_small[0]; }
            StringBuilder sb = new StringBuilder();
            // 十亿 百万 千 null
            for (int i = (int)1e9, j = 0; i >= 1; i /= 1000, j++) {
                if (num < i) { continue; }
                sb.append(num2Str(num / i) + num2str_large[j] + " ");
                num %= i;
            }
            while (sb.charAt(sb.length() - 1) == ' ') { sb.deleteCharAt(sb.length() - 1); }
            return sb.toString();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



