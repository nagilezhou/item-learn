//An ugly number is a positive integer whose prime factors are limited to 2, 3,
//and 5.
//
// Given an integer n, return true if n is an ugly number.
//
//
// Example 1:
//
//
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3
//
//
// Example 2:
//
//
//Input: n = 1
//Output: true
//Explanation: 1 has no prime factors, therefore all of its prime factors are li
//mited to 2, 3, and 5.
//
//
// Example 3:
//
//
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes the prime factor 7.
//
//
//
// Constraints:
//
//
// -231 <= n <= 231 - 1
//
// Related Topics 数学
// 👍 303 👎 0

package leetcode.editor.cn;
//Java：Ugly Number
public class P263UglyNumber{
    public static void main(String[] args) {
        Solution solution = new P263UglyNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



