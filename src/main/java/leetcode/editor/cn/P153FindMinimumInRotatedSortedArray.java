//Suppose an array of length n sorted in ascending order is rotated between 1 an
//d n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//
// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
//
//
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
//in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
// Given the sorted rotated array nums of unique elements, return the minimum el
//ement of this array.
//
// You must write an algorithm that runs in O(log n) time.
//
//
// Example 1:
//
//
//Input: nums = [3,4,5,1,2]
//Output: 1
//Explanation: The original array was [1,2,3,4,5] rotated 3 times.
//
//
// Example 2:
//
//
//Input: nums = [4,5,6,7,0,1,2]
//Output: 0
//Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times
//.
//
//
// Example 3:
//
//
//Input: nums = [11,13,15,17]
//Output: 11
//Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
//
//
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// All the integers of nums are unique.
// nums is sorted and rotated between 1 and n times.
//
// Related Topics 数组 二分查找
// 👍 490 👎 0

package leetcode.editor.cn;

//Java：Find Minimum in Rotated Sorted Array 二分
// 2021-08-09 review 1
public class P153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P153FindMinimumInRotatedSortedArray().new Solution();
        System.out.println(solution.findMin(new int[]{11,13,15,17}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 根据旋转点 将数组一分为二
        public int findMin(int[] nums){
            if(nums == null || nums.length == 0){
                return -1;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low < high){
                int mid = low + high + 1 >> 1;
                if(nums[mid] >= nums[0]){
                    low = mid;
                }else {
                    high = mid - 1;
                }
            }
            return low + 1 < nums.length ? nums[low + 1] : nums[0];
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}



