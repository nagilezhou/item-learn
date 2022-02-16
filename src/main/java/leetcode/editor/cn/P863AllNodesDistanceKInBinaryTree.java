//Given the root of a binary tree, the value of a target node target, and an int
//eger k, return an array of the values of all nodes that have a distance k from t
//he target node.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//Output: [7,4,1]
//Explanation: The nodes that are a distance 2 from the target node (with value
//5) have values 7, 4, and 1.
//
//
// Example 2:
//
//
//Input: root = [1], target = 1, k = 3
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 500].
// 0 <= Node.val <= 500
// All the values Node.val are unique.
// target is the value of one of the nodes in the tree.
// 0 <= k <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 488 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Java：All Nodes Distance K in Binary Tree
public class P863AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P863AllNodesDistanceKInBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private Map<Integer, TreeNode> map = new HashMap<>();
        private List<Integer> res = new ArrayList<>();
        private boolean[] visited = new boolean[500];

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            // 1. 先做节点和父节点的映射
            findParent(root);
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(target);
            int depth = 0;
            // 2. 开始沿着三个方向搜索节点（左子树方向，右子树方向，父节点方向）
            while (!queue.isEmpty()) {
                for (int qSize = queue.size(); qSize > 0; qSize--) {
                    TreeNode node = queue.poll();
                    visited[node.val] = true;
                    if (depth == k) // 如果当前遍历的层数正好等于K，那么将结果加入到res中
                    { res.add(node.val); }
                    if (node.left != null && !visited[node.left.val]) { queue.offer(node.left); }
                    if (node.right != null && !visited[node.right.val]) { queue.offer(node.right); }
                    // 这一块就是多出来的，沿着父节点方向访问节点的
                    if (map.get(node.val) != null && !visited[map.get(node.val).val]) {
                        queue.offer(map.get(node.val));
                    }
                }
                depth++;
            }
            return res;
        }

        private void findParent(TreeNode root) {
            if (root.left != null) {
                map.put(root.left.val, root);
                findParent(root.left);
            }
            if (root.right != null) {
                map.put(root.right.val, root);
                findParent(root.right);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

}



