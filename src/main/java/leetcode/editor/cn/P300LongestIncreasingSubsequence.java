//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence.
//
// A subsequence is a sequence that can be derived from an array by deleting som
//e or no elements without changing the order of the remaining elements. For examp
//le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//
//
// Example 1:
//
//
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
//length is 4.
//
//
// Example 2:
//
//
//Input: nums = [0,1,0,3,2,3]
//Output: 4
//
//
// Example 3:
//
//
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
//
//
//
// Follow up:
//
//
// Could you come up with the O(n2) solution?
// Could you improve it to O(n log(n)) time complexity?
//
// Related Topics 二分查找 动态规划
// 👍 1597 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Longest Increasing Subsequence
public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[] {4, 10, 4, 3, 8, 9}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dp n*n
        public int lengthOfLIS2(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        // dp+二分优化 nlogn 贪心算大
        public int lengthOfLIS3(int[] nums) {
            int len = nums.length;
            if (len <= 1) {
                return len;
            }

            // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
            int[] tail = new int[len];
            // 遍历第 1 个数，直接放在有序数组 tail 的开头
            tail[0] = nums[0];
            // end 表示有序数组 tail 的最后一个已经赋值元素的索引
            int end = 0;

            for (int i = 1; i < len; i++) {
                // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
                if (nums[i] > tail[end]) {
                    // 直接添加在那个元素的后面，所以 end 先加 1
                    end++;
                    tail[end] = nums[i];
                } else {
                    // 使用二分查找法，在有序数组 tail 中
                    // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                    int left = 0;
                    int right = end;
                    while (left < right) {
                        // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                        // int mid = left + (right - left) / 2;
                        int mid = left + right >> 1;
                        if (tail[mid] >= nums[i]) {
                            // 中位数肯定不是要找的数，把它写在分支的前面
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    }
                    // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                    // 因此，无需再单独判断
                    tail[left] = nums[i];
                }
            }
            // 此时 end 是有序数组 tail 最后一个元素的索引
            // 题目要求返回的是长度，因此 +1 后返回
            //System.out.println(Arrays.toString(tail));
            end++;
            return end;
        }

        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int end = 0;
            for(int i = 0; i < n; i++){
                int left = 0;
                int right = end;
                while (left < right){
                    int mid = left + right >> 1;
                    if (dp[mid] >= nums[i]){
                        right = mid;
                    }else {
                        left = mid + 1;
                    }
                }
                if(left == end){
                    end++;
                }
                dp[left] = nums[i];
            }
            //System.out.println(Arrays.toString(dp));
            return end ;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



