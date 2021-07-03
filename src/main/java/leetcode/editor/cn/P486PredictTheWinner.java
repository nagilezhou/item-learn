//You are given an integer array nums. Two players are playing a game with this
//array: player 1 and player 2.
//
// Player 1 and player 2 take turns, with player 1 starting first. Both players
//start the game with a score of 0. At each turn, the player takes one of the numb
//ers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which
//reduces the size of the array by 1. The player adds the chosen number to their s
//core. The game ends when there are no more elements in the array.
//
// Return true if Player 1 can win the game. If the scores of both players are e
//qual, then player 1 is still the winner, and you should also return true. You ma
//y assume that both players are playing optimally.
//
//
// Example 1:
//
//
//Input: nums = [1,5,2]
//Output: false
//Explanation: Initially, player 1 can choose between 1 and 2.
//If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If playe
//r 2 chooses 5, then player 1 will be left with 1 (or 2).
//So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
//Hence, player 1 will never be the winner and you need to return false.
//
//
// Example 2:
//
//
//Input: nums = [1,5,233,7]
//Output: true
//Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 a
//nd 7. No matter which number player 2 choose, player 1 can choose 233.
//Finally, player 1 has more score (234) than player 2 (12), so you need to retu
//rn True representing player1 can win.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 107
//
// Related Topics 递归 数组 数学 动态规划 博弈
// 👍 458 👎 0

package leetcode.editor.cn;
//Java：Predict the Winner
public class P486PredictTheWinner{
    public static void main(String[] args) {
        Solution solution = new P486PredictTheWinner().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        // TODO moxu
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



