//Given the head of a linked list, rotate the list to the right by k places.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//
//
// Example 2:
//
//
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
//
// Related Topics 链表 双指针
// 👍 722 👎 0

package leetcode.editor.cn;

//Java：Rotate List
public class P61RotateList {
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int n = 0;
            ListNode node = head;
            ListNode tail = node;
            while (node != null) {
                n++;
                tail = node;
                node = node.next;
            }
            k %= n;
            if (k == 0) {
                return head;
            }
            tail.next = head;
            node = head;
            for (int i = 0; i < n - k - 1; i++) {
                node = node.next;
            }
            ListNode newRoot = node.next;
            node.next = null;
            return newRoot;
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





