//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] r
//epresents the width and the height of an envelope.
//
// One envelope can fit into another if and only if both the width and height of
// one envelope are greater than the other envelope's width and height.
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one in
//side the other).
//
// Note: You cannot rotate an envelope.
//
//
// Example 1:
//
//
//Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3]
//=> [5,4] => [6,7]).
//
//
// Example 2:
//
//
//Input: envelopes = [[1,1],[1,1],[1,1]]
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= envelopes.length <= 105
// envelopes[i].length == 2
// 1 <= wi, hi <= 105
//
// Related Topics 数组 二分查找 动态规划 排序
// 👍 654 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Russian Doll Envelopes
public class P354RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new P354RussianDollEnvelopes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes2(int[][] envelopes) {
            if (envelopes == null) {
                return 0;
            }
            Arrays.sort(envelopes, (o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]));

            int n = envelopes.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (envelopes[j][1] < envelopes[i][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null) {
                return 0;
            }
            Arrays.sort(envelopes, (o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]));

            int n = envelopes.length;
            int[] dp = new int[n];
            int end = 0;
            for(int i = 0; i < n; i++){
                int left = 0;
                int right = end;
                while (left < right){
                    int mid = left + right >> 1;
                    if (dp[mid] >= envelopes[i][1]){
                        right = mid;
                    }else {
                        left = mid + 1;
                    }
                }
                if(left == end){
                    end++;
                }
                dp[left] = envelopes[i][1];
            }
            //System.out.println(Arrays.toString(dp));
            return end ;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



