//You are given the head of a singly linked-list. The list can be represented as
//:
//
//
//L0 → L1 → … → Ln - 1 → Ln
//
//
// Reorder the list to be on the following form:
//
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//
//
// You may not modify the values in the list's nodes. Only nodes themselves may
//be changed.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
//
//
// Example 2:
//
//
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000
//
// Related Topics 栈 递归 链表 双指针
// 👍 797 👎 0

package leetcode.editor.cn;
//Java：Reorder List
public class P143ReorderList{
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = fast == null ? prev : slow;
        ListNode node = reverse(tail.next);
        tail.next = null;
        merge(head, node);
    }

    private ListNode merge(ListNode p1, ListNode p2){
        boolean flag = true;
        ListNode dummyHead = new ListNode();
        ListNode node = dummyHead;
        while(p1 != null && p2 != null){
            if(flag){
                node.next = p1;
                p1 = p1.next;
            }else{
                node.next = p2;
                p2 = p2.next;
            }
            flag = !flag;
            node = node.next;
        }
        if(p1 == null){
            node.next = p2;
        }
        if(p2 == null){
            node.next = p1;
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



