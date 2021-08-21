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

import java.util.Deque;
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
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;
            int[] row = {0, 0, 1, -1};
            int[] col = {1, -1, 0, 0};
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int cur = 0;
                    Deque<Integer> stackRow = new LinkedList<>();
                    Deque<Integer> stackCol = new LinkedList<>();
                    stackRow.push(i);
                    stackCol.push(j);
                    while (!stackRow.isEmpty()) {
                        int curRow = stackRow.pop();
                        int curCol = stackCol.pop();
                        if (curRow < 0 || curCol < 0 || curRow == grid.length || curCol == grid[0].length
                            || grid[curRow][curCol] != 1) {
                            continue;
                        }
                        cur++;
                        // 剪枝操作,不再访问已经访问过的土地
                        grid[curRow][curCol] = 0;
                        for (int index = 0; index < 4; index++) {
                            stackRow.push(curRow + row[index]);
                            stackCol.push(curCol + col[index]);
                        }
                    }
                    res = Math.max(res, cur);
                }
            }
            return res;
        }

        public int maxAreaOfIsland2(int[][] grid) {
            int res = 0;
            int[] row = {0, 0, 1, -1};
            int[] col = {1, -1, 0, 0};
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int cur = 0;
                    Queue<Integer> queueRow = new LinkedList<>();
                    Queue<Integer> queueCol = new LinkedList<>();
                    queueRow.offer(i);
                    queueCol.offer(j);
                    while (!queueRow.isEmpty()) {
                        int curRow = queueRow.poll();
                        int curCol = queueCol.poll();
                        if (curRow < 0 || curCol < 0 || curRow == grid.length || curCol == grid[0].length
                            || grid[curRow][curCol] != 1) {
                            continue;
                        }
                        cur++;
                        // 剪枝操作,不再访问已经访问过的土地
                        grid[curRow][curCol] = 0;
                        for (int index = 0; index < 4; index++) {
                            queueRow.offer(curRow + row[index]);
                            queueCol.offer(curCol + col[index]);
                        }
                    }
                    res = Math.max(res, cur);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



