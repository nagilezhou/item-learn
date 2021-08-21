//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have a security system connected, and it will automatically c
//ontact the police if two adjacent houses were broken into on the same night.
//
// Given an integer array nums representing the amount of money of each house, r
//eturn the maximum amount of money you can rob tonight without alerting the polic
//e.
//
//
// Example 1:
//
//
//Input: nums = [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
//2), because they are adjacent houses.
//
//
// Example 2:
//
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//
//
// Example 3:
//
//
//Input: nums = [0]
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000
//
// Related Topics 动态规划
// 👍 682 👎 0

package leetcode.editor.cn;

//Java：House Robber II dp
// 2021-08-14 review 1
public class P213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new P213HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[] {2, 1, 1, 2}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }else if (nums.length == 2){
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(robHelp(nums, 0, nums.length - 1), robHelp(nums, 1, nums.length));
        }

        public int robHelp(int[] nums, int start, int end) {
            int first = nums[start];
            int second = Math.max(first, nums[start + 1]);
            for (int i = start + 2; i < end; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



