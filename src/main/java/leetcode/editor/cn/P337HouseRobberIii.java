//The thief has found himself a new place for his thievery again. There is only
//one entrance to this area, called root.
//
// Besides the root, each house has one and only one parent house. After a tour,
// the smart thief realized that all houses in this place form a binary tree. It w
//ill automatically contact the police if two directly-linked houses were broken i
//nto on the same night.
//
// Given the root of the binary tree, return the maximum amount of money the thi
//ef can rob without alerting the police.
//
//
// Example 1:
//
//
//Input: root = [3,2,3,null,3,null,1]
//Output: 7
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//
//
// Example 2:
//
//
//Input: root = [3,4,5,1,3,null,1]
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 104].
// 0 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索 动态规划 二叉树
// 👍 909 👎 0

package leetcode.editor.cn;

//Java：House Robber III
public class P337HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new P337HouseRobberIii().new Solution();
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
        public int rob(TreeNode root) {
            int[] res = robAction(root);
            return Math.max(res[0], res[1]);
        }

        private int[] robAction(TreeNode root) {
            int[] res = new int[2];
            if (root == null) {
                return res;
            }
            int[] left = robAction(root.left);
            int[] right = robAction(root.right);

            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            res[1] = root.val + left[0] + right[0];
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
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



