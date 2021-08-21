//Given an integer array nums of unique elements, return all possible subsets (t
//he power set).
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// Example 2:
//
//
//Input: nums = [0]
//Output: [[],[0]]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.
//
// Related Topics 位运算 数组 回溯算法
// 👍 1158 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：Subsets dfs+backtrack
// 2021-08-01 review 1
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        List<List<Integer>> res = solution.subsets(new int[] {1, 2, 3});
        System.out.println(res.toString());
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null) {
                return null;
            }
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> temp = new LinkedList<>();
            backTrack(nums, 0, temp, res);
            return res;

        }

        public void backTrack(int[] nums, int pos, LinkedList<Integer> temp, List<List<Integer>> res) {
            res.add(new ArrayList<>(temp));
            for (int i = pos; i < nums.length; i++) {
                temp.add(nums[i]);
                backTrack(nums, i + 1, temp, res);
                temp.remove(Integer.valueOf(nums[i]));
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



