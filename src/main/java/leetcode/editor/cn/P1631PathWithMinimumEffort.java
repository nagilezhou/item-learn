//You are a hiker preparing for an upcoming hike. You are given heights, a 2D ar
//ray of size rows x columns, where heights[row][col] represents the height of cel
//l (row, col). You are situated in the top-left cell, (0, 0), and you hope to tra
//vel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can mov
//e up, down, left, or right, and you wish to find a route that requires the minim
//um effort.
//
// A route's effort is the maximum absolute difference in heights between two co
//nsecutive cells of the route.
//
// Return the minimum effort required to travel from the top-left cell to the bo
//ttom-right cell.
//
//
// Example 1:
//
//
//
//
//Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
//Output: 2
//Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 i
//n consecutive cells.
//This is better than the route of [1,2,2,2,5], where the maximum absolute diffe
//rence is 3.
//
//
// Example 2:
//
//
//
//
//Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
//Output: 1
//Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 i
//n consecutive cells, which is better than route [1,3,5,3,5].
//
//
// Example 3:
//
//
//Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//
//Output: 0
//Explanation: This route does not require any effort.
//
//
//
// Constraints:
//
//
// rows == heights.length
// columns == heights[i].length
// 1 <= rows, columns <= 100
// 1 <= heights[i][j] <= 106
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列）
// 👍 222 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Java：Path With Minimum Effort 图
// 2021-08-21 review 1
public class P1631PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new P1631PathWithMinimumEffort().new Solution();
        System.out.println(solution.minimumEffortPath(new int[][] {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int row;
        int col;
        int N = 10009;
        int[] p = new int[N];

        // b作为a的根节点
        void union(int a, int b) {
            p[find(a)] = p[find(b)];
        }

        boolean query(int a, int b) {
            return p[find(a)] == p[find(b)];
        }

        int find(int x) {
            return p[x] != x ? find(p[x]) : p[x];
        }

        int getIndex(int x, int y) {
            return x * col + y;
        }


        // Kruskal
        public int minimumEffortPath2(int[][] heights) {
            row = heights.length;
            col = heights[0].length;

            // 初始化并查集
            for (int i = 0; i < row * col; i++) {
                p[i] = i;
            }

            // 有权无向图
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int idx = getIndex(i, j);
                    if (i + 1 < row) {
                        int a = idx;
                        int b = getIndex(i + 1, j);
                        int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                        edges.add(new int[] {a, b, w});
                    }
                    if (j + 1 < col) {
                        int a = idx;
                        int b = getIndex(i, j + 1);
                        int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                        edges.add(new int[] {a, b, w});
                    }
                }
            }

            // 根据权重升序排列
            Collections.sort(edges, (a, b) -> a[2] - b[2]);
            int start = getIndex(0, 0);
            int end = getIndex(row - 1, col - 1);
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                int w = edge[2];
                union(a, b);
                if (query(start, end)) {
                    return w;
                }
            }
            return 0;
        }

        // Dijkstra 算法 求原点到目标点的最短距离 (队列优化)

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] edge1, int[] edge2) {
                    return edge1[2] - edge2[2];
                }
            });
            pq.offer(new int[] {0, 0, 0});

            int[] dist = new int[m * n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            boolean[] seen = new boolean[m * n];

            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                int x = edge[0], y = edge[1], d = edge[2];
                int id = x * n + y;
                if (seen[id]) {
                    continue;
                }
                seen[id] = true;
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && Math.max(d, Math.abs(heights[x][y] - heights[nx][ny])) < dist[nx * n + ny]) {
                        dist[nx * n + ny] = Math.max(d, Math.abs(heights[x][y] - heights[nx][ny]));
                        pq.offer(new int[] {nx, ny, dist[nx * n + ny]});
                    }
                }
            }

            return dist[m * n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



