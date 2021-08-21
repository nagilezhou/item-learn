//Given an array nums of size n, return the majority element.
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. You
// may assume that the majority element always exists in the array.
//
//
// Example 1:
// Input: nums = [3,2,3]
//Output: 3
// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 5 * 104
// -231 <= nums[i] <= 231 - 1
//
//
//
//Follow-up: Could you solve the problem in linear time and in O(1) space? Relat
//ed Topics 位运算 数组 分治算法
// 👍 971 👎 0

package leetcode.editor.cn;
//Java：Majority Element 数组 抵消法(投票)
// 2021-08-12 review 1
public class P169MajorityElement{
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int candidate = nums[0];
        int ballot = 1;
        for(int i = 1; i < nums.length; i++){
            if(candidate != nums[i]){
                ballot--;
                if(ballot == -1){
                    candidate = nums[i];
                    ballot = 1;
                }
            }else {
                ballot++;
            }
        }
        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



