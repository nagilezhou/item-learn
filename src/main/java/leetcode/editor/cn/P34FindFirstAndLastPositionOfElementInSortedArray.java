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

//Java：Find First and Last Position of Element in Sorted Array 二分
// 2021-07-31 review 1
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        int[] test = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution.searchRange(test,8)));
        System.out.println(solution.binarySearch(test,8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int binarySearch(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;//这里要-1
            while (low < high) {//这里取等于
                int mid = low + high + 1 >> 1;
                if (nums[mid] <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1,-1};
            if(nums.length <= 0){
                return ans;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right){
                int mid = left + (right - left) / 2;
                if(nums[mid] >= target){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            if (nums[left] != target) {
                return ans;
            }
            ans[0] = left;
            left = 0;
            right = nums.length - 1;
            while (left < right){
                int mid = left + (right - left) / 2 + 1;
                if(nums[mid] <= target){
                    left = mid;
                }else {
                    right = mid - 1;
                }
            }
            if (nums[left] != target) {
                return ans;
            }
            ans[1] = left;
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



