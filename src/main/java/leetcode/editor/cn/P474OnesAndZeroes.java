//You are given an array of binary strings strs and two integers m and n.
//
// Return the size of the largest subset of strs such that there are at most m 0
//'s and n 1's in the subset.
//
// A set x is a subset of a set y if all elements of x are also elements of y.
//
//
// Example 1:
//
//
//Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
//Output: 4
//Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001",
// "1", "0"}, so the answer is 4.
//Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
//{"111001"} is an invalid subset because it contains 4 1's, greater than the ma
//ximum of 3.
//
//
// Example 2:
//
//
//Input: strs = ["10","0","1"], m = 1, n = 1
//Output: 2
//Explanation: The largest subset is {"0", "1"}, so the answer is 2.
//
//
//
// Constraints:
//
//
// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] consists only of digits '0' and '1'.
// 1 <= m, n <= 100
//
// Related Topics 数组 字符串 动态规划
// 👍 523 👎 0

package leetcode.editor.cn;

//Java：Ones and Zeroes dp 01背包
// 2021-08-21 review 1
public class P474OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new P474OnesAndZeroes().new Solution();
        System.out.println(solution.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            // 预处理每一个字符包含 0 和 1 的数量
            int[][] cnt = new int[len][2];
            for (int i = 0; i < len; i++) {
                String str = strs[i];
                int zero = 0, one = 0;
                for (char c : str.toCharArray()) {
                    if (c == '0') {
                        zero++;
                    } else {
                        one++;
                    }
                }
                cnt[i] = new int[] {zero, one};
            }

            int[][][] dp = new int[len][m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[0][i][j] = (i >= cnt[0][0] && j >= cnt[0][1]) ? 1 : 0;
                }
            }

            for (int k = 1; k < len; k++) {
                int zero = cnt[k][0], one = cnt[k][1];
                for (int i = 0; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        // 不选择第 k 件物品
                        int a = dp[k - 1][i][j];
                        // 选择第 k 件物品（前提是有足够的 m 和 n 额度可使用）
                        int b = (i >= zero && j >= one) ? dp[k - 1][i - zero][j - one] + 1 : 0;
                        dp[k][i][j] = Math.max(a, b);
                    }
                }
            }
            return dp[len - 1][m][n];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



