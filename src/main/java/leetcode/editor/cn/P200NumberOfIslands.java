//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '
//0's (water), return the number of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water.
//
//
// Example 1:
//
//
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
//
//
// Example 2:
//
//
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 1181 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：Number of Islands bfs
// 2021-08-12 review 1
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands2(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[] di = new int[] {0, 0, 1, -1};
            int[] dj = new int[] {-1, 1, 0, 0};
            boolean[][] visited = new boolean[n][m];
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        if (visited[i][j]) {
                            continue;
                        }
                        res++;
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
                                if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj] && grid[ni][nj] == '1') {
                                    queue.offer(new int[] {ni, nj});
                                    visited[ni][nj] = true;
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }


        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        res++;
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] grid, int r, int c) {
            // 判断 base case
            if (!inArea(grid, r, c)) {
                return;
            }
            // 如果这个格子不是岛屿，直接返回
            if (grid[r][c] != '1') {
                return;
            }
            grid[r][c] = '2'; // 将格子标记为「已遍历过」

            // 访问上、下、左、右四个相邻结点
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }

        // 判断坐标 (r, c) 是否在网格中
        private boolean inArea(char[][] grid, int r, int c) {
            return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



