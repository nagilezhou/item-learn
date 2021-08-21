//Given an integer array nums that may contain duplicates, return all possible s
//ubsets (the power set).
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order.
//
//
// Example 1:
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:
// Input: nums = [0]
//Output: [[],[0]]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯算法
// 👍 568 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：Subsets II dfs+backtrack+重复去重
// 2021-08-01 review 1
public class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        System.out.println(solution.subsetsWithDup(new int[] {1, 2, 3}).toString());
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null) {
                return null;
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> temp = new LinkedList();
            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums, res, temp, used, 0);
            return res;
        }

        public void backtrack(int[] nums, List<List<Integer>> res, Deque<Integer> temp, boolean[] used, int begin) {
            res.add(new ArrayList<>(temp));
            for (int i = begin; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > begin && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                //System.out.println("选择前  " + temp.toString());
                temp.addLast(nums[i]);
                backtrack(nums, res, temp, used, i + 1);
                //System.out.println("选择后  " + temp.toString());
                used[i] = false;
                temp.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



