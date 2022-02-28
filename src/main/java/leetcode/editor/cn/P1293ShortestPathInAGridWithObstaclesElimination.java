//You are given an m x n integer matrix grid where each cell is either 0 (empty)
// or 1 (obstacle). You can move up, down, left, or right from and to an empty cel
//l in one step.
//
// Return the minimum number of steps to walk from the upper left corner (0, 0)
//to the lower right corner (m - 1, n - 1) given that you can eliminate at most k
//obstacles. If it is not possible to find such walk return -1.
//
//
// Example 1:
//
//
//Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
//Output: 6
//Explanation:
//The shortest path without eliminating any obstacle is 10.
//The shortest path with one obstacle elimination at position (3,2) is 6. Such p
//ath is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
//
//
// Example 2:
//
//
//Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
//Output: -1
//Explanation: We need to eliminate at least two obstacles to find such a walk.
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 40
// 1 <= k <= m * n
// grid[i][j] is either 0 or 1.
// grid[0][0] == grid[m - 1][n - 1] == 0
//
// Related Topics 广度优先搜索 数组 矩阵
// 👍 164 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：Shortest Path in a Grid with Obstacles Elimination
public class P1293ShortestPathInAGridWithObstaclesElimination{
    public static void main(String[] args) {
        Solution solution = new P1293ShortestPathInAGridWithObstaclesElimination().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int shortestPath(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            // 非法参数处理
            if (validateInputParams(k, m, n)) {
                return -1;
            }
            // 特殊场景处理
            if (m == 1 && n == 1) {
                return 0;
            }

            // BFS对于当前点的下一个点选择，如果grid[i][j]=0则有效入队列 visited[i][j]记录消除障碍次数
            // 若grid[i][j]=1则看是否还有消除障碍机会，若没有 此点丢弃
            // 若有消除障碍机会， （上一个点剩余消除障碍机会 - 1）比visited[i][j] 值比大 此点入队， 小则丢弃（贪心）
            // 例子：k=1, 坐标(0,2)可以为消除(0,1)障碍过来的 visited[0][2] = 0，搜索层级为2
            // 也可能为不消除任何障碍过来的 visited[0][2] = 1，层级为6，更新visited[0][2] = 1并入队
            // 因为到后面还需要消除障碍才能到达目标，先消除障碍走到visited[0][2] = 0的肯定到不了目标...
            // 0 1 0 0 0 1 0 0
            // 0 1 0 1 0 1 0 1
            // 0 0 0 1 0 0 1 0

            // 二维标记数组初始状态为-1，值记录剩余消除障碍的次数，剩余次数越多 越有价值（此处贪心，记录局部最优）
            int[][] visited = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = -1;
                }
            }
            // 初始步数为0，m=n=1的特殊场景已处理
            //int minSteps = 0;

            // 初始位置标记已访问,值记录剩余消除障碍物次数  越多越好
            // 1. 对于其他路径到达此点且剩余消除障碍物次数小于等于当前值 —— 剪枝
            // 2. 对于其他路径到达此点且剩余消除障碍物次数大于当前值 —— 取代并入队
            visited[0][0] = k;
            Queue<Point> queue = new LinkedList<>();
            Point startPoint = new Point(0, 0, 0, 0);
            queue.offer(startPoint);

            // 定义四个方向移动坐标
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            // BFS搜索-队列遍历
            while (!queue.isEmpty()) {
                //minSteps++;
                // BFS搜索-遍历相同层级下所有节点
                // 当前队列长度一定要在循环外部定义，循环内部有插入对列操作
                //int size = queue.size();
                //for (int i = 0; i < size; i++) {
                    Point current = queue.poll();
                    int x = current.x;
                    int y = current.y;
                    int oneCount = current.oneCount;
                    int step = current.step;
                    // 搜索到目标节点直接返回结果，按层级就是最短步数
                    if (x == m - 1 && y == n - 1) {
                        return step;
                    }
                    // 对当前节点四个方向进行识别处理
                    for (int j = 0; j < 4; j++) {
                        int xNew = x + dx[j];
                        int yNew = y + dy[j];
                        // 越界判断
                        if (xNew < 0 || xNew >= m || yNew < 0 || yNew >= n) {
                            continue;
                        }
                        // 穿越障碍次数已满
                        if (grid[xNew][yNew] == 1 && oneCount >= k) {
                            continue;
                        }
                        int oneCountNew = grid[xNew][yNew] == 1 ? oneCount + 1 : oneCount;
                        // 剪枝 - 节点已被访问过，且当前visited记录的剩余障碍物消除次数 >= 当前搜索节点层级的剩余消除次数
                        if (visited[xNew][yNew] != -1 && visited[xNew][yNew] >= k - oneCountNew) {
                            continue;
                        } else {
                            // 否则，贪心将最优值更新，并将该层级节点入队
                            visited[xNew][yNew] = k - oneCountNew;
                        }
                        queue.offer(new Point(xNew, yNew, oneCountNew, step + 1));
                    }
                //}
            }
            // BFS没搜索到目标，返回-1
            return -1;
        }

        private boolean validateInputParams(int k, int m, int n) {
            return m > 40 || m < 1 || n > 40 || n < 1 || k < 1 || k > m * n;
        }

        class Point {
            int x;
            int y;
            int oneCount;
            int step;

            public Point(int x, int y, int oneCount, int step) {
                this.x = x;
                this.y = y;
                this.oneCount = oneCount;
                this.step = step;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}



