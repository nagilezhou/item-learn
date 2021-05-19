//Given the head of a singly linked list, return true if it is a palindrome.
//
//
// Example 1:
//
//
//Input: head = [1,2,2,1]
//Output: true
//
//
// Example 2:
//
//
//Input: head = [1,2]
//Output: false
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9
//
//
//
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics 链表 双指针
//
// 👍 983 👎 0

package leetcode.editor.cn;

//Java：Palindrome Linked List
public class P234PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
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
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode first = getHalfHead(head);
        ListNode second = reverseList(first.next);
        ListNode p1 = head;
        ListNode p2 = second;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        first.next = reverseList(second);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode getHalfHead(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
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



