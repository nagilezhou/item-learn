//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be v
//alidated according to the following rules:
//
//
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 with
//out repetition.
//
//
// Note:
//
//
// A Sudoku board (partially filled) could be valid but is not necessarily solva
//ble.
// Only the filled cells need to be validated according to the mentioned rules.
//
//
//
//
// Example 1:
//
//
//Input: board =
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
//
//
// Example 2:
//
//
//Input: board =
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being
// modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is inval
//id.
//
//
//
// Constraints:
//
//
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit or '.'.
//
// Related Topics 数组 哈希表 Matrix
// 👍 533 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：Valid Sudoku 哈希表
// 2021-08-01 review 1
public class P36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new P36ValidSudoku().new Solution();
        char[][] board = new char[][] {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(solution.isValidSudoku(board));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int len = board.length;
            Set<Character>[][] positionSets = new HashSet[len][2];
            for(int i = 0; i < len; i++){
                for(int j = 0; j < 2; j++){
                    positionSets[i][j] = new HashSet<>();
                }
            }
            Set<Character>[][] layerSets = new HashSet[len / 3][len / 3];
            for(int i = 0; i < len / 3; i++){
                for(int j = 0; j < len / 3; j++){
                    layerSets[i][j] = new HashSet<>();
                }
            }
            for (int row = 0; row < len; row++) {
                for (int col = 0; col < len; col++) {
                    //  row = 0 col = 1
                    char c = board[row][col];
                    if (c < '0' || c > '9') {
                        continue;
                    }
                    Set<Character> positionRowSet = positionSets[row][0];
                    if (positionRowSet.contains(c)) {
                        return false;
                    }
                    positionRowSet.add(c);
                    Set<Character> positionColSet = positionSets[col][1];
                    if (positionColSet.contains(c)) {
                        return false;
                    }
                    positionColSet.add(c);
                    Set<Character> layerSet = layerSets[row / 3][col / 3];
                    if (layerSet.contains(c)) {
                        return false;
                    }
                    layerSet.add(c);
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



