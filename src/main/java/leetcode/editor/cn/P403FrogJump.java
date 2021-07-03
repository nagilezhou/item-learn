//A frog is crossing a river. The river is divided into some number of units, an
//d at each unit, there may or may not exist a stone. The frog can jump on a stone
//, but it must not jump into the water.
//
// Given a list of stones' positions (in units) in sorted ascending order, deter
//mine if the frog can cross the river by landing on the last stone. Initially, th
//e frog is on the first stone and assumes the first jump must be 1 unit.
//
// If the frog's last jump was k units, its next jump must be either k - 1, k, o
//r k + 1 units. The frog can only jump in the forward direction.
//
//
// Example 1:
//
//
//Input: stones = [0,1,3,5,6,8,12,17]
//Output: true
//Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd
//stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 unit
//s to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
//
//
// Example 2:
//
//
//Input: stones = [0,1,2,3,4,8,9,11]
//Output: false
//Explanation: There is no way to jump to the last stone as the gap between the
//5th and 6th stone is too large.
//
//
//
// Constraints:
//
//
// 2 <= stones.length <= 2000
// 0 <= stones[i] <= 231 - 1
// stones[0] == 0
//
// Related Topics 数组 动态规划
// 👍 346 👎 0

package leetcode.editor.cn;
//Java：Frog Jump
public class P403FrogJump{
    public static void main(String[] args) {
        Solution solution = new P403FrogJump().new Solution();
        System.out.println(solution.canCross(new int[]{0,1,2,4,5,6,100}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1] != 1){
            return false;
        }

        boolean[][] dp = new boolean[n][n];
        dp[1][1] = true;
        for(int i = 2; i < n; i++){
            for(int j = 1; j < i; j++){
                int k = stones[i] - stones[j];

                if(k <= j+ 1){
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                }
            }
        }
        for(int i = 1; i < n; i++){
            if(dp[n - 1][i]){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



