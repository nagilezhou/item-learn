//Given the root of a binary tree, return all root-to-leaf paths in any order.
//
// A leaf is a node with no children.
//
//
// Example 1:
//
//
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
//
//
// Example 2:
//
//
//Input: root = [1]
//Output: ["1"]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 100].
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索
// 👍 512 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：Binary Tree Paths
public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<String> res = new ArrayList<>();
            List<Integer> tempList = new LinkedList<>();
            tempList.add(root.val);
            backtrack(root, tempList, res);
            return res;
        }

        public void backtrack(TreeNode node, List<Integer> tempList, List<String> res) {
            if (node.left == null && node.right == null) {
                res.add(convert(tempList));
                return;
            }
            if (node.left != null) {
                tempList.add(node.left.val);
                backtrack(node.left, tempList, res);
                tempList.remove(tempList.size() - 1);
            }
            if (node.right != null) {
                tempList.add(node.right.val);
                backtrack(node.right, tempList, res);
                tempList.remove(tempList.size() - 1);
            }
        }

        public String convert(List<Integer> tempList) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < tempList.size(); i++) {
                if (i == 0) {
                    stringBuilder.append(tempList.get(i));
                    continue;
                }
                stringBuilder.append("->").append(tempList.get(i));
            }
            return stringBuilder.toString();
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



