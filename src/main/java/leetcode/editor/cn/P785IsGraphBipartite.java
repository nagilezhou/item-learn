//There is an undirected graph with n nodes, where each node is numbered between
// 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of node
//s that node u is adjacent to. More formally, for each v in graph[u], there is an
// undirected edge between node u and node v. The graph has the following properti
//es:
//
//
// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such t
//hat there is no path between them.
//
//
// A graph is bipartite if the nodes can be partitioned into two independent set
//s A and B such that every edge in the graph connects a node in set A and a node
//in set B.
//
// Return true if and only if it is bipartite.
//
//
// Example 1:
//
//
//Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//Output: false
//Explanation: There is no way to partition the nodes into two independent sets
//such that every edge connects a node in one and a node in the other.
//
// Example 2:
//
//
//Input: graph = [[1,3],[0,2],[1,3],[0,2]]
//Output: true
//Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
//
//
// Constraints:
//
//
// graph.length == n
// 1 <= n <= 100
// 0 <= graph[u].length < n
// 0 <= graph[u][i] <= n - 1
// graph[u] does not contain u.
// All the values of graph[u] are unique.
// If graph[u] contains v, then graph[v] contains u.
//
// Related Topics 深度优先搜索 广度优先搜索 图
// 👍 263 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：Is Graph Bipartite? 矩阵 dfs bfs
// 2021-08-21 review 1
public class P785IsGraphBipartite {
    public static void main(String[] args) {
        Solution solution = new P785IsGraphBipartite().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int UNCOLORED = 0;
        private static final int RED = 1;
        private static final int GREEN = 2;

        // BFS
        public boolean isBipartite(int[][] graph) {
            if (graph == null || graph.length == 0) {
                return true;
            }
            int[] color = new int[graph.length];
            Deque<Integer> queue = new LinkedList<>();
            for (int row = 0; row < graph.length; row++) {
                if (color[row] == UNCOLORED) {
                    queue.offer(row);
                    color[row] = RED;
                    while (!queue.isEmpty()) {
                        int node = queue.poll();
                        int cNei = color[node] == RED ? GREEN : RED;
                        for (int neighbor : graph[node]) {
                            if (color[neighbor] == UNCOLORED) {
                                queue.offer(neighbor);
                                color[neighbor] = cNei;
                            } else if (color[neighbor] != cNei) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

        // DFS
        public boolean isBipartite2(int[][] graph) {
            if (graph == null || graph.length == 0) {
                return true;
            }
            int[] color = new int[graph.length];
            Deque<Integer> stack = new LinkedList<>();
            for (int row = 0; row < graph.length; row++) {
                if (color[row] == UNCOLORED) {
                    stack.push(row);
                    color[row] = RED;
                    while (!stack.isEmpty()) {
                        int node = stack.pop();
                        int cNei = color[node] == RED ? GREEN : RED;
                        for (int neighbor : graph[node]) {
                            if (color[neighbor] == UNCOLORED) {
                                stack.push(neighbor);
                                color[neighbor] = cNei;
                            } else if (color[neighbor] != cNei) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



