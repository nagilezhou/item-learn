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

import java.util.PriorityQueue;
import java.util.Random;

//Java：Kth Largest Element in an Array 快排 堆排
// 2021-08-14 review 1
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[] {1}, 1));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthLargest(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k <= 0) {
                return -1;
            }
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            int target = len - k;
            while (true) {
                int index = partition(nums, left, right);
                if(index == target){
                    return nums[index];
                }else if(index < target){
                    left = index + 1;
                }else {
                    right = index - 1;
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            if(left < right){
                dealPivot(nums, left, right);
            }
            int pivot = right - 1;
            int i = left;
            int j = pivot;
            while (true){
                while (i < j && nums[++i] < nums[pivot]){

                }
                while (j > i && nums[--j] > nums[pivot]){

                }
                if(i < j){
                    swap(nums, i ,j);
                }else {
                    break;
                }
            }
            if(i < right){
                swap(nums, i, pivot);
            }
            return i;
        }

        private void dealPivot(int[] nums, int left, int right) {
            int mid = left + right >> 1;
            if (nums[left] > nums[mid]) {
                swap(nums, left, mid);
            }
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
            }
            if (nums[mid] > nums[right]) {
                swap(nums, mid, right);
            }
            swap(nums, mid, right - 1);
        }

        private void swap(int nums[], int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }


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

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



