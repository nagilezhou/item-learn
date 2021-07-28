//Given a binary array nums and an integer k, return the maximum number of conse
//cutive 1's in the array if you can flip at most k 0's.
//
//
// Example 1:
//
//
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
// Example 2:
//
//
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
// 0 <= k <= nums.length
//
// Related Topics 数组 二分查找 前缀和 滑动窗口
// 👍 304 👎 0

package leetcode.editor.cn;

//Java：Max Consecutive Ones III
public class P1004MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new P1004MaxConsecutiveOnesIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int res = 0;
            int left = 0;
            int right = 0;
            int zeros = 0;
            while (right < nums.length) {
                if (nums[right] == 0) {
                    zeros++;
                }
                while (zeros > k) {
                    if (nums[left++] == 0) {
                        zeros--;
                    }
                }
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



