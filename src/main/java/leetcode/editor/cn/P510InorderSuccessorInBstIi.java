//Given a node in a binary search tree, return the in-order successor of that no
//de in the BST. If that node has no in-order successor, return null.
//
// The successor of a node is the node with the smallest key greater than node.v
//al.
//
// You will have direct access to the node but not to the root of the tree. Each
// node will have a reference to its parent node. Below is the definition for Node
//:
//
//
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node parent;
//}
//
//
//
// Example 1:
//
//
//Input: tree = [2,1,3], node = 1
//Output: 2
//Explanation: 1's in-order successor node is 2. Note that both the node and the
// return value is of Node type.
//
//
// Example 2:
//
//
//Input: tree = [5,3,6,2,4,null,null,1], node = 6
//Output: null
//Explanation: There is no in-order successor of the current node, so the answer
// is null.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 104].
// -105 <= Node.val <= 105
// All Nodes will have unique values.
//
//
//
// Follow up: Could you solve it without looking up any of the node's values?
// Related Topics 树 二叉搜索树 二叉树
// 👍 61 👎 0

package leetcode.editor.cn;
//Java：Inorder Successor in BST II
public class P510InorderSuccessorInBstIi{
    public static void main(String[] args) {
        Solution solution = new P510InorderSuccessorInBstIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    private Node preNode = null;
    public Node inorderSuccessor(Node node) {
        if(node == null){
            return null;
        }
        if(preNode != null && node.left == preNode){
            return node;
        }
        if((preNode == null || node.right != preNode) && node.right != null){
            return findNext(node.right);
        }
        preNode = node;
        return inorderSuccessor(node.parent);

    }

    private Node findNext(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}



