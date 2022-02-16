//Given two nodes of a binary tree p and q, return their lowest common ancestor
//(LCA).
//
// Each node will have a reference to its parent node. The definition for Node i
//s below:
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
// According to the definition of LCA on Wikipedia: "The lowest common ancestor
//of two nodes p and q in a tree T is the lowest node that has both p and q as des
//cendants (where we allow a node to be a descendant of itself)."
//
//
// Example 1:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
//
//
// Example 2:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of
// itself according to the LCA definition.
//
//
// Example 3:
//
//
//Input: root = [1,2], p = 1, q = 2
//Output: 1
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q exist in the tree.
//
// Related Topics 树 哈希表 二叉树
// 👍 20 👎 0

package leetcode.editor.cn;
//Java：Lowest Common Ancestor of a Binary Tree III
public class P1650LowestCommonAncestorOfABinaryTreeIii{
    public static void main(String[] args) {
        Solution solution = new P1650LowestCommonAncestorOfABinaryTreeIii().new Solution();
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
    public Node lowestCommonAncestor(Node p, Node q) {
        if(p == null || q == null){
            return null;
        }
        Node p1 = p;
        Node q1 = q;
        while(p1 != q1){
            p1 = p1 != null ? p1.parent : q;
            q1 = q1 != null ? q1.parent : p;
        }
        return p1;
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



