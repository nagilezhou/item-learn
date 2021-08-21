//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sum
//to target.
//
// Each number in candidates may only be used once in the combination.
//
// Note: The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
//
// Example 2:
//
//
//Input: candidates = [2,5,2,1,2], target = 5
//Output:
//[
//[1,2,2],
//[5]
//]
//
//
//
// Constraints:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
// Related Topics 数组 回溯算法
// 👍 569 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：Combination Sum II dfs+backtrack
// 2021-08-01 review 1
public class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8).toString());
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates == null) {
                return null;
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> temp = new LinkedList<>();
            Arrays.sort(candidates);
            backtrack(candidates, res, temp, 0, target);
            return res;
        }

        // DFS
        public void backtrack(int[] candidates, List<List<Integer>> res, Deque<Integer> temp, int begin,
            int target) {
            // 结束条件
            if (target <= 0) {
                if (target == 0) {
                    res.add(new ArrayList<>(temp));
                }
                return;
            }
            // DFS
            for (int i = begin; i < candidates.length; i++) {

                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.addLast(candidates[i]);
                backtrack(candidates, res, temp, i + 1, target - candidates[i]);
                temp.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



