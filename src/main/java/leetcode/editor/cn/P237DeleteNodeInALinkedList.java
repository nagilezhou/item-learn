//Write a function to delete a node in a singly-linked list. You will not be giv
//en access to the head of the list, instead you will be given access to the node
//to be deleted directly.
//
// It is guaranteed that the node to be deleted is not a tail node in the list.
//
//
//
// Example 1:
//
//
//Input: head = [4,5,1,9], node = 5
//Output: [4,1,9]
//Explanation: You are given the second node with value 5, the linked list shoul
//d become 4 -> 1 -> 9 after calling your function.
//
//
// Example 2:
//
//
//Input: head = [4,5,1,9], node = 1
//Output: [4,5,9]
//Explanation: You are given the third node with value 1, the linked list should
// become 4 -> 5 -> 9 after calling your function.
//
//
//
// Constraints:
//
//
// The number of the nodes in the given list is in the range [2, 1000].
// -1000 <= Node.val <= 1000
// The value of each node in the list is unique.
// The node to be deleted is in the list and is not a tail node
//
// Related Topics 链表
// 👍 1086 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.P19RemoveNthNodeFromEndOfList.ListNode;

//Java：Delete Node in a Linked List
public class P237DeleteNodeInALinkedList{
    public static void main(String[] args) {
        Solution solution = new P237DeleteNodeInALinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null){
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



