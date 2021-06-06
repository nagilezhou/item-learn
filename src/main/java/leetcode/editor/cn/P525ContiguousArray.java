//Given a binary array nums, return the maximum length of a contiguous subarray
//with an equal number of 0 and 1.
//
//
// Example 1:
//
//
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number of
// 0 and 1.
//
//
// Example 2:
//
//
//Input: nums = [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal nu
//mber of 0 and 1.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
//
// Related Topics 哈希表
// 👍 411 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：Contiguous Array
public class P525ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new P525ContiguousArray().new Solution();
        System.out.println(solution.findMaxLength(new int[] {1,1,0,0,1,1,1,1,1,1,0,0,0}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + (nums[i-1] == 0 ? -1 : 1);
            }

            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 2; i <= n; i++) {
                if (!map.containsKey(sum[i - 2])) {
                    map.put(sum[i - 2], i - 2);
                }
                if(map.containsKey(sum[i])){
                    res = Math.max(res, i - map.get(sum[i]));
                }
            }
            return res;
        }

        //呆瓜dp
        public int findMaxLength2(int[] nums) {
            int[][] dp = new int[nums.length][nums.length];
            int maxLength = 0;
            dp[0][0] = (nums[0] == 0 ? -1 : 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= i; j++) {
                    dp[j][i] = dp[j][i - 1] + (nums[i] == 0 ? -1 : 1);
                    if (dp[j][i] == 0) {
                        maxLength = Math.max(maxLength, i - j + 1);
                    }
                }
            }
            return maxLength;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



