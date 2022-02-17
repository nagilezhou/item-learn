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
            int n = grid.length;
            int m = grid[0].length;
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int num = grid[i][j];
                    if (i == 0 && j == 0) {
                        dp[i][j] = num;
                    } else if (i == 0) {
                        dp[i][j] = num + dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = num + dp[i - 1][j];
                    } else {
                        dp[i][j] = num + Math.min(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n - 1][m - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



