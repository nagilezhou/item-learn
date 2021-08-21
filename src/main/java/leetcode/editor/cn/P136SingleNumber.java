//Given a non-empty array of integers nums, every element appears twice except f
//or one. Find that single one.
//
// Follow up: Could you implement a solution with a linear runtime complexity an
//d without using extra memory?
//
//
// Example 1:
// Input: nums = [2,2,1]
//Output: 1
// Example 2:
// Input: nums = [4,1,2,1,2]
//Output: 4
// Example 3:
// Input: nums = [1]
//Output: 1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104
// Each element in the array appears twice except for one element which appears
//only once.
//
// Related Topics 位运算 哈希表
// 👍 1839 👎 0

package leetcode.editor.cn;

//Java：Single Number 位运算
// 2021-08-09 review 1
public class P136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        System.out.println(solution.singleNumber(new int[] {2, 2, 1}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res ^= nums[i];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



