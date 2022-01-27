//Given an m x n integer matrix matrix, if an element is 0, set its entire row a
//nd column to 0's, and return the matrix.
//
// You must do it in place.
//
//
// Example 1:
//
//
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
//
//
// Example 2:
//
//
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
//
//
//
// Follow up:
//
//
// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
//
// Related Topics 数组 哈希表 矩阵
// 👍 644 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Set Matrix Zeroes
public class P73SetMatrixZeroes{
    public static void main(String[] args) {
        Solution solution = new P73SetMatrixZeroes().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                row = true;
                break;
            }
        }
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                col = true;
                break;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        // 3. 根据最开始记录的「首行」和「首列」信息，进行「首行首列」置零
        if (row) for (int i = 0; i < m; i++) matrix[i][0] = 0;
        if (col) Arrays.fill(matrix[0], 0);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



