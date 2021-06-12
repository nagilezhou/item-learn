//Given an n x n matrix where each of the rows and columns are sorted in ascendi
//ng order, return the kth smallest element in the matrix.
//
// Note that it is the kth smallest element in the sorted order, not the kth dis
//tinct element.
//
//
// Example 1:
//
//
//Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//Output: 13
//Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the
// 8th smallest number is 13
//
//
// Example 2:
//
//
//Input: matrix = [[-5]], k = 1
//Output: -5
//
//
//
// Constraints:
//
//
// n == matrix.length
// n == matrix[i].length
// 1 <= n <= 300
// -109 <= matrix[i][j] <= 109
// All the rows and columns of matrix are guaranteed to be sorted in non-decreas
//ing order.
// 1 <= k <= n2
//
// Related Topics 堆 二分查找
// 👍 606 👎 0

package leetcode.editor.cn;
//Java：Kth Smallest Element in a Sorted Matrix
public class P378KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right){
            int mid = left + (right - left) / 2;
            if(check(matrix,mid,k,n)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid , int k, int n){
        int row = n - 1;
        int col = 0;
        int num = 0;
        while (row >= 0 && col < n){
            if(mid >= matrix[row][col]){
                num += row + 1;
                col++;
            }else {
                row--;
            }
        }
        return num >= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



