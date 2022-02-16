//Given the root of a binary tree, return the zigzag level order traversal of it
//s nodes' values. (i.e., from left to right, then right to left for the next leve
//l and alternate between).
//
//
// Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
//
//
// Example 2:
//
//
//Input: root = [1]
//Output: [[1]]
//
//
// Example 3:
//
//
//Input: root = []
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
//
// Related Topics 树 广度优先搜索 二叉树
// 👍 459 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


//Java：Binary Tree Zigzag Level Order Traversal 二叉树+队列
// 2021-08-07 review 1
public class P103BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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



    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isLeft = true;
        List<List<Integer>> res = new ArrayList<>();
        while (!nodeQueue.isEmpty()){
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isLeft) {
                    levelList.addLast(curNode.val);
                } else {
                    levelList.addFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            isLeft = !isLeft;
            res.add(new LinkedList<>(levelList));
        }
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



