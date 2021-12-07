//You are given an m x n integer matrix grid, and three integers row, col, and c
//olor. Each value in the grid represents the color of the grid square at that loc
//ation.
//
// Two squares belong to the same connected component if they have the same colo
//r and are next to each other in any of the 4 directions.
//
// The border of a connected component is all the squares in the connected compo
//nent that are either 4-directionally adjacent to a square not in the component,
//or on the boundary of the grid (the first or last row or column).
//
// You should color the border of the connected component that contains the squa
//re grid[row][col] with color.
//
// Return the final grid.
//
//
// Example 1:
// Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//Output: [[3,3],[3,2]]
// Example 2:
// Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//Output: [[1,3,3],[2,3,3]]
// Example 3:
// Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//Output: [[2,2,2],[2,1,2],[2,2,2]]
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// 1 <= grid[i][j], color <= 1000
// 0 <= row < m
// 0 <= col < n
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵
// 👍 111 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：Coloring A Border
public class P1034ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new P1034ColoringABorder().new Solution();
        int[][] test = new int[][] {{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};
        System.out.println(Arrays.deepToString(solution.colorBorder(test, 1, 3, 1)));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int n = grid.length;
            int m = grid[0].length;
            int[] di = new int[] {0, 0, 1, -1};
            int[] dj = new int[] {-1, 1, 0, 0};
            List<int[]> borderList = new ArrayList<>();
            boolean[][] visited = new boolean[n][m];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {row, col});
            visited[row][col] = true;
            int assignColor = grid[row][col];
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int nextRow = temp[0];
                int nextCol = temp[1];

                int borderSize = 0;
                for (int z = 0; z < 4; z++) {
                    int ni = nextRow + di[z];
                    int nj = nextCol + dj[z];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m  && grid[ni][nj] == assignColor) {
                        if(!visited[ni][nj]){
                            queue.offer(new int[] {ni, nj});
                            visited[ni][nj] = true;
                        }
                        borderSize++;
                    }
                }
                if (borderSize < 4) {
                    borderList.add(new int[]{nextRow, nextCol});
                }
            }
            for(int[] border : borderList){
                grid[border[0]][border[1]] = color;
            }
            return grid;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



