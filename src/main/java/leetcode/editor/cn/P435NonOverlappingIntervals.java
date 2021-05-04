//Given an array of intervals intervals where intervals[i] = [starti, endi], ret
//urn the minimum number of intervals you need to remove to make the rest of the i
//ntervals non-overlapping.
//
//
// Example 1:
//
//
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-overla
//pping.
//
//
// Example 2:
//
//
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals no
//n-overlapping.
//
//
// Example 3:
//
//
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
//
//
//
// Constraints:
//
//
// 1 <= intervals.length <= 2 * 104
// intervals[i].length == 2
// -2 * 104 <= starti < endi <= 2 * 104
//
// Related Topics 贪心算法
// 👍 411 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Non-overlapping Intervals
public class P435NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new P435NonOverlappingIntervals().new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][] {{1, 100}, {11, 22}, {1, 11},{2, 12}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals2(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
            System.out.println(Arrays.deepToString(intervals));
            int remove = 0;
            int pre = 0;
            int current = 1;
            while (current < intervals.length){
                if(intervals[current][0] < intervals[pre][1]){
                    remove++;
                }else {
                    pre = current;
                }
                current++;
            }
            return remove;
        }

        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }

            Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

            System.out.println(Arrays.deepToString(intervals));
            int n = intervals.length;
            int[] dp = new int[n];
            //Arrays.fill(dp, 1);
            dp[0] = 1;
            for (int i = 1; i < n; ++i) {
                System.out.println("第 i : " + i + "外层");
                for (int j = 0; j < i; ++j) {
                    System.out.println("第 j : " + j + "内层");
                    System.out.println("数组:" + Arrays.toString(intervals[j]) + " " + Arrays.toString(intervals[i]));
                    if (intervals[j][1] <= intervals[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        System.out.println("更新dp " + dp[i]);
                    }else {
                        dp[i] =  Math.max(dp[i], 1);
                    }
                }
            }
            return n - Arrays.stream(dp).max().getAsInt();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



