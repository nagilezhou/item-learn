//You are given an array of k linked-lists lists, each linked-list is sorted in
//ascending order.
//
// Merge all the linked-lists into one sorted linked-list and return it.
//
//
// Example 1:
//
//
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
//
//
// Example 2:
//
//
//Input: lists = []
//Output: []
//
//
// Example 3:
//
//
//Input: lists = [[]]
//Output: []
//
//
//
// Constraints:
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] is sorted in ascending order.
// The sum of lists[i].length won't exceed 10^4.
//
// Related Topics 堆 链表 分治算法
// 👍 1280 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：Merge k Sorted Lists
// 2021-07-30 review 1
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();

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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
            for (ListNode node : lists) {
                if (node == null) {
                    continue;
                }
                heap.offer(node);
            }
            ListNode head = new ListNode();
            ListNode tail = head;
            while (!heap.isEmpty()) {
                ListNode next = heap.poll();
                tail.next = next;
                tail = tail.next;
                if (tail.next != null) {
                    heap.offer(tail.next);
                }

            }
            return head.next;
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



