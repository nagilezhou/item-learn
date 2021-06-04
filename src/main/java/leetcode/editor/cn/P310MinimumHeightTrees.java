//A tree is an undirected graph in which any two vertices are connected by exact
//ly one path. In other words, any connected graph without simple cycles is a tree
//.
//
// Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges
// where edges[i] = [ai, bi] indicates that there is an undirected edge between th
//e two nodes ai and bi in the tree, you can choose any node of the tree as the ro
//ot. When you select a node x as the root, the result tree has height h. Among al
//l possible rooted trees, those with minimum height (i.e. min(h)) are called mini
//mum height trees (MHTs).
//
// Return a list of all MHTs' root labels. You can return the answer in any orde
//r.
//
// The height of a rooted tree is the number of edges on the longest downward pa
//th between the root and a leaf.
//
//
// Example 1:
//
//
//Input: n = 4, edges = [[1,0],[1,2],[1,3]]
//Output: [1]
//Explanation: As shown, the height of the tree is 1 when the root is the node w
//ith label 1 which is the only MHT.
//
//
// Example 2:
//
//
//Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//Output: [3,4]
//
//
// Example 3:
//
//
//Input: n = 1, edges = []
//Output: [0]
//
//
// Example 4:
//
//
//Input: n = 2, edges = [[0,1]]
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 1 <= n <= 2 * 104
// edges.length == n - 1
// 0 <= ai, bi < n
// ai != bi
// All the pairs (ai, bi) are distinct.
// The given input is guaranteed to be a tree and there will be no repeated edge
//s.
//
// Related Topics 广度优先搜索 图
// 👍 334 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Java：Minimum Height Trees
public class P310MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new P310MinimumHeightTrees().new Solution();
        System.out.println(solution.findMinHeightTrees(6, new int[][] {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();
            /*如果只有一个节点，那么他就是最小高度树*/
            if (n == 1) {
                res.add(0);
                return res;
            }
            /*建立各个节点的出度表*/
            int[] degree = new int[n];
            /*建立图关系，在每个节点的list中存储相连节点*/
            List<List<Integer>> map = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                map.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                degree[edge[0]]++;
                degree[edge[1]]++;/*出度++*/
                map.get(edge[0]).add(edge[1]);/*添加相邻节点*/
                map.get(edge[1]).add(edge[0]);
            }
            /*建立队列*/
            Queue<Integer> queue = new LinkedList<>();
            /*把所有出度为1的节点，也就是叶子节点入队*/
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }
            /*循环条件当然是经典的不空判断*/
            while (!queue.isEmpty()) {
                res = new ArrayList<>();
                /*这个地方注意，我们每层循环都要new一个新的结果集合，这样最后保存的就是最终的最小高度树了*/
                int size = queue.size();/*这是每一层的节点的数量*/
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    res.add(cur);
                    /*把当前节点加入结果集，不要有疑问，为什么当前只是叶子节点为什么要加入结果集呢?
                    因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点，
                    这也是很多题解里面所说的剪掉叶子节点的部分，你可以想象一下图，每层遍历完，
                    都会把该层（也就是叶子节点层）这一层从队列中移除掉，
                    不就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图吗*/
                    List<Integer> neighbors = map.get(cur);
                    /*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
                     * 把它们的出度都减1，因为当前节点已经不存在了，所以，
                     * 它的相邻节点们就有可能变成叶子节点*/
                    for (int neighbor : neighbors) {
                        degree[neighbor]--;
                        if (degree[neighbor] == 1) {
                            /*如果是叶子节点我们就入队*/
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            return res;/*返回最后一次保存的list*/
        }

        // 超时
        public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
            int[][] matrix = new int[n][n];
            for (int[] edge : edges) {
                matrix[edge[0]][edge[1]] = 1;
                matrix[edge[1]][edge[0]] = 1;
            }
            List<Integer> res = new ArrayList<>();
            int minHeight = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                int tempHeight = 1;
                Set<Integer> viewSet = new HashSet<>();
                while (!queue.isEmpty()) {
                    Queue<Integer> temp = new LinkedList<>();
                    for (int row : queue) {
                        for (int col = 0; col < n; col++) {
                            if (matrix[row][col] == 1 && !viewSet.contains(col)) {
                                temp.add(col);
                            }
                        }
                        viewSet.add(row);
                    }
                    queue = temp;
                    tempHeight++;
                }
                if (tempHeight < minHeight) {
                    minHeight = tempHeight;
                    res.clear();
                    res.add(i);
                    continue;
                }
                if(tempHeight == minHeight){
                    res.add(i);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



