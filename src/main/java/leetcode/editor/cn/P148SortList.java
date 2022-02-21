//Given the head of a linked list, return the list after sorting it in ascending
// order.
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)?
//
//
// Example 1:
//
//
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
//
//
// Example 2:
//
//
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
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
// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105
//
// Related Topics 排序 链表
// 👍 1114 👎 0

package leetcode.editor.cn;

//Java：Sort List
public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
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

        /**
         * 归并递归
         *
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            // 找中点
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 分开成两段链表
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            ListNode dummyHead = new ListNode();
            ListNode node = dummyHead;
            // 合并两段链表
            while (left != null && right != null) {
                if (left.val < right.val) {
                    node.next = left;
                    left = left.next;
                } else {
                    node.next = right;
                    right = right.next;

                }
                node = node.next;
            }
            // 将剩余的直接添加到尾部
            node.next = left != null ? left : right;
            return dummyHead.next;
        }

        /**
         * 归并迭代
         *
         * @param head
         * @return
         */
        public ListNode sortList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 求出链表长度
            int length = 0;
            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }

            ListNode dummyHead = new ListNode();
            dummyHead.next = head;

            // 每次将链表拆分成若干个长度的subLen的子链表,每两个子链表一组进行合并
            for (int subLength = 1; subLength < length; subLength *= 2) {

                ListNode prev = dummyHead;
                // curr用于记录拆分链表的位置
                ListNode curr = dummyHead.next;

                // 如果链表没有被拆分完
                while (curr != null) {

                    // 拆分subLen长度的链表1
                    ListNode head1 = curr;
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }

                    // 拆分subLen长度链表2
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }

                    // 再次断开
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }

                    // 合并两个subLen长度的有序链表,并将好的表头指向到prev
                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    // next 用于记录拆分完两个链表的结束位置
                    curr = next;
                }
            }
            return dummyHead.next;
        }
    }

    // 合并两个有序链表
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

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
//leetcode submit region end(Prohibit modification and deletion)




