//Given the root of a binary tree, return the maximum width of the given tree.
//
// The maximum width of a tree is the maximum width among all levels.
//
// The width of one level is defined as the length between the end-nodes (the le
//ftmost and rightmost non-null nodes), where the null nodes between the end-nodes
// are also counted into the length calculation.
//
// It is guaranteed that the answer will in the range of 32-bit signed integer.
//
//
//
// Example 1:
//
//
//Input: root = [1,3,2,5,3,null,9]
//Output: 4
//Explanation: The maximum width existing in the third level with the length 4 (
//5,3,null,9).
//
//
// Example 2:
//
//
//Input: root = [1,3,null,5,3]
//Output: 2
//Explanation: The maximum width existing in the third level with the length 2 (
//5,3).
//
//
// Example 3:
//
//
//Input: root = [1,3,2,5]
//Output: 2
//Explanation: The maximum width existing in the second level with the length 2
//(3,2).
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 3000].
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 301 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：Maximum Width of Binary Tree
public class P662MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P662MaximumWidthOfBinaryTree().new Solution();
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
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = 1;
            Deque<TreeNode> queue = new LinkedList<>();
            root.val = 0;
            queue.offer(root);
            while (!queue.isEmpty()) {
                //队列结尾减去开头的值加一即为当前层的宽度
                res = Math.max(res, queue.getLast().val - queue.getFirst().val + 1);

                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        node.left.val = node.val * 2;
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        node.right.val = node.val * 2 + 1;
                        queue.add(node.right);
                    }
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
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

