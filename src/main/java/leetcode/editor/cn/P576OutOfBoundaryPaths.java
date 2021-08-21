//There is an m x n grid with a ball. The ball is initially at the position [sta
//rtRow, startColumn]. You are allowed to move the ball to one of the four adjacen
//t cells in the grid (possibly out of the grid crossing the grid boundary). You c
//an apply at most maxMove moves to the ball.
//
// Given the five integers m, n, maxMove, startRow, startColumn, return the numb
//er of paths to move the ball out of the grid boundary. Since the answer can be v
//ery large, return it modulo 109 + 7.
//
//
// Example 1:
//
//
//Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//Output: 6
//
//
// Example 2:
//
//
//Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//Output: 12
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 50
// 0 <= maxMove <= 50
// 0 <= startRow < m
// 0 <= startColumn < n
// Related Topics 动态规划
// 👍 127 👎 0

package leetcode.editor.cn;

//Java：Out of Boundary Paths dp
// 2021-08-21 review 1
public class P576OutOfBoundaryPaths {
    public static void main(String[] args) {
        Solution solution = new P576OutOfBoundaryPaths().new Solution();
        System.out.println(solution.findPaths(1, 3, 3, 0, 1));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            int mod = 1000000007;
            int[] di = {1, -1, 0, 0};
            int[] dj = {0, 0, 1, -1};
            int[][][] dp = new int[maxMove + 1][m][n];
            for (int move = 1; move <= maxMove; move++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int z = 0; z < di.length; z++) {
                            int row = i + di[z];
                            int col = j + dj[z];
                            if (row < 0 || row >= m || col < 0 || col >= n) {
                                dp[move][i][j] += 1;
                                continue;
                            }
                            dp[move][i][j] += dp[move - 1][row][col];
                            dp[move][i][j] %= mod;
                        }
                    }
                }
            }
            return dp[maxMove][startRow][startColumn];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



