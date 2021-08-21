//Given an integer num, return an array of the number of 1's in the binary repre
//sentation of every number in the range [0, num].
//
//
// Example 1:
//
//
//Input: num = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//
//
// Example 2:
//
//
//Input: num = 5
//Output: [0,1,1,2,1,2]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
//
//
//
// Constraints:
//
//
// 0 <= num <= 105
//
//
//
// Follow up:
//
//
// It is very easy to come up with a solution with run time O(32n). Can you do i
//t in linear time O(n) and possibly in a single pass?
// Could you solve it in O(n) space complexity?
// Can you do it without using any built-in function (i.e., like __builtin_popco
//unt in C++)?
//
// Related Topics 位运算 动态规划
// 👍 720 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Counting Bits 位运算
// 2021-08-17 review 1
public class P338CountingBits {
    public static void main(String[] args) {
        Solution solution = new P338CountingBits().new Solution();
        System.out.println(Arrays.toString(solution.countBits(2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int num) {
            if (num < 0) {
                return null;
            }
            int[] bitCount = new int[num + 1];
            int highBit = 0;
            for (int i = 1; i <= num; i++) {
                if ((i & (i - 1)) == 0) {
                    highBit = i;
                }
                bitCount[i] = bitCount[i - highBit] + 1;
            }
            return bitCount;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



