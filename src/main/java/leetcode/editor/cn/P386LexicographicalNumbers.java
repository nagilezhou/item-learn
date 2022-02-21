//Given an integer n, return all the numbers in the range [1, n] sorted in lexic
//ographical order.
//
// You must write an algorithm that runs in O(n) time and uses O(1) extra space.
//
//
//
// Example 1:
// Input: n = 13
//Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
// Example 2:
// Input: n = 2
//Output: [1,2]
//
//
// Constraints:
//
//
// 1 <= n <= 5 * 104
//
// Related Topics 深度优先搜索 字典树
// 👍 234 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Lexicographical Numbers
public class P386LexicographicalNumbers {
    public static void main(String[] args) {
        Solution solution = new P386LexicographicalNumbers().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            // 没有0
            for (int i = 1; i < 10; i++) {
                dfs(n, res, i);
            }
            return res;
        }

        private void dfs(int n, List<Integer> res, int val) {
            if (val > n) { return; }
            res.add(val);
            for (int j = 0; j <= 9; j++) {
                dfs(n, res, val * 10 + j);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



