//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal.
//
//
// Example 1:
//
//
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
//
// Example 2:
//
//
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
// Related Topics 数组 动态规划
// 👍 850 👎 0

package leetcode.editor.cn;

//Java：Partition Equal Subset Sum dp 01背包
// 2021-08-21 review 1
public class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[] {2, 2}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            int n = nums.length;
            int target = sum / 2;
            boolean[][] dp = new boolean[n + 1][target + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                int num = nums[i - 1];
                for (int j = 0; j <= target; j++) {
                    boolean no = dp[i - 1][j];
                    // 选该物品
                    boolean yes = j >= num ? dp[i - 1][j - num] : false;
                    dp[i][j] = no | yes;
                }
            }
            return dp[n][target];
        }

        public boolean canPartition2(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            int n = nums.length;
            int target = sum / 2;
            int[][] dp = new int[n][target + 1];

            for (int j = 0; j <= target; j++) {
                dp[0][j] = j >= nums[0] ? nums[0] : 0;
            }

            for (int i = 1; i < n; i++) {
                int num = nums[i];
                for (int j = 0; j <= target; j++) {
                    int no = dp[i - 1][j];

                    int yes = j >= num ? dp[i - 1][j - num] + num : 0;
                    dp[i][j] = Math.max(no, yes);
                }
            }

            return dp[n - 1][target] == target;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



