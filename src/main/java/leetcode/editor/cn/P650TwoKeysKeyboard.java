//There is only one character 'A' on the screen of a notepad. You can perform tw
//o operations on this notepad for each step:
//
//
// Copy All: You can copy all the characters present on the screen (a partial co
//py is not allowed).
// Paste: You can paste the characters which are copied last time.
//
//
// Given an integer n, return the minimum number of operations to get the charac
//ter 'A' exactly n times on the screen.
//
//
// Example 1:
//
//
//Input: n = 3
//Output: 3
//Explanation: Intitally, we have one character 'A'.
//In step 1, we use Copy All operation.
//In step 2, we use Paste operation to get 'AA'.
//In step 3, we use Paste operation to get 'AAA'.
//
//
// Example 2:
//
//
//Input: n = 1
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= n <= 1000
//
// Related Topics 动态规划
// 👍 280 👎 0

package leetcode.editor.cn;

//Java：2 Keys Keyboard dp
// 2021-08-21 review 1
public class P650TwoKeysKeyboard {
    public static void main(String[] args) {
        Solution solution = new P650TwoKeysKeyboard().new Solution();
        System.out.println(solution.minSteps(16));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(int n) {
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + dp[i / j];
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



