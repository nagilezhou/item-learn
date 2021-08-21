//Given the root of a binary tree, return the length of the diameter of the tree
//.
//
// The diameter of a binary tree is the length of the longest path between any t
//wo nodes in a tree. This path may or may not pass through the root.
//
// The length of a path between two nodes is represented by the number of edges
//between them.
//
//
// Example 1:
//
//
//Input: root = [1,2,3,4,5]
//Output: 3
//Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
//
//
// Example 2:
//
//
//Input: root = [1,2]
//Output: 1
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 104].
// -100 <= Node.val <= 100
//
// Related Topics 树
// 👍 704 👎 0

package leetcode.editor.cn;

//Java：Diameter of Binary Tree 二叉树 dfs
// 2021-08-21 review 1
public class P543DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
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

        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            getMaxDepth(root);
            return max;
        }

        private int getMaxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = getMaxDepth(root.left) + 1;
            int rightDepth = getMaxDepth(root.right) + 1;
            max = Math.max(max, leftDepth + rightDepth - 2);
            return Math.max(leftDepth, rightDepth);
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode() {
            }

            public TreeNode(int val) {
                this.val = val;
            }

            public TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



