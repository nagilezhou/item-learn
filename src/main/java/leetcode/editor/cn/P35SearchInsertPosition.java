//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order.
//
//
// Example 1:
// Input: nums = [1,3,5,6], target = 5
//Output: 2
// Example 2:
// Input: nums = [1,3,5,6], target = 2
//Output: 1
// Example 3:
// Input: nums = [1,3,5,6], target = 7
//Output: 4
// Example 4:
// Input: nums = [1,3,5,6], target = 0
//Output: 0
// Example 5:
// Input: nums = [1], target = 0
//Output: 0
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums contains distinct values sorted in ascending order.
// -104 <= target <= 104
//
// Related Topics 数组 二分查找
// 👍 738 👎 0

package leetcode.editor.cn;

//Java：Search Insert Position 二分
// 2021-08-01 review 1
public class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6},7));
        // TO TEST
        //System.out.println(1 / 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            if(target > nums[high]){
                return high + 1;
            }
            while (low < high){
                int mid = ((high - low) >> 1) + low;
                if (nums[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



