//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security systems connected and
//it will automatically contact the police if two adjacent houses were broken into
// on the same night.
//
// Given an integer array nums representing the amount of money of each house, r
//eturn the maximum amount of money you can rob tonight without alerting the polic
//e.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//
//
// Example 2:
//
//
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
//(money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
// Related Topics 动态规划
// 👍 1391 👎 0

package leetcode.editor.cn;

//Java：House Robber dp
// 2021-08-12 review 1
public class P198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198HouseRobber().new Solution();
        // TO TEST
        System.out.println(solution.rob(new int[] {100, 120, 30, 50, 10, 500, 1000, 1500}));
        // 100 120 130 170 170 670 1170 2170
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[] dp = new int[n + 1];
            dp[1] = nums[0];
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



