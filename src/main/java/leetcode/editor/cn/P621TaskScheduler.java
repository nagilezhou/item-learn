//Given a characters array tasks, representing the tasks a CPU needs to do, wher
//e each letter represents a different task. Tasks could be done in any order. Eac
//h task is done in one unit of time. For each unit of time, the CPU could complet
//e either one task or just be idle.
//
// However, there is a non-negative integer n that represents the cooldown perio
//d between two same tasks (the same letter in the array), that is that there must
// be at least n units of time between any two same tasks.
//
// Return the least number of units of times that the CPU will take to finish al
//l the given tasks.
//
//
// Example 1:
//
//
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation:
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
//
//
// Example 2:
//
//
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//And so on.
//
//
// Example 3:
//
//
//Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//Output: 16
//Explanation:
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
// idle -> A
//
//
//
// Constraints:
//
//
// 1 <= task.length <= 104
// tasks[i] is upper-case English letter.
// The integer n is in the range [0, 100].
//
// Related Topics 贪心算法 队列 数组
// 👍 637 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Task Scheduler 贪心
// 2021-08-21 review 1
public class P621TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new P621TaskScheduler().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] bucket = new int[26];
            for (int i = 0; i < tasks.length; i++) {
                bucket[tasks[i] - 'A']++;
            }
            Arrays.sort(bucket);
            int maxTime = bucket[25];
            int maxCount = 1;
            for (int i = 25; i >= 1; i--) {
                if (bucket[i] == bucket[i - 1]) {
                    maxCount++;
                } else {
                    break;
                }
            }
            int res = (maxTime - 1) * (n + 1) + maxCount;
            return Math.max(res, tasks.length);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



