//You are given a doubly linked list, which contains nodes that have a next poin
//ter, a previous pointer, and an additional child pointer. This child pointer may
// or may not point to a separate doubly linked list, also containing these specia
//l nodes. These child lists may have one or more children of their own, and so on
//, to produce a multilevel data structure as shown in the example below.
//
// Given the head of the first level of the list, flatten the list so that all t
//he nodes appear in a single-level, doubly linked list. Let curr be a node with a
// child list. The nodes in the child list should appear after curr and before cur
//r.next in the flattened list.
//
// Return the head of the flattened list. The nodes in the list must have all of
// their child pointers set to null.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//Output: [1,2,3,7,8,11,12,9,10,4,5,6]
//Explanation: The multilevel linked list in the input is shown.
//After flattening the multilevel linked list it becomes:
//
//
//
// Example 2:
//
//
//Input: head = [1,2,null,3]
//Output: [1,3,2]
//Explanation: The multilevel linked list in the input is shown.
//After flattening the multilevel linked list it becomes:
//
//
//
// Example 3:
//
//
//Input: head = []
//Output: []
//Explanation: There could be empty list in the input.
//
//
//
// Constraints:
//
//
// The number of Nodes will not exceed 1000.
// 1 <= Node.val <= 105
//
//
//
// How the multilevel linked list is represented in test cases:
//
// We use the multilevel linked list from Example 1 above:
//
//
// 1---2---3---4---5---6--NULL
//         |
//         7---8---9---10--NULL
//             |
//             11--12--NULL
//
// The serialization of each level is as follows:
//
//
//[1,2,3,4,5,6,null]
//[7,8,9,10,null]
//[11,12,null]
//
//
// To serialize all levels together, we will add nulls in each level to signify
//no node connects to the upper node of the previous level. The serialization beco
//mes:
//
//
//[1,    2,    3, 4, 5, 6, null]
//             |
//[null, null, 7,    8, 9, 10, null]
//                   |
//[            null, 11, 12, null]
//
//
// Merging the serialization of each level and removing trailing nulls we obtain
//:
//
//
//[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//
// Related Topics 深度优先搜索 链表 双向链表
// 👍 333 👎 0

package leetcode.editor.cn;
//Java：Flatten a Multilevel Doubly Linked List
public class P430FlattenAMultilevelDoublyLinkedList{
    public static void main(String[] args) {
        Solution solution = new P430FlattenAMultilevelDoublyLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node child = flatten(head.child);
        Node next = flatten(head.next);
        if(child != null){
            head.next = child;
            child.prev = head;
            while(child.next != null){
                child = child.next;
            }
            child.next = next;
            if(next != null){
                next.prev = child;
            }
        }
        head.child = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}



