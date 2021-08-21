//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below).
//
// The robot can only move either down or right at any point in time. The robot
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below).
//
// How many possible unique paths are there?
//
//
// Example 1:
//
//
//Input: m = 3, n = 7
//Output: 28
//
//
// Example 2:
//
//
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
//
//
// Example 3:
//
//
//Input: m = 7, n = 3
//Output: 28
//
//
// Example 4:
//
//
//Input: m = 3, n = 3
//Output: 6
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 100
// It's guaranteed that the answer will be less than or equal to 2 * 109.
//
// Related Topics 数组 动态规划
// 👍 957 👎 0

package leetcode.editor.cn;
//Java：Unique Paths 路径dp
// 2021-08-01 review 1
public class P62UniquePaths{
    public static void main(String[] args) {
        Solution solution = new P62UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(7,3));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        if(m <=0 || n <= 0){
            return -1;
        }
        int [][] dp = new int[m][n];
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 || col == 0){
                    dp[row][col] = 1;
                    continue;
                }
                dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
            }
        }
        return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



