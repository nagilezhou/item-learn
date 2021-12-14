//There are n different online courses numbered from 1 to n. You are given an ar
//ray courses where courses[i] = [durationi, lastDayi] indicate that the ith cours
//e should be taken continuously for durationi days and must be finished before or
// on lastDayi.
//
// You will start on the 1st day and you cannot take two or more courses simulta
//neously.
//
// Return the maximum number of courses that you can take.
//
//
// Example 1:
//
//
//Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
//Output: 3
//Explanation:
//There are totally 4 courses, but you can take 3 courses at most:
//First, take the 1st course, it costs 100 days so you will finish it on the 100
//th day, and ready to take the next course on the 101st day.
//Second, take the 3rd course, it costs 1000 days so you will finish it on the 1
//100th day, and ready to take the next course on the 1101st day.
//Third, take the 2nd course, it costs 200 days so you will finish it on the 130
//0th day.
//The 4th course cannot be taken now, since you will finish it on the 3300th day
//, which exceeds the closed date.
//
//
// Example 2:
//
//
//Input: courses = [[1,2]]
//Output: 1
//
//
// Example 3:
//
//
//Input: courses = [[3,2],[4,3]]
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= courses.length <= 104
// 1 <= durationi, lastDayi <= 104
//
// Related Topics 贪心 数组 堆（优先队列）
// 👍 243 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Java：Course Schedule III
public class P630CourseScheduleIii{
    public static void main(String[] args) {
        Solution solution = new P630CourseScheduleIii().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for(int[] course : courses){
            int duration = course[0];
            int end = course[1];
            sum += duration;
            queue.add(duration);
            if(sum > end){
                sum -= queue.poll();
            }
        }
        return queue.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



