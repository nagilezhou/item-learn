//
//Given a list of daily temperatures T, return a list such that, for each day in
// the input, tells you how many days you would have to wait until a warmer temper
//ature. If there is no future day for which this is possible, put 0 instead.
//
//For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 7
//3], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//
//
// Note:
//The length of temperatures will be in the range [1, 30000].
//Each temperature will be an integer in the range [30, 100].
// Related Topics 栈 哈希表
// 👍 733 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Java：Daily Temperatures
public class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        Arrays.stream(solution.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 7, 3})).forEach(
            System.out::print);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            if (T == null || T.length == 0) {
                return null;
            }
            int[] result = new int[T.length];
            Deque<Integer> stack = new LinkedList();
            for (int i = 0; i < T.length; i++) {
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    int preIndex = stack.pop();
                    result[preIndex] = i - preIndex;
                }
                stack.push(i);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



