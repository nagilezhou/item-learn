//Given the head of a sorted linked list, delete all duplicates such that each e
//lement appears only once. Return the linked list sorted as well.
//
//
// Example 1:
//
//
//Input: head = [1,1,2]
//Output: [1,2]
//
//
// Example 2:
//
//
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.
//
// Related Topics 链表
// 👍 718 👎 0

package leetcode.editor.cn;
//Java：Remove Duplicates from Sorted List
public class P83RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        while (next != null && head.val == next.val){
            next = next.next;
        }
        head.next = deleteDuplicates(next);
        return head;
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



