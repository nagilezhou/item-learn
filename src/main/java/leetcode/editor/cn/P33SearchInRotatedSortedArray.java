//There is an integer array nums sorted in ascending order (with distinct values
//).
//
// Prior to being passed to your function, nums is rotated at an unknown pivot i
//ndex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+
//1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example,
//[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
// Given the array nums after the rotation and an integer target, return the ind
//ex of target if it is in nums, or -1 if it is not in nums.
//
// You must write an algorithm with O(log n) runtime complexity.
//
//
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3:
// Input: nums = [1], target = 0
//Output: -1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is guaranteed to be rotated at some pivot.
// -104 <= target <= 104
//
// Related Topics 数组 二分查找
// 👍 1392 👎 0

package leetcode.editor.cn;

//Java：Search in Rotated Sorted Array 二分
// 2021-07-31 review 1
public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        //System.out.println(solution.search(new int[] {1, 2, 3, 4, 5, 6, 7}, 2));
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 0));
        //System.out.println(solution.search(new int[] {5, 6, 7, 1, 2, 3, 4}, 2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return -1;
            }
            if (n == 1) {
                return nums[0] == target ? 0 : -1;
            }

            // 第一次「二分」：从中间开始找，找到满足 >=nums[0] 的分割点（旋转点）
            int low = 0, high = n;
            while (low < high) {
                int mid = low + high >> 1;
                if (nums[0] > nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            // 第二次「二分」：通过和 nums[0] 进行比较，得知 target 是在旋转点的左边还是右边
            if (target >= nums[0]) {
                high = low - 1;
                low = 0;
            } else {
                //low = low ;
                high = n - 1;
            }
            while (low < high) {
                int mid = low + high >> 1;
                if (nums[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return nums[high] == target ? high : -1;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

}



