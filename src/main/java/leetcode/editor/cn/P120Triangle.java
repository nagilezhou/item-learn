//Given a triangle array, return the minimum path sum from top to bottom.
//
// For each step, you may move to an adjacent number of the row below. More form
//ally, if you are on index i on the current row, you may move to either index i o
//r index i + 1 on the next row.
//
//
// Example 1:
//
//
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined abov
//e).
//
//
// Example 2:
//
//
//Input: triangle = [[-10]]
//Output: -10
//
//
//
// Constraints:
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -104 <= triangle[i][j] <= 104
//
//
//
//Follow up: Could you do this using only O(n) extra space, where n is the total
// number of rows in the triangle? Related Topics 数组 动态规划
// 👍 779 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Triangle
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> test_01 = new ArrayList<>();
        test_01.add(2);
        triangle.add(test_01);
        List<Integer> test_02 = new ArrayList<>();
        test_02.add(3);
        test_02.add(4);
        triangle.add(test_02);
        List<Integer> test_03 = new ArrayList<>();
        test_03.add(6);
        test_03.add(5);
        test_03.add(7);
        triangle.add(test_03);
        List<Integer> test_04 = new ArrayList<>();
        test_04.add(4);
        test_04.add(1);
        test_04.add(8);
        test_04.add(3);
        triangle.add(test_04);
        System.out.println(solution.minimumTotal(triangle));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int len = triangle.size();
            int[][] dp = new int[len][len];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < len; i++) {
                List<Integer> list = triangle.get(i);
                for (int j = 0; j < list.size(); j++) {
                    int num = list.get(j);
                    int left = Integer.MAX_VALUE;
                    if (j != 0) {
                        left = dp[i - 1][j - 1] + num;
                    }
                    int right = Integer.MAX_VALUE;
                    if (j != list.size() - 1) {
                        right = dp[i - 1][j] + num;
                    }
                    dp[i][j] = Math.min(left, right);
                }
            }
            int min = Integer.MAX_VALUE;
            for (int num : dp[len - 1]) {
                min = Math.min(num, min);
            }
            return min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



