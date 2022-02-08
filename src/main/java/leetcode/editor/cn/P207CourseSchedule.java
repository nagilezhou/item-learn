//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
//
//
//
// For example, the pair [0, 1], indicates that to take course 0 you have to fir
//st take course 1.
//
//
// Return true if you can finish all courses. Otherwise, return false.
//
//
// Example 1:
//
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0. So it is possible.
//
//
// Example 2:
//
//
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0, and to take course 0 you s
//hould also have finished course 1. So it is impossible.
//
//
//
// Constraints:
//
//
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
// 👍 836 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Java：Course Schedule 拓扑排序
// 2021-08-12 review 1
public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        System.out.println(solution.canFinish3(4, new int[][] {{0, 1},{1, 0},{2, 3},{3, 2},{1, 2},{3, 1}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            int[][] matrix = new int[numCourses][numCourses];
            for (int[] course : prerequisites) {
                inDegree[course[0]]++;
                matrix[course[1]][course[0]] = 1;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int res = 0;
            while (!queue.isEmpty()) {
                Queue<Integer> temp = new LinkedList<>();
                for (int num : queue) {
                    res++;
                    for (int i = 0; i < numCourses; i++) {
                        if (matrix[num][i] == 1) {
                            if (--inDegree[i] == 0) {
                                temp.offer(i);
                            }
                        }
                    }
                }
                queue = temp;
            }
            return res == numCourses;
        }


        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] inDegrees = new int[numCourses];
            for(int[] prerequisite : prerequisites){
                inDegrees[prerequisite[0]]++;
                List<Integer> edges = map.getOrDefault(prerequisite[1], new ArrayList<>());
                edges.add(prerequisite[0]);
                map.put(prerequisite[1], edges);
            }
            Deque<Integer> queue = new LinkedList<>();
            for(int i = 0; i < inDegrees.length; i++){
                if(inDegrees[i] == 0){
                    queue.offer(i);
                }
            }
            int res = 0;
            while(!queue.isEmpty()){
                Deque<Integer> temp = new ArrayDeque<>();
                for(int index : queue){
                    res++;
                    List<Integer> list = map.get(index);
                    if(list == null){
                        continue;
                    }
                    for(int num : list){
                        if(--inDegrees[num] == 0){
                            temp.offer(num);
                        }
                    }
                }

                queue = temp;
            }

            return res == numCourses;
        }

        public int canFinish3(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) {
                return 0;
            }
            int plen = prerequisites.length;
            if (plen == 0) {
                return 0;
            }
            int[] marked = new int[numCourses];

            // 初始化有向图 begin
            HashSet<Integer>[] graph = new HashSet[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new HashSet<>();
            }
            // 初始化有向图 end
            // 有向图的 key 是前驱结点，value 是后继结点的集合
            for (int[] p : prerequisites) {
                graph[p[1]].add(p[0]);
            }

            int res = 0;
            for (int i = 0; i < numCourses; i++) {
                //if (dfs(i, graph, marked)) {
                //    // 注意方法的语义，如果图中存在环，表示课程任务不能完成，应该返回 false
                //    return false;
                //}
                res += dfs(i, graph, marked);
            }
            // 在遍历的过程中，一直 dfs 都没有遇到已经重复访问的结点，就表示有向图中没有环
            // 所有课程任务可以完成，应该返回 true
            return res;
        }

        /**
         * 注意这个 dfs 方法的语义
         * @param i      当前访问的课程结点
         * @param graph
         * @param marked 如果 == 1 表示正在访问中，如果 == 2 表示已经访问完了
         * @return true 表示图中存在环，false 表示访问过了，不用再访问了
         */
        private int dfs(int i, HashSet<Integer>[] graph, int[] marked) {
            // 如果访问过了，就不用再访问了
            if (marked[i] == 1) {
                // 从正在访问中，到正在访问中，表示遇到了环
                return 1;
            }

            if (marked[i] == 2) {
                // 表示在访问的过程中没有遇到环，这个节点访问过了
                return 0;
            }
            // 走到这里，是因为初始化呢，此时 marked[i] == 0
            // 表示正在访问中
            marked[i] = 1;
            // 后继结点的集合
            HashSet<Integer> successorNodes = graph[i];

            int res = 0;
            for (Integer successor : successorNodes) {
                //if (dfs(successor, graph, marked)) {
                //    // 层层递归返回 true ，表示图中存在环
                //    return true;
                //}
                res += dfs(successor, graph, marked);
            }
            // i 的所有后继结点都访问完了，都没有存在环，则这个结点就可以被标记为已经访问结束
            // 状态设置为 2
            marked[i] = 2;
            // false 表示图中不存在环
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}



