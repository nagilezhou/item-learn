//Given an m x n matrix, return all elements of the matrix in spiral order.
//
//
// Example 1:
//
//
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//
//
// Example 2:
//
//
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟
// 👍 978 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Spiral Matrix
public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = m - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                order.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    order.add(matrix[bottom][col]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



