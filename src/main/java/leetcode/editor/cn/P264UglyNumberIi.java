//An ugly number is a positive integer whose prime factors are limited to 2, 3,
//and 5.
//
// Given an integer n, return the nth ugly number.
//
//
// Example 1:
//
//
//Input: n = 10
//Output: 12
//Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10
//ugly numbers.
//
//
// Example 2:
//
//
//Input: n = 1
//Output: 1
//Explanation: 1 has no prime factors, therefore all of its prime factors are li
//mited to 2, 3, and 5.
//
//
//
// Constraints:
//
//
// 1 <= n <= 1690
//
// Related Topics 哈希表 数学 动态规划 Heap (Priority Queue)
// 👍 678 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//Java：Ugly Number II dp
// 2021-08-17 review 1
public class P264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        System.out.println(solution.nthUglyNumber(10));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p1 = 1;
            int p2 = p1;
            int p3 = p2;
            for(int i = 2; i <= n; i++){
                int num1 = 2 * dp[p1];
                int num2 = 3 * dp[p2];
                int num3 = 5 * dp[p3];
                dp[i] = Math.min(Math.min(num1,num2),num3);
                if(dp[i] == num1){
                    p1++;
                }
                if(dp[i] == num2){
                    p2++;
                }
                if(dp[i] == num3){
                    p3++;
                }
            }
            return dp[n];
        }


        public int nthUglyNumber2(int n) {
            int[] factory = {2,3,5};
            Set<Long> set = new HashSet<>();
            PriorityQueue<Long> heap = new PriorityQueue<>();
            set.add(1L);
            heap.add(1L);
            int ugly = 0;
            for(int i = 0; i < n; i++){
                long curr = heap.poll();
                ugly = (int)curr;
                for(int num : factory){
                    long next = curr * num;
                    if(set.add(next)){
                        heap.offer(next);
                    }
                }
            }
            return ugly;
        }


        public int nthUglyNumber3(int n) {
            Set<Integer> set = new HashSet<>();
            set.add(1);
            int temp = 1;
            int incr = 2;
            while (set.size() != n) {
                if ((incr % 2 == 0 && set.contains(incr / 2)) || (incr % 3 == 0 && set.contains(incr / 3)) || (
                    incr % 5 == 0 && set.contains(incr / 5))) {
                    set.add(incr);
                    temp = incr;
                }
                incr++;
            }
            return temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



