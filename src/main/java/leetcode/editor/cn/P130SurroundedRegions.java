//Given an m x n matrix board containing 'X' and 'O', capture all regions surrou
//nded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//.
//
//
// Example 1:
//
//
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O"
//,"X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X
//"]]
//Explanation: Surrounded regions should not be on the border, which means that
//any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not o
//n the border and it is not connected to an 'O' on the border will be flipped to
//'X'. Two cells are connected if they are adjacent cells connected horizontally o
//r vertically.
//
//
// Example 2:
//
//
//Input: board = [["X"]]
//Output: [["X"]]
//
//
//
// Constraints:
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 549 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

//Java：Surrounded Regions dfs bfs 并查集
// 2021-08-08 review 1
public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public void solve(char[][] board) {
            int n = board.length;
            if (n == 0) {
                return;
            }
            int m = board[0].length;
            Queue<int []> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O') {
                    queue.offer(new int[]{i, 0});
                }
                if (board[i][m - 1] == 'O') {
                    queue.offer(new int[]{i, m - 1});
                }
            }
            for (int i = 1; i < m - 1; i++) {
                if (board[0][i] == 'O') {
                    queue.offer(new int[]{0, i});
                }
                if (board[n - 1][i] == 'O') {
                    queue.offer(new int[]{n - 1, i});
                }
            }
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                board[x][y] = 'A';
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                        continue;
                    }
                    queue.offer(new int[]{mx, my});
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



