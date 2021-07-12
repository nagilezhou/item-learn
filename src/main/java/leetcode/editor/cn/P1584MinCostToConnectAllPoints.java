//You are given an array points representing integer coordinates of some points
//on a 2D-plane, where points[i] = [xi, yi].
//
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan dist
//ance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value
// of val.
//
// Return the minimum cost to make all points connected. All points are connecte
//d if there is exactly one simple path between any two points.
//
//
// Example 1:
//
//
//
//
//Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//Output: 20
//Explanation:
//
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
//
//
// Example 2:
//
//
//Input: points = [[3,12],[-2,5],[-4,1]]
//Output: 18
//
//
// Example 3:
//
//
//Input: points = [[0,0],[1,1],[1,0],[-1,1]]
//Output: 4
//
//
// Example 4:
//
//
//Input: points = [[-1000000,-1000000],[1000000,1000000]]
//Output: 4000000
//
//
// Example 5:
//
//
//Input: points = [[0,0]]
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= points.length <= 1000
// -106 <= xi, yi <= 106
// All pairs (xi, yi) are distinct.
//
// Related Topics 并查集 数组 最小生成树
// 👍 151 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Min Cost to Connect All Points
public class P1584MinCostToConnectAllPoints {
    public static void main(String[] args) {
        Solution solution = new P1584MinCostToConnectAllPoints().new Solution();
        System.out.println(solution.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
        System.out.println(solution.minCostConnectPoints(new int[][]{{31,12},{-2,5},{-4,1}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] p;
        public int minCostConnectPoints(int[][] points) {
            List<int[]> list = new ArrayList<>();
            int n = points.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    list.add(new int[] {i, j, w});
                }
            }
            list.sort((o1, o2) -> o1[2] - o2[2]);

            p = new int[n + 1];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
            int res = 0;
            for (int[] edge : list) {
                int x = edge[0];
                int y = edge[1];
                int w = edge[2];
                if (!query(x, y)) {
                    res += w;
                    union(x, y);
                }

            }

            return res;
        }

        private int find(int x) {
            return x == p[x] ? p[x] : find(p[x]);
        }

        private boolean query(int a, int b) {
            return p[find(a)] == p[find(b)];
        }

        private void union(int a, int b) {
            p[find(a)] = p[find(b)];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



