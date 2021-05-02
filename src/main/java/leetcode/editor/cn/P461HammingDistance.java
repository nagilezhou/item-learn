//The Hamming distance between two integers is the number of positions at which
//the corresponding bits are different.
//
// Given two integers x and y, return the Hamming distance between them.
//
//
// Example 1:
//
//
//Input: x = 1, y = 4
//Output: 2
//Explanation:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//The above arrows point to positions where the corresponding bits are different
//.
//
//
// Example 2:
//
//
//Input: x = 3, y = 1
//Output: 1
//
//
//
// Constraints:
//
//
// 0 <= x, y <= 231 - 1
//
// Related Topics 位运算
// 👍 400 👎 0

package leetcode.editor.cn;

//Java：Hamming Distance
public class P461HammingDistance {
    public static void main(String[] args) {
        Solution solution = new P461HammingDistance().new Solution();
        System.out.println(solution.hammingDistance(1, 4));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            int res = x ^ y;
            int count = 0;
            while (res != 0) {
                count++;
                res = res & (res - 1);
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



