//Alice and Bob play a game with piles of stones. There are an even number of pi
//les arranged in a row, and each pile has a positive integer number of stones pil
//es[i].
//
// The objective of the game is to end with the most stones. The total number of
// stones across all the piles is odd, so there are no ties.
//
// Alice and Bob take turns, with Alice starting first. Each turn, a player take
//s the entire pile of stones either from the beginning or from the end of the row
//. This continues until there are no more piles left, at which point the person w
//ith the most stones wins.
//
// Assuming Alice and Bob play optimally, return true if Alice wins the game, or
// false if Bob wins.
//
//
// Example 1:
//
//
//Input: piles = [5,3,4,5]
//Output: true
//Explanation:
//Alice starts first, and can only take the first 5 or the last 5.
//Say she takes the first 5, so that the row becomes [3, 4, 5].
//If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 poi
//nts.
//If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win wi
//th 9 points.
//This demonstrated that taking the first 5 was a winning move for Alice, so we
//return true.
//
//
// Example 2:
//
//
//Input: piles = [3,7,2,3]
//Output: true
//
//
//
// Constraints:
//
//
// 2 <= piles.length <= 500
// piles.length is even.
// 1 <= piles[i] <= 500
// sum(piles[i]) is odd.
//
// Related Topics 数组 数学 动态规划 博弈
// 👍 402 👎 0

package leetcode.editor.cn;

//Java：Stone Game
public class P877StoneGame {
    public static void main(String[] args) {
        Solution solution = new P877StoneGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = piles[i];
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
            return dp[0][n-1] > 0;
        }

        public boolean stoneGame2(int[] piles) {
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



