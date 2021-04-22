//Given two integer arrays preorder and inorder where preorder is the preorder t
//raversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree.
//
//
// Example 1:
//
//
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
//
//
// Example 2:
//
//
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
//
//
//
// Constraints:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.
//
// Related Topics 树 深度优先搜索 数组
// 👍 997 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
//Java：Construct Binary Tree from Preorder and Inorder Traversal
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

        Map<Integer, Integer> inorderToIndexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null ||
                preorder.length <= 0 || preorder.length != inorder.length) {
                return null;
            }
            int length = preorder.length;
            for (int index = 0; index < length; index++) {
                inorderToIndexMap.put(inorder[index], index);
            }
            return buildTreeNode(preorder, 0, length - 1, 0, length - 1);

        }

        public TreeNode buildTreeNode(int[] preorder, int preorder_left, int preorder_right,
            int inorder_left, int inorder_right) {
            if(preorder_left > preorder_right){
                return null;
            }
            int preorder_root = preorder_left;
            int inorder_root = inorderToIndexMap.get(preorder[preorder_root]);
            TreeNode root = new TreeNode(preorder[preorder_root]);
            int size_left_subtree = inorder_root - inorder_left;
            root.left = buildTreeNode(preorder, preorder_left + 1, preorder_left + size_left_subtree,
                inorder_left, inorder_root - 1);
            root.right = buildTreeNode(preorder, preorder_left + size_left_subtree + 1, preorder_right,
                inorder_root + 1, inorder_right);
            return root;
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



