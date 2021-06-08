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

import java.util.LinkedList;
import java.util.Queue;

//Java：Course Schedule
public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        System.out.println(solution.canFinish(2, new int[][] {{0, 1}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
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
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



