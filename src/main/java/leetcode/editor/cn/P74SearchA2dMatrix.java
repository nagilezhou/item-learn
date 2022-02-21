//Write an efficient algorithm that searches for a value target in an m x n inte
//ger matrix matrix. This matrix has the following properties:
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previou
//s row.
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//
//
// Example 2:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics 数组 二分查找 矩阵
// 👍 576 👎 0

package leetcode.editor.cn;
//Java：Search a 2D Matrix
public class P74SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l < r) {
            int mid = l + r  >> 1;
            if (matrix[mid / n][mid % n] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return matrix[r / n][r % n] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



