//Given a signed 32-bit integer x, return x with its digits reversed. If reversi
//ng x causes the value to go outside the signed 32-bit integer range [-231, 231 -
// 1], then return 0.
//
// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned).
//
//
// Example 1:
//
//
//Input: x = 123
//Output: 321
//
//
// Example 2:
//
//
//Input: x = -123
//Output: -321
//
//
// Example 3:
//
//
//Input: x = 120
//Output: 21
//
//
//
// Constraints:
//
//
// -231 <= x <= 231 - 1
//
// Related Topics 数学
// 👍 3382 👎 0

package leetcode.editor.cn;

//Java：Reverse Integer
public class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int ans = 0;
            while (x != 0) {
                int pop = x % 10;
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                    return 0;
                if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                    return 0;
                ans = ans * 10 + pop;
                x /= 10;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



