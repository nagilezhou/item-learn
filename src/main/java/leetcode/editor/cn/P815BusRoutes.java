//You are given an array routes representing bus routes where routes[i] is a bus
// route that the ith bus repeats forever.
//
//
// For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in
// the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
//
//
// You will start at the bus stop source (You are not on any bus initially), and
// you want to go to the bus stop target. You can travel between bus stops by buse
//s only.
//
// Return the least number of buses you must take to travel from source to targe
//t. Return -1 if it is not possible.
//
//
// Example 1:
//
//
//Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//Output: 2
//Explanation: The best strategy is take the first bus to the bus stop 7, then t
//ake the second bus to the bus stop 6.
//
//
// Example 2:
//
//
//Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target =
// 12
//Output: -1
//
//
//
// Constraints:
//
//
// 1 <= routes.length <= 500.
// 1 <= routes[i].length <= 105
// All the values of routes[i] are unique.
// sum(routes[i].length) <= 105
// 0 <= routes[i][j] < 106
// 0 <= source, target < 106
//
// Related Topics 广度优先搜索 数组 哈希表
// 👍 213 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Java：Bus Routes
public class P815BusRoutes {
    public static void main(String[] args) {
        Solution solution = new P815BusRoutes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) {
                return 0;
            }
            int n = routes.length;
            boolean[][] edge = new boolean[n][n];
            Map<Integer, List<Integer>> rec = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int site : routes[i]) {
                    List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                    for (int j : list) {
                        edge[i][j] = edge[j][i] = true;
                    }
                    list.add(i);
                    rec.put(site, list);
                }
            }

            int[] dis = new int[n];
            Arrays.fill(dis, -1);
            Queue<Integer> queue = new LinkedList<>();
            for (int bus : rec.getOrDefault(source, new ArrayList<>())) {
                dis[bus] = 1;
                queue.offer(bus);
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                for (int y = 0; y < n; y++) {
                    if (edge[x][y] && dis[y] == -1) {
                        dis[y] = dis[x] + 1;
                        queue.offer(y);
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int bus : rec.getOrDefault(target, new ArrayList<>())) {
                if (dis[bus] == -1) {
                    continue;
                }
                res = Math.min(res, dis[bus]);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



