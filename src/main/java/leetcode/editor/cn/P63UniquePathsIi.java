//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below).
//
// The robot can only move either down or right at any point in time. The robot
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below).
//
// Now consider if some obstacles are added to the grids. How many unique paths
//would there be?
//
// An obstacle and space is marked as 1 and 0 respectively in the grid.
//
//
// Example 1:
//
//
//Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//Output: 2
//Explanation: There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
//
//
// Example 2:
//
//
//Input: obstacleGrid = [[0,1],[0,0]]
//Output: 1
//
//
//
// Constraints:
//
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] is 0 or 1.
//
// Related Topics 数组 动态规划
// 👍 554 👎 0

package leetcode.editor.cn;
//Java：Unique Paths II 路径dp
// 2021-08-01 review 1
public class P63UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new P63UniquePathsIi().new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;
        int[][] dp = new int[rowLength][colLength];
        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){
                if(obstacleGrid[row][col] == 1){
                    continue;
                }
                if(row == 0 && col == 0){
                    dp[row][col] = obstacleGrid[row][col] == 1 ? 0 : 1;
                    continue;
                }
                if(row == 0){
                    dp[row][col] = dp[row][col - 1];
                    continue;
                }
                if(col == 0){
                    dp[row][col] = dp[row - 1][col];
                    continue;
                }
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[rowLength - 1][colLength - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



