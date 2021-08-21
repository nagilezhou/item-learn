//Given an integer n, return the number of strings of length n that consist only
// of vowels (a, e, i, o, u) and are lexicographically sorted.
//
// A string s is lexicographically sorted if for all valid i, s[i] is the same a
//s or comes before s[i+1] in the alphabet.
//
//
// Example 1:
//
//
//Input: n = 1
//Output: 5
//Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i"
//,"o","u"].
//
//
// Example 2:
//
//
//Input: n = 2
//Output: 15
//Explanation: The 15 sorted strings that consist of vowels only are
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
//Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet
//.
//
//
// Example 3:
//
//
//Input: n = 33
//Output: 66045
//
//
//
// Constraints:
//
//
// 1 <= n <= 50
//
// Related Topics 数学 动态规划 回溯算法
// 👍 49 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Count Sorted Vowel Strings dp
// 2021-08-21 review 1
public class P1641CountSortedVowelStrings {
    public static void main(String[] args) {
        Solution solution = new P1641CountSortedVowelStrings().new Solution();
        System.out.println(solution.countVowelStrings(33));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelStrings(int n) {
            int[][] dp = new int[n + 1][6];
            Arrays.fill(dp[1], 1);
            for (int i = 2; i < n + 1; i++) {
                int sum = 0;
                for (int j = 1; j < 6; j++) {
                    sum += dp[i - 1][j];
                    dp[i][j] = sum;

                }
            }
            int sum = 0;
            for (int num : dp[n]) {
                sum += num;
            }
            sum -= dp[n][0];
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



