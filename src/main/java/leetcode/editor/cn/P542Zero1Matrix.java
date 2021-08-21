//Given an m x n binary matrix mat, return the distance of the nearest 0 for eac
//h cell.
//
// The distance between two adjacent cells is 1.
//
//
// Example 1:
//
//
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
//
//
// Example 2:
//
//
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
//
//
//
// Constraints:
//
//
// m == mat.length
// n == mat[row].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[row][col] is either 0 or 1.
// There is at least one 0 in mat.
//
// Related Topics 深度优先搜索 广度优先搜索
// 👍 418 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Java：01 Matrix 矩阵 bfs dp
// 2021-08-21 review 1
public class P542Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new P542Zero1Matrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix2(int[][] mat) {
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int m = mat.length, n = mat[0].length;
            int[][] dist = new int[m][n];
            boolean[][] seen = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<int[]>();
            // 将所有的 0 添加进初始队列中
            for (int row = 0; row < m; ++row) {
                for (int col = 0; col < n; ++col) {
                    if (mat[row][col] == 0) {
                        queue.offer(new int[] {row, col});
                        seen[row][col] = true;
                    }
                }
            }

            // 广度优先搜索
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for (int d = 0; d < 4; ++d) {
                    int ni = row + dirs[d][0];
                    int nj = col + dirs[d][1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                        dist[ni][nj] = dist[row][col] + 1;
                        queue.offer(new int[] {ni, nj});
                        seen[ni][nj] = true;
                    }
                }
            }
            return dist;
        }

        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = mat[i][j] == 0 ? 0 : 10000;
                }
            }

            // 从左上角开始
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
            // 从右下角开始
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i + 1 < m) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }
            return dp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



