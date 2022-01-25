//Given the root of a binary tree, return the inorder traversal of its nodes' va
//lues.
//
//
// Example 1:
//
//
//Input: root = [1,null,2,3]
//Output: [1,3,2]
//
//
// Example 2:
//
//
//Input: root = []
//Output: []
//
//
// Example 3:
//
//
//Input: root = [1]
//Output: [1]
//
//
// Example 4:
//
//
//Input: root = [1,2]
//Output: [2,1]
//
//
// Example 5:
//
//
//Input: root = [1,null,2]
//Output: [1,2]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
//
//
//
//
// Follow up:
//
// Recursive solution is trivial, could you do it iteratively?
//
//
// Related Topics 栈 树 哈希表
// 👍 925 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：Binary Tree Inorder Traversal 二叉树 中序遍历
// 2021-08-01 review 1
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()){
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;
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



