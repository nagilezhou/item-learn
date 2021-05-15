//Given an integer n, return true if it is a power of four. Otherwise, return fa
//lse.
//
// An integer n is a power of four, if there exists an integer x such that n ==
//4x.
//
//
// Example 1:
// Input: n = 16
//Output: true
// Example 2:
// Input: n = 5
//Output: false
// Example 3:
// Input: n = 1
//Output: true
//
//
// Constraints:
//
//
// -231 <= n <= 231 - 1
//
//
//
//Follow up: Could you solve it without loops/recursion? Related Topics 位运算
// 👍 181 👎 0

package leetcode.editor.cn;

//Java：Power of Four
public class P342PowerOfFour {
    public static void main(String[] args) {
        Solution solution = new P342PowerOfFour().new Solution();
        System.out.println(solution.isPowerOfFour(1024 * 4 * 4 * 4 -1));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public boolean isPowerOfFour(int n) {
            return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



