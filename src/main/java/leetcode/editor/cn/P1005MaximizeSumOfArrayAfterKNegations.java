//Given an integer array nums and an integer k, modify the array in the followin
//g way:
//
//
// choose an index i and replace nums[i] with -nums[i].
//
//
// You should apply this process exactly k times. You may choose the same index
//i multiple times.
//
// Return the largest possible sum of the array after modifying it in this way.
//
//
//
// Example 1:
//
//
//Input: nums = [4,2,3], k = 1
//Output: 5
//Explanation: Choose index 1 and nums becomes [4,-2,3].
//
//
// Example 2:
//
//
//Input: nums = [3,-1,0,2], k = 3
//Output: 6
//Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
//
//
// Example 3:
//
//
//Input: nums = [2,-3,-1,5,-4], k = 2
//Output: 13
//Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -100 <= nums[i] <= 100
// 1 <= k <= 104
//
// Related Topics 贪心 数组 排序
// 👍 164 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Maximize Sum Of Array After K Negations
public class P1005MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new P1005MaximizeSumOfArrayAfterKNegations().new Solution();
        System.out.println(solution.largestSumAfterKNegations(new int[] {5, 6, 9, -3, 3}, 2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int res = 0;
            int minAbs = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (k > 0 && nums[i] < 0) {
                    res -= nums[i];
                    k--;
                } else {
                    res += nums[i];
                }
                minAbs = Math.min(minAbs, Math.abs(nums[i]));
            }
            return k % 2 == 0 ? res : res - 2 * minAbs;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



