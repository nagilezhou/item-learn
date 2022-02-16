//You are given a perfect binary tree where all leaves are on the same level, an
//d every parent has two children. The binary tree has the following definition:
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
//
// Populate each next pointer to point to its next right node. If there is no ne
//xt right node, the next pointer should be set to NULL.
//
// Initially, all next pointers are set to NULL.
//
//
// Example 1:
//
//
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function sho
//uld populate each next pointer to point to its next right node, just like in Fig
//ure B. The serialized output is in level order as connected by the next pointers
//, with '#' signifying the end of each level.
//
//
// Example 2:
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
// The number of nodes in the tree is in the range [0, 212 - 1].
// -1000 <= Node.val <= 1000
//
//
//
// Follow-up:
//
//
// You may only use constant extra space.
// The recursive approach is fine. You may assume implicit stack space does not
//count as extra space for this problem.
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树
// 👍 672 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

import org.w3c.dom.Node;

//Java：Populating Next Right Pointers in Each Node
public class P116PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new P116PopulatingNextRightPointersInEachNode().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect1(Node root) {
            if (root == null) {
                return null;
            }
            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    Node node = queue.pop();
                    if (i != n - 1) {
                        node.next = queue.peek();
                    } else {
                        node.next = null;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }

        public Node connect2(Node root) {
            if (root == null) {
                return null;
            }
            Node pre = root;
            //循环条件是当前节点的left不为空，当只有根节点
            //或所有叶子节点都出串联完后循环就退出了
            while (pre.left != null) {
                Node tmp = pre;
                while (tmp != null) {
                    //将tmp的左右节点都串联起来
                    //注:外层循环已经判断了当前节点的left不为空
                    tmp.left.next = tmp.right;
                    //下一个不为空说明上一层已经帮我们完成串联了
                    if (tmp.next != null) {
                        tmp.right.next = tmp.next.left;
                    }
                    //继续右边遍历
                    tmp = tmp.next;
                }
                //从下一层的最左边开始遍历
                pre = pre.left;
            }
            return root;
        }

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Node left = root.left;
            Node right = root.right;
            //配合动画演示理解这段，以root为起点，将整个纵深这段串联起来
            while(left != null) {
                left.next = right;
                left = left.right;
                right = right.left;
            }
            //递归的调用左右节点，完成同样的纵深串联
            connect(root.left);
            connect(root.right);
            return root;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}



