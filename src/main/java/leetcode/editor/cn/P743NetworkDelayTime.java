//You are given a network of n nodes, labeled from 1 to n. You are also given ti
//mes, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui
//is the source node, vi is the target node, and wi is the time it takes for a sig
//nal to travel from source to target.
//
// We will send a signal from a given node k. Return the time it takes for all t
//he n nodes to receive the signal. If it is impossible for all the n nodes to rec
//eive the signal, return -1.
//
//
// Example 1:
//
//
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//Output: 2
//
//
// Example 2:
//
//
//Input: times = [[1,2,1]], n = 2, k = 1
//Output: 1
//
//
// Example 3:
//
//
//Input: times = [[1,2,1]], n = 2, k = 2
//Output: -1
//
//
//
// Constraints:
//
//
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
//
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列）
// 👍 402 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Java：Network Delay Time 图
// 2021-08-21 review 1
public class P743NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new P743NetworkDelayTime().new Solution();
        System.out.println(solution.networkDelayTime(new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(solution.networkDelayTime(new int[][] {{1, 2, 1}}, 2, 2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // floyd + 邻接矩阵 n的3次方
        public int networkDelayTime1(int[][] times, int n, int k) {
            int INF = 0x3f3f3f3f;
            int[][] matrixs = new int[n + 1][n + 1];
            for (int[] matrix : matrixs) {
                Arrays.fill(matrix, INF);
            }
            for (int[] time : times) {
                matrixs[time[0]][time[1]] = time[2];
            }
            for (int i = 1; i <= n; i++) {
                matrixs[i][i] = 0;
            }

            for (int x = 1; x <= n; x++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        matrixs[i][j] = Math.min(matrixs[i][j], matrixs[i][x] + matrixs[x][j]);
                    }
                }
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, matrixs[k][i]);
            }
            return res >= INF ? -1 : res;
        }

        // dijkstra + 邻接矩阵 nm
        public int networkDelayTime2(int[][] times, int n, int k) {
            int INF = 0x3f3f3f3f;
            int[][] matrixs = new int[n + 1][n + 1];
            for (int[] matrix : matrixs) {
                Arrays.fill(matrix, INF);
            }
            for (int[] time : times) {
                matrixs[time[0]][time[1]] = time[2];
            }
            for (int i = 1; i <= n; i++) {
                matrixs[i][i] = 0;
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[k] = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                int t = -1;
                for (int j = 1; j <= n; j++) {
                    if (!visited[j] && (t == -1 || dist[j] < dist[t])) {
                        t = j;
                    }
                }
                visited[t] = true;
                for (int j = 1; j <= n; j++) {
                    dist[j] = Math.min(dist[j], dist[t] + matrixs[t][j]);
                }
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, dist[i]);
            }
            return res >= INF ? -1 : res;
        }

        // dijkstra + 邻接表 mlogn + n
        public int networkDelayTime3(int[][] times, int n, int k) {
            int INF = 0x3f3f3f3f;
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] time : times) {
                graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] {time[1], time[2]});
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[k] = 0;
            boolean[] visited = new boolean[n + 1];
            PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            heap.offer(new int[] {k, 0});
            while (!heap.isEmpty()) {
                int[] t = heap.poll();
                int index = t[0];
                if (visited[index]) {
                    continue;
                }
                visited[index] = true;
                List<int[]> list = graph.get(index);
                if(list == null || list.isEmpty()){
                    continue;
                }
                for (int[] edge : list) {
                    int next = edge[0];
                    if (visited[next]) {
                        continue;
                    }
                    dist[next] = Math.min(dist[next], dist[index] + edge[1]);
                    heap.offer(new int[] {next, dist[next]});
                }
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, dist[i]);
            }
            return res >= INF ? -1 : res;
        }




        // bellman-ford
        public int networkDelayTime4(int[][] times, int n, int k) {
            int INF = 0x3f3f3f3f;
            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[k] = 0;
            for(int i = 1; i <= n; i++){
                int[] copy = dist.clone();
                for(int[] time : times){
                    dist[time[1]] = Math.min(dist[time[1]], copy[time[0]] + time[2]);
                }
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, dist[i]);
            }
            return res >= INF ? -1 : res;
        }

        // SPFA
        public int networkDelayTime(int[][] times, int n, int k) {
            int INF = 0x3f3f3f3f;
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] time : times) {
                graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] {time[1], time[2]});
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[k] = 0;
            boolean[] visited = new boolean[n + 1];
            Deque<Integer> queue = new LinkedList<>();
            queue.add(k);
            visited[k] = true;
            while (!queue.isEmpty()){
                int index = queue.poll();
                visited[index] = false;
                List<int[]> list = graph.get(index);
                if(list == null || list.isEmpty()){
                    continue;
                }
                for(int[] edge : list){
                    if(dist[edge[0]] > dist[index] + edge[1]){
                        dist[edge[0]] = dist[index] + edge[1];
                        if (!visited[edge[0]]) {
                            queue.add(edge[0]);
                            visited[edge[0]] = true;
                        }
                    }
                }
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, dist[i]);
            }
            return res >= INF ? -1 : res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}





