//Given the root of a complete binary tree, return the number of the nodes in th
//e tree.
//
// According to Wikipedia, every level, except possibly the last, is completely
//filled in a complete binary tree, and all nodes in the last level are as far lef
//t as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
//
// Design an algorithm that runs in less than O(n) time complexity.
//
//
// Example 1:
//
//
//Input: root = [1,2,3,4,5,6]
//Output: 6
//
//
// Example 2:
//
//
//Input: root = []
//Output: 0
//
//
// Example 3:
//
//
//Input: root = [1]
//Output: 1
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 5 * 104].
// 0 <= Node.val <= 5 * 104
// The tree is guaranteed to be complete.
//
// Related Topics 树 深度优先搜索 二分查找 二叉树
// 👍 613 👎 0

package leetcode.editor.cn;

//Java：Count Complete Tree Nodes
public class P222CountCompleteTreeNodes{
    public static void main(String[] args) {
        Solution solution = new P222CountCompleteTreeNodes().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 针对完全二叉树的解法
     *
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {// 左子树是满二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (int)Math.pow(2, leftDepth) + countNodes(root.right);
        } else {// 右子树是满二叉树
            return (int)Math.pow(2, rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
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



