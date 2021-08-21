//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility)
//
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows:
//
//
//string convert(string s, int numRows);
//
//
//
// Example 1:
//
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//
//
// Example 2:
//
//
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//
//
// Example 3:
//
//
//Input: s = "A", numRows = 1
//Output: "A"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consists of English letters (lower-case and upper-case), ',' and '.'.
// 1 <= numRows <= 1000
//
// Related Topics 字符串
// 👍 1120 👎 0

package leetcode.editor.cn;

//Java：ZigZag Conversion
// 2021-07-28 review 1
public class P6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
        System.out.println(solution.convert("AB",1));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public String convert(String s, int numRows) {
            if (s == null || s.length() == 0 || numRows <= 0) {
                return null;
            }
            if(numRows == 1){
                return s;
            }
            Character[][] cnums = new Character[numRows][s.length()];
            int row = 0;
            int col = 0;
            boolean vertical = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cnums[row][col] = c;
                if (row == 0) {
                    vertical = true;
                }
                if (row == numRows - 1) {
                    vertical = false;
                }
                if (vertical) {
                    row++;
                } else {
                    row--;
                    col++;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Character[] cnum : cnums) {
                for (int j = 0; j < cnum.length; j++) {
                    if (cnum[j] != null) {
                        stringBuilder.append(cnum[j]);
                    }
                }
            }
            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



