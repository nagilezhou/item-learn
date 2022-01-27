//Given a circular integer array nums (i.e., the next element of nums[nums.lengt
//h - 1] is nums[0]), return the next greater number for every element in nums.
//
// The next greater number of a number x is the first greater number to its trav
//ersing-order next in the array, which means you could search circularly to find
//its next greater number. If it doesn't exist, return -1 for this number.
//
//
// Example 1:
//
//
//Input: nums = [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2;
//The number 2 can't find next greater number.
//The second 1's next greater number needs to search circularly, which is also 2
//.
//
//
// Example 2:
//
//
//Input: nums = [1,2,3,4,3]
//Output: [2,3,4,-1,4]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -109 <= nums[i] <= 109
//
// Related Topics 栈 数组 单调栈
// 👍 549 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：Next Greater Element II
public class P503NextGreaterElementIi{
    public static void main(String[] args) {
        Solution solution = new P503NextGreaterElementIi().new Solution();
        System.out.println(solution.nextGreaterElements(new int[]{1,2,1}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = n * 2 - 1; i >= 0; i--) {
            int index = i % n;
            int num = nums[index];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            res[index] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



