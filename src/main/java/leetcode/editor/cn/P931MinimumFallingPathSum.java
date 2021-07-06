//Given an n x n array of integers matrix, return the minimum sum of any falling
// path through matrix.
//
// A falling path starts at any element in the first row and chooses the element
// in the next row that is either directly below or diagonally left/right. Specifi
//cally, the next element from position (row, col) will be (row + 1, col - 1), (ro
//w + 1, col), or (row + 1, col + 1).
//
//
// Example 1:
//
//
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum underlined below:
//[[2,1,3],      [[2,1,3],
// [6,5,4],       [6,5,4],
// [7,8,9]]       [7,8,9]]
//
//
// Example 2:
//
//
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is underlined below:
//[[-19,57],
// [-40,-5]]
//
//
// Example 3:
//
//
//Input: matrix = [[-48]]
//Output: -48
//
//
//
// Constraints:
//
//
// n == matrix.length
// n == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 动态规划 矩阵
// 👍 97 👎 0

package leetcode.editor.cn;

//Java：Minimum Falling Path Sum
public class P931MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new P931MinimumFallingPathSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                dp[0][i] = matrix[0][i];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int val = matrix[i][j];
                    dp[i][j] = dp[i - 1][j] + val;
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + val);
                    }
                    if (j + 1 < n) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + val);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, dp[n - 1][i]);
            }
            return min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



