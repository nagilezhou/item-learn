//Given an array of distinct integers candidates and a target integer target, re
//turn a list of all unique combinations of candidates where the chosen numbers su
//m to target. You may return the combinations in any order.
//
// The same number may be chosen from candidates an unlimited number of times. T
//wo combinations are unique if the frequency of at least one of the chosen number
//s is different.
//
// It is guaranteed that the number of unique combinations that sum up to target
// is less than 150 combinations for the given input.
//
//
// Example 1:
//
//
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple ti
//mes.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//
//
// Example 2:
//
//
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
//
//
// Example 3:
//
//
//Input: candidates = [2], target = 1
//Output: []
//
//
// Example 4:
//
//
//Input: candidates = [1], target = 1
//Output: [[1]]
//
//
// Example 5:
//
//
//Input: candidates = [1], target = 2
//Output: [[1,1]]
//
//
//
// Constraints:
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// All elements of candidates are distinct.
// 1 <= target <= 500
//
// Related Topics 数组 回溯算法
// 👍 1324 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：Combination Sum dfs+backtrack
// 2021-08-01 review 1
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7},7).toString());
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null) {
                return null;
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> temp = new LinkedList<>();
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
                temp.addLast(candidates[i]);
                backtrack(candidates, res, temp, i, target - candidates[i]);
                temp.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



