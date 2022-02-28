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
// Return the ordering of courses you should take to finish all courses. If ther
//e are many valid answers, return any of them. If it is impossible to finish all
//courses, return an empty array.
//
//
// Example 1:
//
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished course 0. So the correct course order is [0,1].
//
//
// Example 2:
//
//
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both courses 1 and 2. Both courses 1 and 2 should be taken afte
//r you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
//
//
// Example 3:
//
//
//Input: numCourses = 1, prerequisites = []
//Output: [0]
//
//
//
// Constraints:
//
//
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= numCourses * (numCourses - 1)
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// ai != bi
// All the pairs [ai, bi] are distinct.
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
// 👍 412 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Java：Course Schedule II 拓扑排序
// 2021-08-14 review 1
public class P210CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new P210CourseScheduleIi().new Solution();
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{0,1}})));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // BFS
        public int[] findOrder2(int numCourses, int[][] prerequisites) {
            if (numCourses == 0 || prerequisites == null) {
                return new int[0];
            }
            int[] inDegrees = new int[numCourses];
            for (int[] p : prerequisites) {
                inDegrees[p[0]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegrees.length; i++) {
                if (inDegrees[i] == 0) {
                    queue.offer(i);
                }
            }
            int[] res = new int[numCourses];
            int count = 0;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                res[count++] = curr;
                for (int[] p : prerequisites) {
                    if (p[1] == curr) {
                        inDegrees[p[0]]--;
                        if (inDegrees[p[0]] == 0) {
                            queue.offer(p[0]);
                        }
                    }
                }
            }
            return count == numCourses ? res : new int[0];
        }

        public int[] findOrder3(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int[] indegrees = new int[numCourses];
            for(int[] prerequisite : prerequisites){
                indegrees[prerequisite[0]]++;
                List<Integer> list = graph.getOrDefault(prerequisite[1], new ArrayList<>());
                list.add(prerequisite[0]);
                graph.put(prerequisite[1], list);
            }
            Deque<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(indegrees[i] == 0){
                    queue.offer(i);
                }
            }

            List<Integer> res = new ArrayList<>();
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int index = queue.poll();
                    res.add(index);
                    List<Integer> list = graph.get(index);
                    if(list == null || list.isEmpty()){
                        continue;
                    }
                    for(int next : list){
                        if(--indegrees[next] == 0){
                            queue.offer(next);
                        }
                    }
                }
            }

            return res.size() == numCourses ? res.stream().mapToInt(Integer::valueOf).toArray() : new int[0];
        }


        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for(int[] prerequisite : prerequisites){
                List<Integer> list = graph.getOrDefault(prerequisite[1], new ArrayList<>());
                list.add(prerequisite[0]);
                graph.put(prerequisite[1], list);
            }
            int[] marked = new int[numCourses];
            Deque<Integer> stack = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(dfs(i, graph, marked, stack)){
                    return new int[0];
                }
            }
            if(stack.size() != numCourses){
                return new int[0];
            }
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                res[i] = stack.pop();
            }
            return res;
        }

        private boolean dfs(int i, Map<Integer, List<Integer>> graph, int[] marked, Deque<Integer> stack){
            if(marked[i] == 1){
                // 有向图找环 在这里将栈里面的节点取出来
                return true;
            }
            if(marked[i] == 2){
                return false;
            }

            marked[i] = 1;
            List<Integer> list = graph.get(i);
            if(list != null && !list.isEmpty()){
                for(int index : list){
                    if(dfs(index, graph, marked, stack)){
                        return true;
                    }
                }
            }
            marked[i] = 2;
            stack.push(i);
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



