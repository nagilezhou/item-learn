//You are given an array of integers nums, there is a sliding window of size k w
//hich is moving from the very left of the array to the very right. You can only s
//ee the k numbers in the window. Each time the sliding window moves right by one
//position.
//
// Return the max sliding window.
//
//
// Example 1:
//
//
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// Example 2:
//
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
// Example 3:
//
//
//Input: nums = [1,-1], k = 1
//Output: [1,-1]
//
//
// Example 4:
//
//
//Input: nums = [9,11], k = 2
//Output: [11]
//
//
// Example 5:
//
//
//Input: nums = [4,-2], k = 2
//Output: [4]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 960 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//Java：Sliding Window Maximum 滑动窗口 单调队列
// 2021-08-14 review 1
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        System.out.println(solution.maxSlidingWindow(new int [] {1,3,-1,-3,5,3,6,7},3).length);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums == null || nums.length <= 0 || k <= 0){
                return null;
            }
            int right = 0;
            int[] res = new int[nums.length - k + 1];
            int index = 0;
            LinkedList<Integer> list = new LinkedList<>();
            while (right < nums.length) {
                while (!list.isEmpty() && nums[right] > list.peekLast()) {
                    list.removeLast();
                }
                // 不断添加
                list.addLast(nums[right]);
                right++;
                if (right >= k) {
                    res[index++] = list.peekFirst();
                    if (list.peekFirst() == nums[right - k]) {
                        list.removeFirst();
                    }
                }
            }
            return res;
        }
        //leetcode submit region end(Prohibit modification and deletion)

    }
}



