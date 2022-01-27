//Given a m x n matrix mat and an integer k, return a matrix answer where each a
//nswer[i][j] is the sum of all elements mat[r][c] for:
//
//
// i - k <= r <= i + k,
// j - k <= c <= j + k, and
// (r, c) is a valid position in the matrix.
//
//
//
// Example 1:
//
//
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//Output: [[12,21,16],[27,45,33],[24,39,28]]
//
//
// Example 2:
//
//
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//Output: [[45,45,45],[45,45,45],[45,45,45]]
//
//
//
// Constraints:
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n, k <= 100
// 1 <= mat[i][j] <= 100
//
// Related Topics 数组 矩阵 前缀和
// 👍 125 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Matrix Block Sum
public class P1314MatrixBlockSum {
    public static void main(String[] args) {
        Solution solution = new P1314MatrixBlockSum().new Solution();
        System.out.println(
            Arrays.deepToString(solution.matrixBlockSum(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1)));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int[][] preSum = new int[mat.length][mat[0].length];
            for (int row = 0; row < preSum.length; row++) {
                for (int col = 0; col < preSum[row].length; col++) {
                    preSum[row][col] = getMatrixNum(preSum, row - 1, col)
                        + getMatrixNum(preSum, row, col - 1)
                        - getMatrixNum(preSum, row - 1, col - 1)
                        + mat[row][col];
                }
            }

            int[][] answer = new int[mat.length][mat[0].length];
            for (int row = 0; row < answer.length; row++) {
                for (int col = 0; col < answer[row].length; col++) {
                    answer[row][col] = getPreSumMatrixNum(preSum, row + k, col + k)
                        + getPreSumMatrixNum(preSum, row - k - 1, col - k - 1)
                        - getPreSumMatrixNum(preSum, row + k, col - k - 1)
                        - getPreSumMatrixNum(preSum, row - k - 1, col + k);
                }
            }
            return answer;
        }

        public int getMatrixNum(int[][] matrix, int row, int col) {
            if (row < 0 || col < 0) {
                return 0;
            }
            return matrix[row][col];
        }

        public int getPreSumMatrixNum(int[][] matrix, int row, int col) {
            if (row < 0 || col < 0) {
                return 0;
            }
            row = row > matrix.length - 1 ? matrix.length - 1 : row;
            col = col > matrix[row].length - 1 ? matrix[row].length - 1 : col;
            return matrix[row][col];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



