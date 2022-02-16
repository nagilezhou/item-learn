//Given the root of a binary tree, flatten the tree into a "linked list":
//
//
// The "linked list" should use the same TreeNode class where the right child po
//inter points to the next node in the list and the left child pointer is always n
//ull.
// The "linked list" should be in the same order as a pre-order traversal of the
// binary tree.
//
//
//
// Example 1:
//
//
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
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
//Input: root = [0]
//Output: [0]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
//
//
//
//Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related
//Topics 树 深度优先搜索
// 👍 790 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

//Java：Flatten Binary Tree to Linked List 二叉树
// 2021-08-01 review 1
public class P114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left == null) {
                    root = root.right;
                } else {
                    TreeNode pre = root.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    pre.right = root.right;
                    root.right = root.left;
                    root.left = null;
                    root = root.right;
                }
            }
        }

        public void flatten3(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            flatten3(root.right);
        }

        public void flatten2(TreeNode root) {
            List<TreeNode> list = preorder2(root);
            for (int i = 1; i < list.size(); i++) {
                TreeNode prev = list.get(i - 1);
                TreeNode curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }

        public void preorder(TreeNode root, List<TreeNode> list) {
            if (root == null) {
                return;
            }
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }

        public List<TreeNode> preorder2(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    list.add(root);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return list;
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




