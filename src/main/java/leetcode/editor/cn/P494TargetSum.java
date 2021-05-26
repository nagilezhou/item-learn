//You are given an integer array nums and an integer target.
//
// You want to build an expression out of nums by adding one of the symbols '+'
//and '-' before each integer in nums and then concatenate all the integers.
//
//
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
//and concatenate them to build the expression "+2-1".
//
//
// Return the number of different expressions that you can build, which evaluate
//s to target.
//
//
// Example 1:
//
//
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be tar
//get 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//
//
// Example 2:
//
//
//Input: nums = [1], target = 1
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000
//
// Related Topics 深度优先搜索 动态规划
// 👍 672 👎 0

package leetcode.editor.cn;

//Java：Target Sum
public class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            if (nums == null) {
                return 0;
            }
            return backtrack(nums, target, 0);
        }

        public int backtrack(int[] nums, int target, int begin) {
            if (begin == nums.length) {
                if (target == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            int res = 0;
            res += backtrack(nums, target - nums[begin], begin + 1);
            res += backtrack(nums, target + nums[begin], begin + 1);
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



