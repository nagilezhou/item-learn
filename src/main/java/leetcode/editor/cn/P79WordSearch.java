//Given an m x n grid of characters board and a string word, return true if word
// exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cells, wher
//e adjacent cells are horizontally or vertically neighboring. The same letter cel
//l may not be used more than once.
//
//
// Example 1:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
//
//
// Example 2:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
//
//
// Example 3:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
//
//
//
// Constraints:
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.
//
//
//
// Follow up: Could you use search pruning to make your solution faster with a l
//arger board?
// Related Topics 数组 回溯算法
// 👍 925 👎 0

package leetcode.editor.cn;

//Java：Word Search dfs+backtrack
// 2021-08-01 review 1
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        System.out.println(solution
            .exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        int m;
        int n;
        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (backtrack(board, visited, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean backtrack(char[][] board, boolean[][] visited, String word, int row, int col, int begin) {
            if (begin == word.length() - 1) {
                return board[row][col] == word.charAt(begin);
            }
            if (board[row][col] == word.charAt(begin)) {
                visited[row][col] = true;
                for (int d = 0; d < 4; d++) {
                    int nextRow = row + di[d];
                    int nextCol = col + dj[d];
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {
                        if(backtrack(board, visited, word, nextRow, nextCol, begin + 1)){
                            return true;
                        }
                    }
                }
                visited[row][col] = false;
            }
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



