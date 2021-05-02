//Given an integer n, return the number of structurally unique BST's (binary sea
//rch trees) which has exactly n nodes of unique values from 1 to n.
//
//
// Example 1:
//
//
//Input: n = 3
//Output: 5
//
//
// Example 2:
//
//
//Input: n = 1
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= n <= 19
//
// Related Topics 树 动态规划
// 👍 1139 👎 0

package leetcode.editor.cn;

//Java：Unique Binary Search Trees
public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees2(3));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int dp[] = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    // j - 1 的意思是划分到左子树的节点是2个,但是有根节点所以-1
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }

        public int numTrees2(int n) {
            int dp[] = new int[n + 1];
            return help(n, dp);
        }

        public int help(int n, int dp[]) {
            if (n == 0 || n == 1) {
                return 1;
            }
            if (dp[n] > 0) {
                return dp[n];
            }
            // n-1 之前的累积就是n的值
            int count = 0;
            for (int i = 0; i <= n - 1; i++) {
                count += numTrees2(i) * numTrees2(n - i - 1);
            }
            dp[n] = count;
            return dp[n];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



