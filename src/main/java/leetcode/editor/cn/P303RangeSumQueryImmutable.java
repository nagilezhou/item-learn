//Given an integer array nums, handle multiple queries of the following type:
//
//
// Calculate the sum of the elements of nums between indices left and right incl
//usive where left <= right.
//
//
// Implement the NumArray class:
//
//
// NumArray(int[] nums) Initializes the object with the integer array nums.
// int sumRange(int left, int right) Returns the sum of the elements of nums bet
//ween indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... +
//nums[right]).
//
//
//
// Example 1:
//
//
//Input
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//Output
//[null, 1, -1, -3]
//
//Explanation
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
//numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
//numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -105 <= nums[i] <= 105
// 0 <= left <= right < nums.length
// At most 104 calls will be made to sumRange.
//
// Related Topics 设计 数组 前缀和
// 👍 397 👎 0

package leetcode.editor.cn;
//Java：Range Sum Query - Immutable
public class P303RangeSumQueryImmutable{
    public static void main(String[] args) {
        //Solution solution = new P303RangeSumQueryImmutable().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

    public NumArray(int[] nums) {

    }

    public int sumRange(int left, int right) {
        return 0;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}



