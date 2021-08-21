//Given an array of points where points[i] = [xi, yi] represents a point on the
//X-Y plane, return the maximum number of points that lie on the same straight lin
//e.
//
//
// Example 1:
//
//
//Input: points = [[1,1],[2,2],[3,3]]
//Output: 3
//
//
// Example 2:
//
//
//Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//Output: 4
//
//
//
// Constraints:
//
//
// 1 <= points.length <= 300
// points[i].length == 2
// -104 <= xi, yi <= 104
// All the points are unique.
//
// Related Topics 哈希表 数学
// 👍 240 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：Max Points on a Line 哈希表 斜率
// 2021-08-11 review 1
public class P149MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new P149MaxPointsOnALine().new Solution();
        System.out.println(solution.maxPoints(new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            int maxCount = 0;
            Map<String, Integer> map;
            int same;
            for (int i = 0; i < points.length; i++) {
                map = new HashMap<>();
                same = 0;
                int tempMax = 0;
                for (int j = i + 1; j < points.length; j++) {
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    if (dx == 0 && dy == 0) {
                        same++;
                        continue;
                    }
                    int g = gcd(dy, dx);
                    if(g != 0){
                        dy /= g;
                        dx /= g;
                    }
                    String temp = dx + "/" + dy;
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                    tempMax = Math.max(tempMax, map.get(temp));
                }
                maxCount = Math.max(maxCount, tempMax + same + 1);
            }
            return maxCount;
        }

        private int gcd(int dy, int dx) {
            if (dx == 0) {
                return dy;
            } else {
                return gcd(dx, dy % dx);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



