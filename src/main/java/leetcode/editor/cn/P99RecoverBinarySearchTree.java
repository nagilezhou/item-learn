//You are given the root of a binary search tree (BST), where exactly two nodes
//of the tree were swapped by mistake. Recover the tree without changing its struc
//ture.
//
// Follow up: A solution using O(n) space is pretty straight forward. Could you
//devise a constant space solution?
//
//
// Example 1:
//
//
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 mak
//es the BST valid.
//
//
// Example 2:
//
//
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 a
//nd 3 makes the BST valid.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 1000].
// -231 <= Node.val <= 231 - 1
//
// Related Topics 树 深度优先搜索
// 👍 468 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：Recover Binary Search Tree 二叉树 中序遍历
// 2021-08-01 review 1
public class P99RecoverBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P99RecoverBinarySearchTree().new Solution();
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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node1 = null;
        TreeNode node2 = null;
        TreeNode preNode = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(preNode != null && preNode.val > root.val){
                if(node1 == null){
                    node1 = preNode;
                    node2 = root;
                }else {
                    node2 = root;
                }
            }
            preNode = root;
            root = root.right;
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
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



