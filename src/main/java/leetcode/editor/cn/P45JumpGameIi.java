//Given an array of non-negative integers nums, you are initially positioned at
//the first index of the array.
//
// Each element in the array represents your maximum jump length at that positio
//n.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// You can assume that you can always reach the last index.
//
//
// Example 1:
//
//
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
//step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
//Input: nums = [2,3,0,1,4]
//Output: 2
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000
//
// Related Topics 贪心算法 数组 动态规划
// 👍 1026 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Jump Game II 贪心
// 2021-08-01 review 1
public class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[] {2, 3, 1, 1, 4}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int jump(int[] nums) {
            int max = 0;
            int end = 0;
            int step = 0;
            for(int i = 0; i < nums.length - 1; i++){
                max = Math.max(max, nums[i] + i);
                if(end == i){
                    step++;
                    end = max;
                }
            }
            return step;
        }

        public int jump2(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 1; j <= nums[i]; j++) {
                    int index = i + j;
                    if (index >= n) {
                        continue;
                    }
                    dp[index] = Math.min(dp[index], dp[i] + 1);
                }
            }
            return dp[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



