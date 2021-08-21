//Given a non-negative integer c, decide whether there're two integers a and b s
//uch that a2 + b2 = c.
//
//
// Example 1:
//
//
//Input: c = 5
//Output: true
//Explanation: 1 * 1 + 2 * 2 = 5
//
//
// Example 2:
//
//
//Input: c = 3
//Output: false
//
//
// Example 3:
//
//
//Input: c = 4
//Output: true
//
//
// Example 4:
//
//
//Input: c = 2
//Output: true
//
//
// Example 5:
//
//
//Input: c = 1
//Output: true
//
//
//
// Constraints:
//
//
// 0 <= c <= 231 - 1
//
// Related Topics 数学
// 👍 283 👎 0

package leetcode.editor.cn;

//Java：Sum of Square Numbers 二分
// 2021-08-21 review 1
public class P633SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new P633SumOfSquareNumbers().new Solution();
        System.out.println(solution.judgeSquareSum(3));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum2(int c) {
            int max = (int)Math.sqrt(c);
            for (int a = 0; a <= max; a++) {
                int b = (int)Math.sqrt(c - a * a);
                if (a * a + b * b == c) {
                    return true;
                }
            }
            return false;
        }

        public boolean judgeSquareSum(int c) {
            int high = (int)Math.sqrt(c);
            int low = 0;
            while (low <= high){
                int res = low * low + high * high;
                if(res == c){
                    return true;
                }else if(res > c){
                    high--;
                }else {
                    low++;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



