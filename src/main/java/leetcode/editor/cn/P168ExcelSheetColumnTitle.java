//Given an integer columnNumber, return its corresponding column title as it app
//ears in an Excel sheet.
//
// For example:
//
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//
//
//
// Example 1:
//
//
//Input: columnNumber = 1
//Output: "A"
//
//
// Example 2:
//
//
//Input: columnNumber = 28
//Output: "AB"
//
//
// Example 3:
//
//
//Input: columnNumber = 701
//Output: "ZY"
//
//
//
// Constraints:
//
//
// 1 <= columnNumber <= 231 - 1
//
// Related Topics 数学 字符串
// 👍 500 👎 0

package leetcode.editor.cn;
//Java：Excel Sheet Column Title
public class P168ExcelSheetColumnTitle{
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        System.out.println(solution.convertToTitle(2147483647));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



