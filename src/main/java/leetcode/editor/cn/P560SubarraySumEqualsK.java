//Given an array of integers nums and an integer k, return the total number of c
//ontinuous subarrays whose sum equals to k.
//
//
// Example 1:
// Input: nums = [1,1,1], k = 2
//Output: 2
// Example 2:
// Input: nums = [1,2,3], k = 3
//Output: 2
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
//
// Related Topics 数组 哈希表
// 👍 939 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：Subarray Sum Equals K
public class P560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1,1,1},2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] sums = new int[nums.length + 1];
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(sums[i - 1], map.getOrDefault(sums[i - 1], 0) + 1);
                if (map.containsKey(sums[i] - k)){
                    res += map.get(sums[i] - k);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



