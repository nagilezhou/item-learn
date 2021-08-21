//There is an undirected weighted connected graph. You are given a positive inte
//ger n which denotes that the graph has n nodes labeled from 1 to n, and an array
// edges where each edges[i] = [ui, vi, weighti] denotes that there is an edge bet
//ween nodes ui and vi with weight equal to weighti.
//
// A path from node start to node end is a sequence of nodes [z0, z1, z2, ..., z
//k] such that z0 = start and zk = end and there is an edge between zi and zi+1 wh
//ere 0 <= i <= k-1.
//
// The distance of a path is the sum of the weights on the edges of the path. Le
//t distanceToLastNode(x) denote the shortest distance of a path between node n an
//d node x. A restricted path is a path that also satisfies that distanceToLastNod
//e(zi) > distanceToLastNode(zi+1) where 0 <= i <= k-1.
//
// Return the number of restricted paths from node 1 to node n. Since that numbe
//r may be too large, return it modulo 109 + 7.
//
//
// Example 1:
//
//
//Input: n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10
//]]
//Output: 3
//Explanation: Each circle contains the node number in black and its distanceToL
//astNode value in blue. The three restricted paths are:
//1) 1 --> 2 --> 5
//2) 1 --> 2 --> 3 --> 5
//3) 1 --> 3 --> 5
//
//
// Example 2:
//
//
//Input: n = 7, edges = [[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3]
//,[2,6,4]]
//Output: 1
//Explanation: Each circle contains the node number in black and its distanceToL
//astNode value in blue. The only restricted path is 1 --> 3 --> 7.
//
//
//
// Constraints:
//
//
// 1 <= n <= 2 * 104
// n - 1 <= edges.length <= 4 * 104
// edges[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 1 <= weighti <= 105
// There is at most one edge between any two nodes.
// There is at least one path between any two nodes.
//
// Related Topics 图 拓扑排序 动态规划 最短路 堆（优先队列）
// 👍 50 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Java：Number of Restricted Paths From First to Last Node 图 dijkstra
// 2021-08-21 review 1
public class P1786NumberOfRestrictedPathsFromFirstToLastNode {
    public static void main(String[] args) {
        Solution solution = new P1786NumberOfRestrictedPathsFromFirstToLastNode().new Solution();
        System.out.println(solution.countRestrictedPaths(5,
            new int[][] {{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, List<int[]>> map;
        private int len;
        private int INF = Integer.MAX_VALUE;
        private int mod = 1000000007;

        public int countRestrictedPaths(int n, int[][] edges) {
            map = new HashMap<>();
            for (int[] edge : edges) {
                map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
                map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[] {edge[0], edge[2]});
            }
            len = map.size();
            int[] dis = getDijistla(n);

            int[][] arr = new int[len][2];
            for (int i = 0; i < n; i++) {
                arr[i] = new int[] {i + 1, dis[i + 1]};
            }
            Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);

            int[] dp = new int[len + 1];
            dp[n] = 1;
            for (int i = 0; i < n; i++) {
                int idx = arr[i][0];
                int cur = arr[i][1];
                List<int[]> mm = map.get(idx);
                if (mm == null) {
                    continue;
                }
                for (int[] next : mm) {
                    if (cur > dis[next[0]]) {
                        dp[idx] += dp[next[0]];
                        dp[idx] %= mod;
                    }
                }
                // 第 1 个节点不一定是距离第 n 个节点最远的点，但我们只需要 f[1]，可以直接跳出循环
                if (idx == 1) {
                    break;
                }
            }
            return dp[1];

        }

        private int[] getDijistla(int n) {
            // 初始化dis数组
            int[] dis = new int[len + 1];
            Arrays.fill(dis, INF);
            dis[n] = 0;
            boolean[] visited = new boolean[len + 1];

            // 初始化边权堆
            PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            heap.offer(new int[] {n, 0});

            while (!heap.isEmpty()) {
                int[] edge = heap.poll();
                int vertex = edge[0];
                if (visited[vertex]) {
                    continue;
                }
                visited[vertex] = true;
                List<int[]> adjacencyList = map.get(vertex);
                for (int[] adjacency : adjacencyList) {
                    int next = adjacency[0];
                    if (visited[next]) {
                        continue;
                    }
                    dis[next] = Math.min(dis[next], dis[vertex] + adjacency[1]);
                    heap.offer(new int[] {next, dis[next]});
                }
            }
            return dis;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



