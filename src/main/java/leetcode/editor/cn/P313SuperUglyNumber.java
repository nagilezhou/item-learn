//A super ugly number is a positive integer whose prime factors are in the array
// primes.
//
// Given an integer n and an array of integers primes, return the nth super ugly
// number.
//
// The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
//
//
// Example 1:
//
//
//Input: n = 12, primes = [2,7,13,19]
//Output: 32
//Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
//super ugly numbers given primes = [2,7,13,19].
//
//
// Example 2:
//
//
//Input: n = 1, primes = [2,3,5]
//Output: 1
//Explanation: 1 has no prime factors, therefore all of its prime factors are in
// the array primes = [2,3,5].
//
//
//
// Constraints:
//
//
// 1 <= n <= 106
// 1 <= primes.length <= 100
// 2 <= primes[i] <= 1000
// primes[i] is guaranteed to be a prime number.
// All the values of primes are unique and sorted in ascending order.
//
// Related Topics 数组 哈希表 数学 动态规划 堆（优先队列）
// 👍 173 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Super Ugly Number
public class P313SuperUglyNumber {
    public static void main(String[] args) {
        Solution solution = new P313SuperUglyNumber().new Solution();
        System.out.println(solution.nthSuperUglyNumber(12, new int[] {2, 7, 13, 19}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int m = primes.length;
            int[] dp = new int[m];
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    if (res[dp[j]] * primes[j] <= res[i - 1]) {
                        continue;
                    }
                    res[i] = Math.min(res[i], res[dp[j]] * primes[j]);
                }
                for (int j = 0; j < m; j++) {
                    if (res[i] == res[dp[j]] * primes[j]) {
                        dp[j] = dp[j] + 1;
                    }
                }
            }
            return res[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



