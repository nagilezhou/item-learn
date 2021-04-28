//Given an integer array nums and an integer k, return the kth largest element i
//n the array.
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element.
//
//
// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
//
//
// Constraints:
//
//
// 1 <= k <= nums.length <= 104
// -104 <= nums[i] <= 104
//
// Related Topics 堆 分治算法
// 👍 1050 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

//Java：Kth Largest Element in an Array
public class P215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 0 || nums.length < k){
            return -1;
        }
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, Integer::compareTo);
        for (int i = 0; i < len; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



