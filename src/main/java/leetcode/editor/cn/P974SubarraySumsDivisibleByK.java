//Given an integer array nums and an integer k, return the number of non-empty s
//ubarrays that have a sum divisible by k.
//
// A subarray is a contiguous part of an array.
//
//
// Example 1:
//
//
//Input: nums = [4,5,0,-2,-3,1], k = 5
//Output: 7
//Explanation: There are 7 subarrays with a sum divisible by k = 5:
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//
//
// Example 2:
//
//
//Input: nums = [5], k = 9
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 104
// -104 <= nums[i] <= 104
// 2 <= k <= 104
//
// Related Topics 数组 哈希表 前缀和
// 👍 343 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：Subarray Sums Divisible by K
public class P974SubarraySumsDivisibleByK{
    public static void main(String[] args) {
        Solution solution = new P974SubarraySumsDivisibleByK().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int mod = (sum % k + k) % k;
            int same = record.getOrDefault(mod, 0);
            ans += same;
            record.put(mod, same + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



