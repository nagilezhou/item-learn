//You are given an m x n binary matrix grid. An island is a group of 1's (repres
//enting land) connected 4-directionally (horizontal or vertical.) You may assume
//all four edges of the grid are surrounded by water.
//
// The area of an island is the number of cells with a value 1 in the island.
//
// Return the maximum area of an island in grid. If there is no island, return 0
//.
//
//
// Example 1:
//
//
//Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,
//0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,
//0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]
//]
//Output: 6
//Explanation: The answer is not 11, because the island must be connected 4-dire
//ctionally.
//
//
// Example 2:
//
//
//Input: grid = [[0,0,0,0,0,0,0,0]]
//Output: 0
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] is either 0 or 1.
//
// Related Topics 深度优先搜索 数组
// 👍 483 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：Max Area of Island 矩阵 bfs
// 2021-08-21 review 1
public class P695MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new P695MaxAreaOfIsland().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland2(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[] di = new int[] {0, 0, 1, -1};
            int[] dj = new int[] {-1, 1, 0, 0};
            boolean[][] visited = new boolean[n][m];
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        if (visited[i][j]) {
                            continue;
                        }
                        int tempVal = 1;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[] {i, j});
                        visited[i][j] = true;
                        while (!queue.isEmpty()) {
                            int[] temp = queue.poll();
                            int row = temp[0];
                            int col = temp[1];
                            for (int z = 0; z < 4; z++) {
                                int ni = row + di[z];
                                int nj = col + dj[z];
                                if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj] && grid[ni][nj] == 1) {
                                    queue.offer(new int[] {ni, nj});
                                    visited[ni][nj] = true;
                                    tempVal++;
                                }
                            }
                        }

                        res = Math.max(res, tempVal);
                    }
                }
            }
            return res;
        }


        public int maxAreaOfIsland(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                       res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int r, int c) {
            // 判断 base case
            if (!inArea(grid, r, c)) {
                return 0;
            }
            // 如果这个格子不是岛屿，直接返回
            if (grid[r][c] != 1) {
                return 0;
            }
            grid[r][c] = 2; // 将格子标记为「已遍历过」
            int res = 1;
            // 访问上、下、左、右四个相邻结点
            res += dfs(grid, r - 1, c);
            res += dfs(grid, r + 1, c);
            res += dfs(grid, r, c - 1);
            res += dfs(grid, r, c + 1);
            return res;
        }

        // 判断坐标 (r, c) 是否在网格中
        private boolean inArea(int[][] grid, int r, int c) {
            return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



