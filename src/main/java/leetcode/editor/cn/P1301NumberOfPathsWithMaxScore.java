//You are given a square board of characters. You can move on the board starting
// at the bottom right square marked with the character 'S'.
//
// You need to reach the top left square marked with the character 'E'. The rest
// of the squares are labeled either with a numeric character 1, 2, ..., 9 or with
// an obstacle 'X'. In one move you can go up, left or up-left (diagonally) only i
//f there is no obstacle there.
//
// Return a list of two integers: the first integer is the maximum sum of numeri
//c characters you can collect, and the second is the number of such paths that yo
//u can take to get that maximum sum, taken modulo 10^9 + 7.
//
// In case there is no path, return [0, 0].
//
//
// Example 1:
// Input: board = ["E23","2X2","12S"]
//Output: [7,1]
// Example 2:
// Input: board = ["E12","1X1","21S"]
//Output: [4,2]
// Example 3:
// Input: board = ["E11","XXX","11S"]
//Output: [0,0]
//
//
// Constraints:
//
//
// 2 <= board.length == board[i].length <= 100
// Related Topics 数组 动态规划 矩阵
// 👍 33 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//Java：Number of Paths with Max Score dp 路径问题
// 2021-08-21 review 1
public class P1301NumberOfPathsWithMaxScore {
    public static void main(String[] args) {
        Solution solution = new P1301NumberOfPathsWithMaxScore().new Solution();
        System.out.println(Arrays.toString(solution.pathsWithMaxScore(Arrays.asList("E11","XXX","11S"))));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] pathsWithMaxScore(List<String> board) {
            int mod = 1000000007;
            int n = board.size();
            int m = board.get(0).length();
            int[][][] dp = new int[n][m][2];

            dp[n - 1][m - 1][1] = 1;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    char c = board.get(i).charAt(j);
                    if (c == 'S' || c == 'X') {
                        continue;
                    }

                    int maxScore = -1;
                    int path = 0;
                    if (i + 1 < n) {
                        if (dp[i + 1][j][1] != -0) {
                            if (dp[i + 1][j][0] == maxScore) {
                                path += dp[i + 1][j][1];
                            } else if (dp[i + 1][j][0] > maxScore) {
                                maxScore = dp[i + 1][j][0];
                                path = dp[i + 1][j][1];
                            }
                        }
                    }
                    if (j + 1 < m) {
                        if (dp[i][j + 1][1] != 0) {
                            if (dp[i][j + 1][0] == maxScore) {
                                path += dp[i][j + 1][1];
                            } else if (dp[i][j + 1][0] > maxScore) {
                                maxScore = dp[i][j + 1][0];
                                path = dp[i][j + 1][1];
                            }
                        }
                    }
                    if (i + 1 < n && j + 1 < m) {
                        if (dp[i + 1][j + 1][1] != 0) {
                            if (dp[i + 1][j + 1][0] == maxScore) {
                                path += dp[i + 1][j + 1][1];
                            } else if (dp[i + 1][j + 1][0] > maxScore) {
                                maxScore = dp[i + 1][j + 1][0];
                                path = dp[i + 1][j + 1][1];
                            }
                        }
                    }

                    if (path != 0) {
                        int num = c == 'E' ? 0 : c - '0';
                        dp[i][j][0] = maxScore + num;
                        dp[i][j][1] = path;
                        dp[i][j][0] %= mod;
                        dp[i][j][1] %= mod;
                    }

                }
            }
            return dp[0][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



