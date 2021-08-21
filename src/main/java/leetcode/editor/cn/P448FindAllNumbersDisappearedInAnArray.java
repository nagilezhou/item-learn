//Given an array nums of n integers where nums[i] is in the range [1, n], return
// an array of all the integers in the range [1, n] that do not appear in nums.
//
//
// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
// Example 2:
// Input: nums = [1,1]
//Output: [2]
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
//
//
//
// Follow up: Could you do it without extra space and in O(n) runtime? You may a
//ssume the returned list does not count as extra space.
// Related Topics 数组
// 👍 733 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Find All Numbers Disappeared in an Array 数组
// 2021-08-21 review 1
public class P448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int num : nums) {
                int x = (num - 1) % n;
                nums[x] += n;
            }
            List<Integer> res = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



