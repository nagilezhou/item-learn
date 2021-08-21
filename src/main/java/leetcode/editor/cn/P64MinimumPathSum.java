//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right, which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
//
// Example 1:
//
//
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//
//
// Example 2:
//
//
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics 数组 动态规划
// 👍 884 👎 0

package leetcode.editor.cn;

//Java：Minimum Path Sum 路径dp
// 2021-08-01 review 1
public class P64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int rowLength = grid.length;
            int colLength = grid[0].length;
            int[][] dp = new int[rowLength][colLength];
            dp[0][0] = grid[0][0];
            for (int row = 0; row < rowLength; row++) {
                for (int col = 0; col < colLength; col++) {
                    if (row == 0 && col == 0) {
                        continue;
                    }
                    if (row == 0) {
                        dp[row][col] = dp[row][col - 1] + grid[row][col];
                    } else if (col == 0) {
                        dp[row][col] += dp[row - 1][col] + grid[row][col];
                    } else {
                        dp[row][col] = Math.min(dp[row][col - 1], dp[row - 1][col]) + grid[row][col];
                    }
                }
            }
            return dp[rowLength - 1][colLength - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



