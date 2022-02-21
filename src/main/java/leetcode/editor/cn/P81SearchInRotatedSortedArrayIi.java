//There is an integer array nums sorted in non-decreasing order (not necessarily
// with distinct values).
//
// Before being passed to your function, nums is rotated at an unknown pivot ind
//ex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4].
//
// Given the array nums after the rotation and an integer target, return true if
// target is in nums, or false if it is not in nums.
//
// You must decrease the overall operation steps as much as possible.
//
//
// Example 1:
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2:
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// nums is guaranteed to be rotated at some pivot.
// -104 <= target <= 104
//
//
//
// Follow up: This problem is similar to Search in Rotated Sorted Array, but num
//s may contain duplicates. Would this affect the runtime complexity? How and why?
//
// Related Topics 数组 二分查找
// 👍 536 👎 0

package leetcode.editor.cn;
//Java：Search in Rotated Sorted Array II
public class P81SearchInRotatedSortedArrayIi{
    public static void main(String[] args) {
        Solution solution = new P81SearchInRotatedSortedArrayIi().new Solution();
        System.out.println(solution.search(new int[]{1,0,1,1,1}, 0));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        // 第一次「二分」：从中间开始找，找到满足 >=nums[0] 的分割点（旋转点）
        int left = 0, right = n - 1;
        while (left < right && nums[0] == nums[right]) right--;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        // 第二次「二分」：通过和 nums[0] 进行比较，得知 target 是在旋转点的左边还是右边
        if (target >= nums[0]) {
            left = 0;
        } else {
            left = left + 1;
            right = n - 1;
        }
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[right] == target ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



