//Given an integer n, return the least number of perfect square numbers that sum
// to n.
//
// A perfect square is an integer that is the square of an integer; in other wor
//ds, it is the product of some integer with itself. For example, 1, 4, 9, and 16
//are perfect squares while 3 and 11 are not.
//
//
// Example 1:
//
//
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
//
//
// Example 2:
//
//
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
//
//
//
// Constraints:
//
//
// 1 <= n <= 104
//
// Related Topics 广度优先搜索 数学 动态规划
// 👍 857 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Java：Perfect Squares
public class P279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
        System.out.println(solution.numSquares(13));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numSquares2(int n) {
            List<Integer> list = new ArrayList<>();
            int idx = 1;
            while (idx * idx <= n) {
                list.add(idx * idx);
                idx++;
            }
            // f[i][j] 代表考虑前 i 个物品，凑出 j 所使用到的最小元素个数
            int len = list.size();
            int[] num = list.stream().mapToInt(Integer::intValue).toArray();
            int[][] dp = new int[len][n + 1];

            // 初始化
            for (int j = 0; j <= n; j++) {
                int t = num[0];
                int k = j / t;
                if (k * t == j) { // 只有容量为第一个数的整数倍的才能凑出
                    dp[0][j] = k;
                } else { // 其余则为无效值
                    dp[0][j] = -1;
                }
            }

            for (int i = 1; i < len; i++) {
                int t = num[i];
                for (int j = 0; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j];

                    for (int k = 1; k * t <= j; k++) {
                        if (dp[i - 1][j - k * t] != -1) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * t] + k);
                        }
                    }
                }
            }

            return dp[len - 1][n];
        }

        public int numSquares(int n) {
            // 预处理出所有可能用到的「完全平方数」
            List<Integer> list = new ArrayList<>();
            int idx = 1;
            while (idx * idx <= n) {
                list.add(idx * idx);
                idx++;
            }

            // f[j] 代表考虑到当前物品为止，凑出 j 所使用到的最小元素个数
            int len = list.size();
            int[] dp = new int[n + 1];

            // 处理第一个数的情况
            for (int j = 0; j <= n; j++) {
                int t = list.get(0);
                int k = j / t;
                if (k * t == j) { // 只有容量为第一个数的整数倍的才能凑出
                    dp[j] = k;
                } else { // 其余则为无效值
                    dp[j] = -1;
                }
            }

            // 处理剩余数的情况
            for (int i = 1; i < len; i++) {
                int t = list.get(i);
                for (int j = t; j <= n; j++) {
                    // 当不更新 f[j] 的时候，对应了二维表示中的 f[i - 1][j]

                    // 可以更新 f[j] 的前提是：剩余的 j - k * t 也能够被凑出
                    // 更新 f[j] 所依赖的 f[j - t] 对应了二维表示中的 f[i - 1][j - k * t]
                    if (dp[j - t] != -1) { dp[j] = Math.min(dp[j], dp[j - t] + 1); }
                }
            }

            return dp[n];
        }

        public int numSquares4(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;//最坏的情况都是由1的平方组成
                for (int j = 1; j * j <= i; j++) {
                    //动态规划公式
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }

        public int numSquares3(int n) {
            Queue<Integer> queue = new LinkedList<>();
            //记录访问过的节点值
            Set<Integer> visited = new HashSet<>();
            queue.offer(0);
            visited.add(0);
            //树的第几层
            int level = 0;
            while (!queue.isEmpty()) {
                //每一层的节点数量
                int size = queue.size();
                level++;
                //遍历当前层的所有节点
                for (int i = 0; i < size; i++) {
                    //节点的值
                    int digit = queue.poll();
                    //访问当前节点的子节点，类比于二叉树的左右子节点
                    for (int j = 1; j <= n; j++) {
                        //子节点的值
                        int nodeValue = digit + j * j;
                        //nodeValue始终是完全平方数的和，当他等于n的
                        //时候直接返回
                        if (nodeValue == n) { return level; }
                        //如果大于n，终止内层循环
                        if (nodeValue > n) { break; }
                        if (!visited.contains(nodeValue)) {
                            queue.offer(nodeValue);
                            visited.add(nodeValue);
                        }
                    }
                }
            }
            return level;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



