//Given an integer array nums and an integer k, return true if it is possible to
// divide this array into k non-empty subsets whose sums are all equal.
//
//
// Example 1:
//
//
//Input: nums = [4,3,2,3,5,2,1], k = 4
//Output: true
//Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2
//,3) with equal sums.
//
//
// Example 2:
//
//
//Input: nums = [1,2,3,4], k = 3
//Output: false
//
//
//
// Constraints:
//
//
// 1 <= k <= nums.length <= 16
// 1 <= nums[i] <= 104
// The frequency of each element is in the range [1, 4].
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩
// 👍 500 👎 0

package leetcode.editor.cn;

//Java：Partition to K Equal Sum Subsets
public class P698PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        Solution solution = new P698PartitionToKEqualSumSubsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 注意nums[i] > 0
            int sum = 0, maxNum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (maxNum < nums[i]) { maxNum = nums[i]; }
            }
            if (sum % k != 0 || maxNum > sum / k) { return false; }
            boolean[] used = new boolean[nums.length];
            return backtracking(nums, k, sum / k, 0, 0, used);
        }

        private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
            // 返回条件
            if (k == 0) { return true; }
            if (cur == target) {
                // 构建下一个集合
                return backtracking(nums, k - 1, target, 0, 0, used);
            }
            for (int i = start; i < nums.length; i++) {
                if (!used[i] && cur + nums[i] <= target) {
                    used[i] = true;
                    if (backtracking(nums, k, target, cur + nums[i], i + 1, used)) { return true; }
                    used[i] = false;
                }
            }
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



