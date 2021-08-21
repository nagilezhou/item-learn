//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input.
//
//
// Example 1:
//
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
//
// Constraints:
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 排序 数组
// 👍 917 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

//Java：Merge Intervals 区间数组 排序
// 2021-08-01 review 1
public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        int[][] intervals = new int[][]{
            {1,4},{2,3}
        };
        //Arrays.sort(intervals,(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        //System.out.println(Arrays.deepToString(intervals));
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        LinkedList<int []> res = new LinkedList<>();
        int tempStart = intervals[0][0];
        int tempEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(tempEnd >= intervals[i][0]){
                tempEnd = Math.max(tempEnd, intervals[i][1]);
            }else {
                res.add(new int[]{tempStart, tempEnd});
                tempStart = intervals[i][0];
                tempEnd = intervals[i][1];
            }
        }
        res.add(new int[]{tempStart, tempEnd});
        return res.toArray(new int[res.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



