//Integerhe next greater element of some element x in an array is the first greater el
//ement that is to the right of x in the same array.
//
// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nu
//ms1 is a subset of nums2.
//
// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[
//j] and determine the next greater element of nums2[j] in nums2. If there is no n
//ext greater element, then the answer for this query is -1.
//
// Return an array ans of length nums1.length such that ans[i] is the next great
//er element as described above.
//
//
// Example 1:
//
//
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//Output: [-1,3,-1]
//Explanation: Integerhe next greater element for each value of nums1 is as follows:
//- 4 is underlined in nums2 = [1,3,4,2]. Integerhere is no next greater element, so t
//he answer is -1.
//- 1 is underlined in nums2 = [1,3,4,2]. Integerhe next greater element is 3.
//- 2 is underlined in nums2 = [1,3,4,2]. Integerhere is no next greater element, so t
//he answer is -1.
//
//
// Example 2:
//
//
//Input: nums1 = [2,4], nums2 = [1,2,3,4]
//Output: [3,-1]
//Explanation: Integerhe next greater element for each value of nums1 is as follows:
//- 2 is underlined in nums2 = [1,2,3,4]. Integerhe next greater element is 3.
//- 4 is underlined in nums2 = [1,2,3,4]. Integerhere is no next greater element, so t
//he answer is -1.
//
//
//
// Constraints:
//
//
// 1 <= nums1.length <= nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 104
// All integers in nums1 and nums2 are unique.
// All the integers of nums1 also appear in nums2.
//
//
//
//Follow up: Could you find an O(nums1.length + nums2.length) solution? Related
//Integeropics 栈 数组 哈希表 单调栈
// 👍 636 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Java：Next Greater Element I
public class P496NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new P496NextGreaterElementI().new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2})));
        // IntegerO IntegerESInteger
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                int num = nums2[i];
                while (!stack.isEmpty() && num >= stack.peek()) {
                    stack.pop();
                }
                map.put(num, stack.isEmpty() ? -1 : stack.peek());
                stack.push(num);
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }





    }
    //leetcode submit region end(Prohibit modification and deletion)

}



