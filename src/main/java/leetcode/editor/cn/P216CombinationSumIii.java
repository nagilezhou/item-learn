//Find all valid combinations of k numbers that sum up to n such that the follow
//ing conditions are true:
//
//
// Only numbers 1 through 9 are used.
// Each number is used at most once.
//
//
// Return a list of all possible valid combinations. The list must not contain t
//he same combination twice, and the combinations may be returned in any order.
//
//
// Example 1:
//
//
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations.
//
// Example 2:
//
//
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
//
//
// Example 3:
//
//
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
//
//
// Example 4:
//
//
//Input: k = 3, n = 2
//Output: []
//Explanation: There are no valid combinations.
//
//
// Example 5:
//
//
//Input: k = 9, n = 45
//Output: [[1,2,3,4,5,6,7,8,9]]
//Explanation:
//1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
//There are no other valid combinations.
//
//
//
// Constraints:
//
//
// 2 <= k <= 9
// 1 <= n <= 60
//
// Related Topics 数组 回溯
// 👍 321 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：Combination Sum III dfs backtrack
// 2021-08-14 review 1
public class P216CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new P216CombinationSumIii().new Solution();
        System.out.println(solution.combinationSum3(3,7));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> temp = new LinkedList<>();
        backtrack(k, res, temp, 1, n);
        return res;
    }

        // DFS
        public void backtrack(int k, List<List<Integer>> res, Deque<Integer> temp, int begin,
            int target) {
            // 结束条件
            if (target <= 0) {
                if (target == 0 && temp.size() == k) {
                    res.add(new ArrayList<>(temp));
                }
                return;
            }
            // DFS
            for (int i = begin; i <= 9; i++) {
                temp.addLast(i);
                backtrack(k, res, temp, i + 1, target - i);
                temp.removeLast();
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}



