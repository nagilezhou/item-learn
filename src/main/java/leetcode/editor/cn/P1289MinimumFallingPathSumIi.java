//Given a square grid of integers arr, a falling path with non-zero shifts is a
//choice of exactly one element from each row of arr, such that no two elements ch
//osen in adjacent rows are in the same column.
//
// Return the minimum sum of a falling path with non-zero shifts.
//
//
// Example 1:
//
//
//Input: arr = [[1,2,3],[4,5,6],[7,8,9]]
//Output: 13
//Explanation:
//The possible falling paths are:
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//The falling path with the smallest sum is [1,5,7], so the answer is 13.
//
//
//
// Constraints:
//
//
// 1 <= arr.length == arr[i].length <= 200
// -99 <= arr[i][j] <= 99
//
// Related Topics 数组 动态规划 矩阵
// 👍 45 👎 0

package leetcode.editor.cn;
//Java：Minimum Falling Path Sum II 矩阵 dp
// 2021-08-21 review 1
public class P1289MinimumFallingPathSumIi{
    public static void main(String[] args) {
        Solution solution = new P1289MinimumFallingPathSumIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int j1 = -1;
        int j2 = -1;
        int MAX = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];

        for(int j = 0; j < n; j++){
            int val = arr[0][j];
            dp[0][j] = arr[0][j];

            // 更新
            if (val < (j1 == -1 ? MAX : dp[0][j1])) {
                j2 = j1;
                j1 = j;
            } else if (val < (j2 == -1 ? MAX : dp[0][j2])) {
                j2 = j;
            }
        }

        for (int i = 1; i < n; i++) {
            int tj1 = -1, tj2 = -1;

            for (int j = 0; j < n; j++) {
                int val = arr[i][j];
                if(j == j1){
                    dp[i][j] = dp[i - 1][j2] + val;
                }else {
                    dp[i][j] = dp[i - 1][j1] + val;
                }

                if (dp[i][j] < (tj1 == -1 ? MAX : dp[i][tj1])) {
                    tj2 = tj1;
                    tj1 = j;
                } else if (dp[i][j] < (tj2 == -1 ? MAX : dp[i][tj2])) {
                    tj2 = j;
                }
            }
            j1 = tj1; j2 = tj2;
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



