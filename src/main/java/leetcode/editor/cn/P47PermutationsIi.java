//Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order.
//
//
// Example 1:
//
//
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// Example 2:
//
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 回溯算法
// 👍 687 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：Permutations II dfs+backtrack
// 2021-08-01 review 1
public class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[] {1,1,2}).toString());
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null) {
                return null;
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> temp = new LinkedList<>();
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            backtrack(nums, res, temp,used);
            return res;
        }

        // DFS
        public void backtrack(int[] nums, List<List<Integer>> res, Deque<Integer> temp, boolean[] used) {
            // 结束条件
            if (temp.size() == nums.length ) {
                res.add(new ArrayList<>(temp));
                return;
            }
            // DFS
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                temp.addLast(nums[i]);
                used[i] = true;
                backtrack(nums, res, temp, used);
                temp.removeLast();
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}





