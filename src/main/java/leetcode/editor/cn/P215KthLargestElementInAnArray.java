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
        System.out.println(solution.findKthLargest(new int[] {3,2,1,5,6,4}, 8));
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

        private Random random = new Random();

        private int partition(int[] nums, int left, int right) {
            if(left < right){
                int randomIndex = left + 1 + random.nextInt(right - left);
                swap(nums, left, randomIndex);
            }
            int pivot = left;
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < nums[pivot]) {
                    j++;
                    // j 的初值为 left，先右移，再交换，小于 pivot 的元素都被交换到前面
                    swap(nums, i, j);
                }
            }
            // 在之前遍历的过程中，满足 nums[left + 1..j] < pivot，并且 nums(j..i) >= pivot
            swap(nums, pivot, j);
            // 交换以后 nums[left..j - 1] < pivot, nums[j] = pivot, nums[j + 1..right] >= pivot
            return j;
        }

        //private int partition(int[] nums, int left, int right) {
        //    if(left < right){
        //        dealPivot(nums, left, right);
        //    }
        //    int pivot = right - 1;
        //    int i = left;
        //    int j = pivot;
        //    while (true){
        //        while (i < j && nums[++i] < nums[pivot]){
        //
        //        }
        //        while (j > i && nums[--j] > nums[pivot]){
        //
        //        }
        //        if(i < j){
        //            swap(nums, i ,j);
        //        }else {
        //            break;
        //        }
        //    }
        //    if(left < right){
        //        swap(nums, i, pivot);
        //    }
        //    return i;
        //}

        //private void dealPivot(int[] nums, int left, int right) {
        //    int mid = left + right >> 1;
        //    if (nums[left] > nums[mid]) {
        //        swap(nums, left, mid);
        //    }
        //    if (nums[left] > nums[right]) {
        //        swap(nums, left, right);
        //    }
        //    if (nums[mid] > nums[right]) {
        //        swap(nums, mid, right);
        //    }
        //    swap(nums, mid, right - 1);
        //}

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



