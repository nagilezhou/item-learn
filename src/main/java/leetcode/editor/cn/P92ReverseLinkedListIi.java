//Given the head of a singly linked list and two integers left and right where l
//eft <= right, reverse the nodes of the list from position left to position right
//, and return the reversed list.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//
//
// Example 2:
//
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//Follow up: Could you do it in one pass? Related Topics 链表
// 👍 921 👎 0

package leetcode.editor.cn;

//Java：Reverse Linked List II 链表
// 2021-08-01 review 1
public class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next;
        for(int i = 0; i < right - left; i++){
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }


    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if(left > 1){
            head.next = reverseBetween2(head.next, left - 1, right - 1);
            return head;
        }
        return reverseFromHead(head, right);
    }

    ListNode successor = null;

    public ListNode reverseFromHead(ListNode head, int n) {
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseFromHead(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
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



