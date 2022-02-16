//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment.
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure.
//
// Clarification: The input/output format is the same as how LeetCode serializes
// a binary tree. You do not necessarily need to follow this format, so please be
//creative and come up with different approaches yourself.
//
//
// Example 1:
//
//
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
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
//Output: [1,2]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 104].
// -1000 <= Node.val <= 1000
//
// Related Topics 树 设计
// 👍 575 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：Serialize and Deserialize Binary Tree 二叉树
// 2021-08-17 review 1
public class P297SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        //Solution solution = new P297SerializeAndDeserializeBinaryTree().new Solution();
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Queue<TreeNode> temp = new LinkedList<>();
                for (TreeNode node : queue) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    if (node == null) {
                        sb.append("null");
                        continue;
                    }
                    sb.append(node.val);
                    temp.offer(node.left);
                    temp.offer(node.right);
                }
                queue = temp;
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            TreeNode root = arr[0].equals("null") ? null : new TreeNode(Integer.parseInt(arr[0]));
            if(root == null){
                return root;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 0;
            while (!queue.isEmpty()){
                Queue<TreeNode> temp = new LinkedList<>();
                for(TreeNode node : queue){
                    String left = arr[++index];
                    node.left =  left.equals("null") ? null : new TreeNode(Integer.parseInt(left));
                    if(node.left != null){
                        temp.offer(node.left);
                    }
                    String right = arr[++index];
                    node.right =  right.equals("null") ? null : new TreeNode(Integer.parseInt(right));
                    if(node.right != null){
                        temp.offer(node.right);
                    }
                }
                queue = temp;
            }
            return root;
        }

    }



    public class Codec2{
        //  1
        //2   3
        //  4    5

        // 1 2 # # 3 4 # # 5 # #
        public String serialize(TreeNode root) {
            if(root == null){
                return "#";
            }
            String left = serialize(root.left);
            String right = serialize(root.right);
            return root.val + "," + left + "," + right;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return buildTree(queue);
        }

        public TreeNode buildTree(Deque<String> nodeList) {
            String node = nodeList.poll();
            if(node.equals("#")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(node));
            root.left = buildTree(nodeList);
            root.right = buildTree(nodeList);
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)

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



