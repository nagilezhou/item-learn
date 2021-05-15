//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time.
//
// Implement the MinStack class:
//
//
// MinStack() initializes the stack object.
// void push(val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
//
//
//
// Example 1:
//
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//
//
//
// Constraints:
//
//
// -231 <= val <= 231 - 1
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks.
// At most 3 * 104 calls will be made to push, pop, top, and getMin.
//
// Related Topics 栈 设计
// 👍 902 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：Min Stack
public class P155MinStack{
    public static void main(String[] args) {
        //Solution solution = new P155MinStack().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
        private Deque<Integer> originalStack = new LinkedList<>();
        private Deque<Integer> minStack = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        originalStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int val = originalStack.pop();
        if(!minStack.isEmpty() && val == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return originalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}



