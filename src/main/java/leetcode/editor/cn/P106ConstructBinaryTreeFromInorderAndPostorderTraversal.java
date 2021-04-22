//Given two integer arrays inorder and postorder where inorder is the inorder tr
//aversal of a binary tree and postorder is the postorder traversal of the same tr
//ee, construct and return the binary tree.
//
//
// Example 1:
//
//
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
//
//
// Example 2:
//
//
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
//
//
//
// Constraints:
//
//
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder and postorder consist of unique values.
// Each value of postorder also appears in inorder.
// inorder is guaranteed to be the inorder traversal of the tree.
// postorder is guaranteed to be the postorder traversal of the tree.
//
// Related Topics 树 深度优先搜索 数组
// 👍 488 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;


//Java：Construct Binary Tree from Inorder and Postorder Traversal
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    Map<Integer, Integer> inorderToIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null ||
            postorder.length <= 0 || postorder.length != inorder.length) {
            return null;
        }
        int length = postorder.length;
        for (int index = 0; index < length; index++) {
            inorderToIndexMap.put(inorder[index], index);
        }
        return buildTreeNode(postorder, 0, length - 1, 0, length - 1);
    }

    public TreeNode buildTreeNode(int[] postorder, int postorder_left, int postorder_right,
        int inorder_left, int inorder_right) {
        if (postorder_left > postorder_right) {
            return null;
        }
        int postorder_root = postorder_right;
        int inorder_root = inorderToIndexMap.get(postorder[postorder_root]);
        TreeNode root = new TreeNode(postorder[postorder_root]);
        int size_right_subtree = inorder_right - inorder_root;
        root.right = buildTreeNode(postorder, postorder_right - size_right_subtree, postorder_right - 1,
            inorder_root + 1, inorder_right);
        root.left = buildTreeNode(postorder, postorder_left, postorder_right - size_right_subtree - 1,
            inorder_left, inorder_root - 1);
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



