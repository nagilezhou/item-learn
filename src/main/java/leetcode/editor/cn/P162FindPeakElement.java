//A peak element is an element that is strictly greater than its neighbors.
//
// Given an integer array nums, find a peak element, and return its index. If th
//e array contains multiple peaks, return the index to any of the peaks.
//
// You may imagine that nums[-1] = nums[n] = -∞.
//
// You must write an algorithm that runs in O(log n) time.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index num
//ber 2.
//
// Example 2:
//
//
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak ele
//ment is 2, or index number 5 where the peak element is 6.
//
//
// Constraints:
//
//
// 1 <= nums.length <= 1000
// -231 <= nums[i] <= 231 - 1
// nums[i] != nums[i + 1] for all valid i.
//
// Related Topics 数组 二分查找
// 👍 449 👎 0

package leetcode.editor.cn;

//Java：Find Peak Element
public class P162FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new P162FindPeakElement().new Solution();
        System.out.println(solution.findPeakElement(new int[]{1,2,3,4,3,2}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (true){
                int mid = low + (high - low) / 2;
                long target = nums[mid];
                long left;
                if(mid - 1 >= 0){
                    left = nums[mid - 1];
                }else {
                    left = Long.MIN_VALUE;
                }
                long right;
                if(mid + 1 < nums.length){
                    right = nums[mid + 1];
                }else {
                    right = Long.MIN_VALUE;
                }
                if(left < target && target > right){
                    return mid;
                }
                if(left < target && right > target){
                    low = mid + 1;
                }
                if(target < left){
                    high = mid - 1;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



