//Given an array of integers nums and an integer limit, return the size of the l
//ongest non-empty subarray such that the absolute difference between any two elem
//ents of this subarray is less than or equal to limit.
//
//
// Example 1:
//
//
//Input: nums = [8,2,4,7], limit = 4
//Output: 2
//Explanation: All subarrays are:
//[8] with maximum absolute diff |8-8| = 0 <= 4.
//[8,2] with maximum absolute diff |8-2| = 6 > 4.
//[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
//[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
//[2] with maximum absolute diff |2-2| = 0 <= 4.
//[2,4] with maximum absolute diff |2-4| = 2 <= 4.
//[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
//[4] with maximum absolute diff |4-4| = 0 <= 4.
//[4,7] with maximum absolute diff |4-7| = 3 <= 4.
//[7] with maximum absolute diff |7-7| = 0 <= 4.
//Therefore, the size of the longest subarray is 2.
//
//
// Example 2:
//
//
//Input: nums = [10,1,2,4,7,2], limit = 5
//Output: 4
//Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute
//diff is |2-7| = 5 <= 5.
//
//
// Example 3:
//
//
//Input: nums = [4,2,2,2,4,4,2,2], limit = 0
//Output: 3
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 109
// 0 <= limit <= 109
//
// Related Topics 队列 数组 有序集合 滑动窗口 单调队列 堆（优先队列）
// 👍 201 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit 数组 动态规划 栈
// 2021-08-21 review 1
public class P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        Solution solution = new P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
        System.out.println(solution.longestSubarray(new int[] {8, 2, 4, 7}, 4));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> queMax = new LinkedList<Integer>();
            Deque<Integer> queMin = new LinkedList<Integer>();
            int n = nums.length;
            int left = 0, right = 0;
            int res = 0;
            while (right < n) {
                while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                    queMax.pollLast();
                }
                while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                    queMin.pollLast();
                }
                queMax.offerLast(nums[right]);
                queMin.offerLast(nums[right]);
                while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                    if (nums[left] == queMin.peekFirst()) {
                        queMin.pollFirst();
                    }
                    if (nums[left] == queMax.peekFirst()) {
                        queMax.pollFirst();
                    }
                    left++;
                }
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



