//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division, and mod operator.
//
// Return the quotient after dividing dividend by divisor.
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
//
// Note: Assume we are dealing with an environment that could only store integer
//s within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, ass
//ume that your function returns 231 − 1 when the division result overflows.
//
//
// Example 1:
//
//
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = truncate(3.33333..) = 3.
//
//
// Example 2:
//
//
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = truncate(-2.33333..) = -2.
//
//
// Example 3:
//
//
//Input: dividend = 0, divisor = 1
//Output: 0
//
//
// Example 4:
//
//
//Input: dividend = 1, divisor = 1
//Output: 1
//
//
//
// Constraints:
//
//
// -231 <= dividend, divisor <= 231 - 1
// divisor != 0
//
// Related Topics 位运算 数学
// 👍 615 👎 0

package leetcode.editor.cn;

//Java：Divide Two Integers
public class P29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29DivideTwoIntegers().new Solution();
        System.out.println(solution.mul(10,9));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            long x = dividend, y = divisor;
            boolean isNeg = false;
            if ((x > 0 && y < 0) || (x < 0 && y > 0)) { isNeg = true; }
            if (x < 0) { x = -x; }
            if (y < 0) { y = -y; }
            long l = 0, r = x;
            while (l < r) {
                long mid = l + r + 1 >> 1;
                if (mul(mid, y) <= x) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            long ans = isNeg ? -l : l;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)ans;
        }

        long mul(long a, long k) {
            long ans = 0;
            while (k > 0) {
                if ((k & 1) == 1) { ans += a; }
                k >>= 1;
                a += a;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



