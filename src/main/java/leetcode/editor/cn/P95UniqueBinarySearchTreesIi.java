//Given an integer n, return all the structurally unique BST's (binary search tr
//ees), which has exactly n nodes of unique values from 1 to n. Return the answer
//in any order.
//
//
// Example 1:
//
//
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
//]
//
//
// Example 2:
//
//
//Input: n = 1
//Output: [[1]]
//
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
// Related Topics 树 动态规划
// 👍 885 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Unique Binary Search Trees II 二叉树
// 2021-08-01 review 1
public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
        System.out.println(solution.generateTrees(3));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
            dp[0] = new ArrayList<>();
            if (n == 0) {
                return dp[0];
            }
            dp[0].add(null);

            for (int i = 1; i <= n; i++) {
                dp[i] = new ArrayList<>();
                for (int j = 1; j <= i; j++) {
                    // j - 1 的意思是划分到左子树的节点是2个,但是有根节点所以-1
                    for (TreeNode left : dp[j - 1]) {
                        for (TreeNode right : dp[i - j]) {
                            TreeNode root = new TreeNode(j);
                            root.left = left;
                            root.right = clone(right, j);
                            dp[i].add(root);
                        }
                    }
                }
            }
            return dp[n];
        }

        private TreeNode clone(TreeNode n, int offset) {
            if (n == null) {
                return null;
            }
            TreeNode node = new TreeNode(n.val + offset);
            node.left = clone(n.left, offset);
            node.right = clone(n.right, offset);
            return node;
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {}

            TreeNode(int val) { this.val = val; }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}



