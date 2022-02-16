//Given a singly linked list, return a random node's value from the linked list.
// Each node must have the same probability of being chosen.
//
// Implement the Solution class:
//
//
// Solution(ListNode head) Initializes the object with the head of the singly-li
//nked list head.
// int getRandom() Chooses a node randomly from the list and returns its value.
//All the nodes of the list should be equally likely to be chosen.
//
//
//
// Example 1:
//
//
//Input
//["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
//[[[1, 2, 3]], [], [], [], [], []]
//Output
//[null, 1, 3, 2, 2, 3]
//
//Explanation
//Solution solution = new Solution([1, 2, 3]);
//solution.getRandom(); // return 1
//solution.getRandom(); // return 3
//solution.getRandom(); // return 2
//solution.getRandom(); // return 2
//solution.getRandom(); // return 3
//// getRandom() should return either 1, 2, or 3 randomly. Each element should h
//ave equal probability of returning.
//
//
//
// Constraints:
//
//
// The number of nodes in the linked list will be in the range [1, 104].
// -104 <= Node.val <= 104
// At most 104 calls will be made to getRandom.
//
//
//
// Follow up:
//
//
// What if the linked list is extremely large and its length is unknown to you?
//
// Could you solve this efficiently without using extra space?
//
// Related Topics 水塘抽样 链表 数学 随机化
// 👍 263 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：Linked List Random Node
public class P382LinkedListRandomNode{
    public static void main(String[] args) {
        //Solution solution = new P382LinkedListRandomNode().new Solution();
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

    ListNode head;
    Random random = new Random(1000);
    public Solution(ListNode _head) {
        head = _head;
    }
    public int getRandom() {
        int ans = 0, idx = 0;
        ListNode t = head;
        while (t != null && ++idx >= 0) {
            if (random.nextInt(idx) == 0) ans = t.val;
            t = t.next;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}



