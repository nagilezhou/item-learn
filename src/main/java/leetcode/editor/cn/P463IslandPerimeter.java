//You are given row x col grid representing a map where grid[i][j] = 1 represent
//s land and grid[i][j] = 0 represents water.
//
// Grid cells are connected horizontally/vertically (not diagonally). The grid i
//s completely surrounded by water, and there is exactly one island (i.e., one or
//more connected land cells).
//
// The island doesn't have "lakes", meaning the water inside isn't connected to
//the water around the island. One cell is a square with side length 1. The grid i
//s rectangular, width and height don't exceed 100. Determine the perimeter of the
// island.
//
//
// Example 1:
//
//
//Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//Output: 16
//Explanation: The perimeter is the 16 yellow stripes in the image above.
//
//
// Example 2:
//
//
//Input: grid = [[1]]
//Output: 4
//
//
// Example 3:
//
//
//Input: grid = [[1,0]]
//Output: 4
//
//
//
// Constraints:
//
//
// row == grid.length
// col == grid[i].length
// 1 <= row, col <= 100
// grid[i][j] is 0 or 1.
// There is exactly one island in grid.
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵
// 👍 504 👎 0

package leetcode.editor.cn;
//Java：Island Perimeter
public class P463IslandPerimeter{
    public static void main(String[] args) {
        Solution solution = new P463IslandPerimeter().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, 1, -1};
        public int islandPerimeter(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            int res = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(grid[i][j] == 1){
                        res = dfs(grid, i , j);
                        break;
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int row, int col){
            if(check(grid, row, col)){
                return 1;
            }
            if(grid[row][col] == 0){
                return 1;
            }
            if(grid[row][col] != 1){
                return 0;
            }
            grid[row][col] = 2;
            int res = 0;
            for(int i = 0; i < 4; i++){
                res += dfs(grid, row + di[i], col + dj[i]);
            }
            return res;
        }

        private boolean check(int[][] grid, int row, int col){
            if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
                return true;
            }
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}



