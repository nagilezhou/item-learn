//Given an m x n binary matrix filled with 0's and 1's, find the largest square
//containing only 1's and return its area.
//
//
// Example 1:
//
//
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
//
//
// Example 2:
//
//
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
//
//
// Example 3:
//
//
//Input: matrix = [["0"]]
//Output: 0
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] is '0' or '1'.
//
// Related Topics 动态规划
// 👍 760 👎 0

package leetcode.editor.cn;

//Java：Maximal Square dp
// 2021-08-14 review 1
public class P221MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new P221MaximalSquare().new Solution();
        // TO TEST
        char[][] test = new char[][] {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}};
        System.out.println(solution.maximalSquare(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int rowLength = matrix.length;
            int colLength = matrix[0].length;
            int dp[][] = new int[rowLength][colLength];
            int res = 0;
            for (int row = 0; row < rowLength; row++) {
                for (int col = 0; col < colLength; col++) {
                    if (matrix[row][col] == '1') {
                        if(row == 0 || col == 0){
                            dp[row][col] = 1;
                        }else {
                            dp[row][col] = Math.min(dp[row - 1][col], Math.min(dp[row - 1][col - 1], dp[row][col - 1])) + 1;
                        }
                        res = Math.max(res, dp[row][col]);
                    }
                }
            }
            return res * res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



