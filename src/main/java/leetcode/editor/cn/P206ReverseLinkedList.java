//Given the head of a singly linked list, reverse the list, and return the rever
//sed list.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
//
//
// Example 2:
//
//
//Input: head = [1,2]
//Output: [2,1]
//
//
// Example 3:
//
//
//Input: head = []
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000
//
//
//
// Follow up: A linked list can be reversed either iteratively or recursively. C
//ould you implement both?
// Related Topics 链表
// 👍 1745 👎 0

package leetcode.editor.cn;


//Java：Reverse Linked List 链表 反转 头插法
// 2021-08-13 review 1
public class P206ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        System.out.println(solution.reverseList(null));
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
    public ListNode reverseList(ListNode head) {
        ListNode resHead = null;
        ListNode next;
        while (head != null){
            next = head.next;
            head.next = resHead;
            resHead = head;
            head = next;
        }
        return resHead;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

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
//leetcode submit region end(Prohibit modification and deletion)

}



