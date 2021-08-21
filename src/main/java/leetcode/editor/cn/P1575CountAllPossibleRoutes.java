//You are given an array of distinct positive integers locations where locations
//[i] represents the position of city i. You are also given integers start, finish
// and fuel representing the starting city, ending city, and the initial amount of
// fuel you have, respectively.
//
// At each step, if you are at city i, you can pick any city j such that j != i
//and 0 <= j < locations.length and move to city j. Moving from city i to city j r
//educes the amount of fuel you have by |locations[i] - locations[j]|. Please noti
//ce that |x| denotes the absolute value of x.
//
// Notice that fuel cannot become negative at any point in time, and that you ar
//e allowed to visit any city more than once (including start and finish).
//
// Return the count of all possible routes from start to finish.
//
// Since the answer may be too large, return it modulo 10^9 + 7.
//
//
// Example 1:
//
//
//Input: locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
//Output: 4
//Explanation: The following are all possible routes, each uses 5 units of fuel:
//
//1 -> 3
//1 -> 2 -> 3
//1 -> 4 -> 3
//1 -> 4 -> 2 -> 3
//
//
// Example 2:
//
//
//Input: locations = [4,3,1], start = 1, finish = 0, fuel = 6
//Output: 5
//Explanation: The following are all possible routes:
//1 -> 0, used fuel = 1
//1 -> 2 -> 0, used fuel = 5
//1 -> 2 -> 1 -> 0, used fuel = 5
//1 -> 0 -> 1 -> 0, used fuel = 3
//1 -> 0 -> 1 -> 0 -> 1 -> 0, used fuel = 5
//
//
// Example 3:
//
//
//Input: locations = [5,2,1], start = 0, finish = 2, fuel = 3
//Output: 0
//Explanation: It's impossible to get from 0 to 2 using only 3 units of fuel sin
//ce the shortest route needs 4 units of fuel.
//
// Example 4:
//
//
//Input: locations = [2,1,5], start = 0, finish = 0, fuel = 3
//Output: 2
//Explanation: There are two possible routes, 0 and 0 -> 1 -> 0.
//
// Example 5:
//
//
//Input: locations = [1,2,3], start = 0, finish = 2, fuel = 40
//Output: 615088286
//Explanation: The total number of possible routes is 2615088300. Taking this nu
//mber modulo 10^9 + 7 gives us 615088286.
//
//
//
// Constraints:
//
//
// 2 <= locations.length <= 100
// 1 <= locations[i] <= 10^9
// All integers in locations are distinct.
// 0 <= start, finish < locations.length
// 1 <= fuel <= 200
//
// Related Topics 记忆化搜索 数组 动态规划
// 👍 29 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Count All Possible Routes 数组 dp
// 2021-08-21 review 1
public class P1575CountAllPossibleRoutes {
    public static void main(String[] args) {
        Solution solution = new P1575CountAllPossibleRoutes().new Solution();
        System.out.println(solution.countRoutes(
            new int[] {46, 75, 85, 43, 62, 92, 22, 89, 107, 73, 98, 93, 36, 32, 81, 101, 71, 109, 11, 56, 13, 54, 86,
                80, 44, 66, 14, 9, 23, 84, 91, 16, 17, 33, 64, 7, 60}, 22, 4, 50));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = 1000000007;

        public int countRoutes(int[] ls, int start, int end, int fuel) {
            int n = ls.length;

            // dp[i][j] 代表从位置 i 出发，当前油量为 j 时，到达目的地的路径数
            int[][] dp = new int[n][fuel + 1];

            // 对于本身位置就在目的地的状态，路径数为 1
            for (int i = 0; i <= fuel; i++) { dp[end][i] = 1; }

            // 从状态转移方程可以发现 dp[i][fuel]=dp[i][fuel]+dp[k][fuel-need]
            // 在计算 dp[i][fuel] 的时候依赖于 dp[k][fuel-need]
            // 其中 i 和 k 并无严格的大小关系
            // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
            // 因此需要先从小到大枚举油量
            for (int cur = 0; cur <= fuel; cur++) {
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < n; k++) {
                        if (i != k) {
                            int need = Math.abs(ls[i] - ls[k]);
                            if (cur >= need) {
                                dp[i][cur] += dp[k][cur - need];
                                dp[i][cur] %= mod;
                            }
                        }
                    }
                }
            }
            return dp[start][fuel];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}



