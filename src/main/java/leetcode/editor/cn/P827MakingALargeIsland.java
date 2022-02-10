//You are given an n x n binary matrix grid. You are allowed to change at most o
//ne 0 to be 1.
//
// Return the size of the largest island in grid after applying this operation.
//
//
// An island is a 4-directionally connected group of 1s.
//
//
// Example 1:
//
//
//Input: grid = [[1,0],[0,1]]
//Output: 3
//Explanation: Change one 0 to 1 and connect two 1s, then we get an island with
//area = 3.
//
//
// Example 2:
//
//
//Input: grid = [[1,1],[1,0]]
//Output: 4
//Explanation: Change the 0 to 1 and make the island bigger, only one island wit
//h area = 4.
//
// Example 3:
//
//
//Input: grid = [[1,1],[1,1]]
//Output: 4
//Explanation: Can't change any 0 to 1, only one island with area = 4.
//
//
//
// Constraints:
//
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 500
// grid[i][j] is either 0 or 1.
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 👍 131 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：Making A Large Island
public class P827MakingALargeIsland {
    public void main(String[] args) {
        Solution solution = new P827MakingALargeIsland().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.第一步，先深度优先遍历出陆地，获取到所有的陆地面积，并且将同一块陆地中的格子值置换为同一索引值，该索引为记录该陆地面积的索引下标值
         * 2.第二部，遍历海洋，找到相邻陆地面积最大的海洋格子
         */
        public int largestIsland(int[][] grid) {
            //用来记录每次遍历中每个陆地的面积大小
            int res = 0;
            int maxArea = 0;
            //索引值从2开始，避免和0（海洋）,1（陆地）值冲突
            int index = 2;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            //1.深度优先，先遍历出陆地面积
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (grid[x][y] == 1) {
                        int a = area(grid, x, y, index);
                        maxArea = Math.max(a, res);
                        map.put(index, a);
                        ++index;
                    }
                }
            }
            //2.遍历海洋，找到相邻陆地面积最大的海洋格子
            int plusRes = 0;
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    //如果是0（海洋）
                    if (grid[x][y] == 0) {
                        int plusArea = plusArea(grid, x, y, map);
                        plusRes = Math.max(plusArea, plusRes);
                    }
                }
            }
            //可能都没有海洋，全是陆地，则再次判断，直接返回陆地最大值
            plusRes = Math.max(maxArea, plusRes);
            return plusRes;
        }

        private int plusArea(int[][] grid, int x, int y, Map<Integer, Integer> map) {
            if (!isArea(grid, x, y)) {
                return 0;
            }
            if (grid[x][y] != 0) {
                return 0;
            }
            Integer size = 0;
            //叠加面积很关键的一步，记得去重，因为海洋四周接壤的土地有可能是同一块陆地
            Set<Integer> set = new HashSet<Integer>();
            if (isArea(grid, x - 1, y) && grid[x - 1][y] >= 2) {
                set.add(grid[x - 1][y]);
            }
            if (isArea(grid, x + 1, y) && grid[x + 1][y] >= 2) {
                set.add(grid[x + 1][y]);
            }
            if (isArea(grid, x, y - 1) && grid[x][y - 1] >= 2) {
                set.add(grid[x][y - 1]);
            }
            if (isArea(grid, x, y + 1) && grid[x][y + 1] >= 2) {
                set.add(grid[x][y + 1]);
            }
            for (Integer num : set) {
                size += map.get(num);
            }
            //海洋变土地，+1
            ++size;
            return size;
        }

        private int area(int[][] grid, int x, int y, int index) {
            if (!isArea(grid, x, y)) {
                return 0;
            }
            if (grid[x][y] != 1) {
                return 0;
            }
            //用index来代表同一块陆地存放面积的索引值
            grid[x][y] = index;
            return 1
                + area(grid, x + 1, y, index)
                + area(grid, x - 1, y, index)
                + area(grid, x, y + 1, index)
                + area(grid, x, y - 1, index);
        }

        private boolean isArea(int[][] grid, int x, int y) {
            return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



