//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value.
//
// If target is not found in the array, return [-1, -1].
//
// You must write an algorithm with O(log n) runtime complexity.
//
//
// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3:
// Input: nums = [], target = 0
//Output: [-1,-1]
//
//
// Constraints:
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109
//
// Related Topics 数组 二分查找
// 👍 995 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Find First and Last Position of Element in Sorted Array
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        int[] test = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution.searchRange(test,8)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            return nums.length == 0 ? new int[] {-1, -1} :
                new int[] {findLeft(nums, target), findRight(nums, target)};
        }

        private int findLeft(int[] nums, int target) {
            int low = 0;
            int high = nums.length;
            int mid;
            while (low < high) {
                mid = low + ((high - low) >> 1);
                if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return target == nums[low] ? low : -1;
        }

        private int findRight(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid;
            while (low <= high) {
                mid = low + ((high - low) >> 1);
                if (target >= nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return target == nums[high] ? high : -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



