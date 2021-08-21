//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order.
//
//
// Example 1:
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3:
// Input: nums = [1]
//Output: [[1]]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.
//
// Related Topics 回溯算法
// 👍 1323 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：Permutations dfs+backtrack
// 2021-08-01 review 1
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        System.out.println(solution.permute(new int[] {1, 2, 3}).toString());
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return null;
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> temp = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(nums, res, temp, used);
            return res;
        }

        // DFS
        public void backtrack(int[] nums, List<List<Integer>> res, Deque<Integer> temp, boolean[] used) {
            // 结束条件
            if (temp.size() == nums.length) {
                res.add(new ArrayList<>(temp));
                return;
            }
            // DFS
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                temp.addLast(nums[i]);
                backtrack(nums, res, temp, used);
                temp.removeLast();
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



