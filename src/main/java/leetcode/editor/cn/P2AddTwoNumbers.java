//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself.
//
//
// Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//
//
// Example 2:
//
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//
//
// Example 3:
//
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//
// Constraints:
//
//
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading
// zeros.
//
// Related Topics 递归 链表 数学
// 👍 6053 👎 0

package leetcode.editor.cn;

//Java：Add Two Numbers
// 2021-07-28 review 1
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();

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

    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = new ListNode();
            ListNode node = root;
            int carry = 0;
            while(l1 != null || l2 != null){
                int val = 0;
                val += l1 == null ? 0 : l1.val;
                val += l2 == null ? 0 : l2.val;
                val += carry;
                carry = val / 10;
                val %= 10;
                ListNode next = new ListNode(val);
                node.next = next;
                node = next;

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if (carry > 0) {
                node.next = new ListNode(carry);
            }
            return root.next;
        }

    }


    //leetcode submit region end(Prohibit modification and deletion)

}



