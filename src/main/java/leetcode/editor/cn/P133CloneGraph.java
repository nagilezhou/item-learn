//Given a reference of a node in a connected undirected graph.
//
// Return a deep copy (clone) of the graph.
//
// Each node in the graph contains a value (int) and a list (List[Node]) of its
//neighbors.
//
//
//class Node {
//    public int val;
//    public List<Node> neighbors;
//}
//
//
//
//
// Test case format:
//
// For simplicity, each node's value is the same as the node's index (1-indexed)
//. For example, the first node with val == 1, the second node with val == 2, and
//so on. The graph is represented in the test case using an adjacency list.
//
// An adjacency list is a collection of unordered lists used to represent a fini
//te graph. Each list describes the set of neighbors of a node in the graph.
//
// The given node will always be the first node with val = 1. You must return th
//e copy of the given node as a reference to the cloned graph.
//
//
// Example 1:
//
//
//Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
//Output: [[2,4],[1,3],[2,4],[1,3]]
//Explanation: There are 4 nodes in the graph.
//1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//
//
// Example 2:
//
//
//Input: adjList = [[]]
//Output: [[]]
//Explanation: Note that the input contains one empty list. The graph consists o
//f only one node with val = 1 and it does not have any neighbors.
//
//
// Example 3:
//
//
//Input: adjList = []
//Output: []
//Explanation: This an empty graph, it does not have any nodes.
//
//
// Example 4:
//
//
//Input: adjList = [[2],[1]]
//Output: [[2],[1]]
//
//
//
// Constraints:
//
//
// The number of nodes in the graph is in the range [0, 100].
// 1 <= Node.val <= 100
// Node.val is unique for each node.
// There are no repeated edges and no self-loops in the graph.
// The Graph is connected and all nodes can be visited starting from the given n
//ode.
//
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表
// 👍 380 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：Clone Graph
public class P133CloneGraph {
    public static void main(String[] args) {
        Solution solution = new P133CloneGraph().new Solution();
        Node node_1 = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(4);
        node_1.neighbors = Arrays.asList(node_2, node_4);
        node_2.neighbors = Arrays.asList(node_1, node_3);
        node_3.neighbors = Arrays.asList(node_2, node_4);
        node_4.neighbors = Arrays.asList(node_1, node_3);
        Node res = solution.cloneGraph(node_1);
        System.out.println(res.val);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        private Map<Integer, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            if (map.containsKey(node.val)) {
                return map.get(node.val);
            }
            Node res = new Node(node.val);
            map.put(node.val, res);
            res.neighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                res.neighbors.add(cloneGraph(neighbor));
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}




