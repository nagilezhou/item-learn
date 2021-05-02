//Given the root of a binary tree, determine if it is a valid binary search tree
// (BST).
//
// A valid BST is defined as follows:
//
//
// The left subtree of a node contains only nodes with keys less than the node's
// key.
// The right subtree of a node contains only nodes with keys greater than the no
//de's key.
// Both the left and right subtrees must also be binary search trees.
//
//
//
// Example 1:
//
//
//Input: root = [2,1,3]
//Output: true
//
//
// Example 2:
//
//
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1
//
// Related Topics 树 深度优先搜索 递归
// 👍 1047 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：Validate Binary Search Tree
public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
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
        //public boolean isValidBST(TreeNode root) {
        //    Deque<TreeNode> stack = new LinkedList<>();
        //    long preVal = Long.MIN_VALUE;
        //    while (root != null || !stack.isEmpty()) {
        //        while (root != null) {
        //            stack.push(root);
        //            root = root.left;
        //        }
        //        root = stack.pop();
        //        if (root.val <= preVal) {
        //            return false;
        //        }
        //        preVal = root.val;
        //        root = root.right;
        //
        //    }
        //    return true;
        //}

        public boolean isValidBST(TreeNode root) {
            return helpValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean helpValidBST2(TreeNode root, long lower, long upper) {
            if (root == null) {
                return true;
            }
            if (root.val <= lower || root.val >= upper) {
                return false;
            }
            return helpValidBST2(root.left, lower, root.val) && helpValidBST2(root.right, root.val, upper);
        }

    }

    public static class TreeNode {
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
    //leetcode submit region end(Prohibit modification and deletion)

}



