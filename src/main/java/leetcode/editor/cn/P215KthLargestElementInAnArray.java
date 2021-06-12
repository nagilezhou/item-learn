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
import java.util.Random;

//Java：Kth Largest Element in an Array
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Random random = new Random(System.currentTimeMillis());

        // 堆排序
        public int findKthLargest2(int[] nums, int k) {
            if (nums == null || k < 0 || nums.length < k) {
                return -1;
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
            for (int num : nums) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            return heap.peek();
        }

        // 快排序
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            int target = len - k;
            while (true) {
                int index = partition(nums, left, right);
                if (target == index) {
                    return nums[target];
                } else if (index < target) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            if (right > left) {
                int randomIndex = left + 1 + random.nextInt(right - left);
                swap(nums, left, randomIndex);
            }
            int pivot = nums[left];
            int lt = left + 1;
            int rt = right;
            while (true){
                while (lt <= rt && nums[lt] < pivot) {
                    lt++;
                }
                while (lt <= rt && nums[rt] > pivot) {
                    rt--;
                }
                if (lt > rt) {
                    break;
                }
                swap(nums, lt, rt);
                lt++;
                rt--;
            }
            swap(nums, left, rt);
            return rt;
        }

        private int partition2(int[] nums, int left, int right) {
            int pivot = nums[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    j++;
                    swap(nums, i, j);
                }
            }
            swap(nums, left, j);
            return j;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}



