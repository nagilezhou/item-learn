//Given the head of a sorted linked list, delete all nodes that have duplicate n
//umbers, leaving only distinct numbers from the original list. Return the linked
//list sorted as well.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
//
//
// Example 2:
//
//
//Input: head = [1,1,1,2,3]
//Output: [2,3]
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
// Related Topics 链表 双指针
// 👍 790 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.P83RemoveDuplicatesFromSortedList.ListNode;

//Java：Remove Duplicates from Sorted List II
public class P82RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
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
        if(head == null){
            return head;
        }
        ListNode next = head.next;
        while (next != null && head.val == next.val){
            next = next.next;
        }
        if(head.next != next){
            return deleteDuplicates(next);
        }else {
            head.next  = deleteDuplicates(next);
            return head;
        }

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



