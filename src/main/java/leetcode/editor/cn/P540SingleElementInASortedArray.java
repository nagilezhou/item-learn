//You are given a sorted array consisting of only integers where every element a
//ppears exactly twice, except for one element which appears exactly once. Find th
//is single element that appears only once.
//
// Follow up: Your solution should run in O(log n) time and O(1) space.
//
//
// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2
// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
//Output: 10
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10^5
// 0 <= nums[i] <= 10^5
// Related Topics 二分查找
// 👍 240 👎 0

package leetcode.editor.cn;

//Java：Single Element in a Sorted Array
public class P540SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new P540SingleElementInASortedArray().new Solution();
        //System.out.println(solution.singleNonDuplicate(new int[]{1,1,2,3,3,4,4}));
        System.out.println(solution.singleNonDuplicate(new int[]{1,1,2,2,3,4,4}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if(nums[mid] == nums[mid - 1]){
                    mid = mid - 1;
                }else if(nums[mid] == nums[mid + 1]){
                    mid = mid;
                }else {
                    return nums[mid];
                }
                if((mid - low) % 2 == 1){
                    high = mid - 1;
                }else {
                    low = mid + 2;
                }

            }
            return nums[low];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



