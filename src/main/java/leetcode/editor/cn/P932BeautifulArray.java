//For some fixed n, an array nums is beautiful if it is a permutation of the int
//egers 1, 2, ..., n, such that:
//
// For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i]
// + nums[j].
//
// Given n, return any beautiful array nums. (It is guaranteed that one exists.)
//
//
//
//
// Example 1:
//
//
//Input: n = 4
//Output: [2,1,4,3]
//
//
//
// Example 2:
//
//
//Input: n = 5
//Output: [3,1,2,5,4]
//
//
//
//
// Note:
//
//
// 1 <= n <= 1000
//
//
//
//
//
// Related Topics 分治算法
// 👍 128 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：Beautiful Array
public class P932BeautifulArray {
    public static void main(String[] args) {
        Solution solution = new P932BeautifulArray().new Solution();
        System.out.println(Arrays.toString(solution.beautifulArray(4)));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, int[]> memo;

        public int[] beautifulArray(int N) {
            memo = new HashMap();
            return f(N);
        }

        public int[] f(int N) {
            if (memo.containsKey(N)) {
                return memo.get(N);
            }

            int[] ans = new int[N];
            if (N == 1) {
                ans[0] = 1;
            } else {
                int t = 0;
                for (int x : f((N + 1) / 2)) {
                    ans[t++] = 2 * x - 1;
                }
                for (int x : f(N / 2)) {
                    ans[t++] = 2 * x;
                }
            }
            memo.put(N, ans);
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



