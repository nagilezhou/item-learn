//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list.
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is.
//
// You may not alter the values in the list's nodes, only nodes themselves may b
//e changed.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
//
//
// Example 2:
//
//
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
//
//
// Example 3:
//
//
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
//
//
// Example 4:
//
//
//Input: head = [1], k = 1
//Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range sz.
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
//
//
//Follow-up: Can you solve the problem in O(1) extra memory space? Related Topic
//s 递归 链表
// 👍 1153 👎 0

package leetcode.editor.cn;

//Java：Reverse Nodes in k-Group
public class P25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        ListNode head5 = new ListNode(5);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        solution.reverseKGroup(head1,2);

        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k <= 0) {
                return null;
            }
            ListNode dummyHead = new ListNode();
            ListNode tail = dummyHead;
            while (head != null) {
                int tmp = 1;
                ListNode tmpNode = head;
                while (true) {
                    tmpNode = tmpNode.next;
                    tmp++;
                    if (tmpNode == null) {
                        tail.next = head;
                        head = null;
                        break;
                    }
                    if (tmp == k) {
                        ListNode tmpTail = tmpNode.next;
                        tmpNode.next = null;
                        tail.next = reverseList(head);
                        tail = head;
                        head = tmpTail;
                        break;
                    }
                }
            }
            return dummyHead.next;
        }

        public ListNode reverseList(ListNode head) {
            ListNode resHead = null;
            ListNode next;
            while (head != null) {
                next = head.next;
                head.next = resHead;
                resHead = head;
                head = next;
            }
            return resHead;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
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



