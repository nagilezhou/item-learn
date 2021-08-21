//You have a lock in front of you with 4 circular wheels. Each wheel has 10 slot
//s: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freel
//y and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each
// move consists of turning one wheel one slot.
//
// The lock initially starts at '0000', a string representing the state of the 4
// wheels.
//
// You are given a list of deadends dead ends, meaning if the lock displays any
//of these codes, the wheels of the lock will stop turning and you will be unable
//to open it.
//
// Given a target representing the value of the wheels that will unlock the lock
//, return the minimum total number of turns required to open the lock, or -1 if i
//t is impossible.
//
//
// Example 1:
//
//
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation:
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would
// be invalid,
//because the wheels of the lock become stuck after the display becomes the dead
// end "0102".
//
//
// Example 2:
//
//
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation:
//We can turn the last wheel in reverse to move from "0000" -> "0009".
//
//
// Example 3:
//
//
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], t
//arget = "8888"
//Output: -1
//Explanation:
//We can't reach the target without getting stuck.
//
//
// Example 4:
//
//
//Input: deadends = ["0000"], target = "8888"
//Output: -1
//
//
//
// Constraints:
//
//
// 1 <= deadends.length <= 500
// deadends[i].length == 4
// target.length == 4
// target will not be in the list deadends.
// target and deadends[i] consist of digits only.
//
// Related Topics 广度优先搜索 数组 哈希表 字符串
// 👍 365 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//Java：Open the Lock bfs
// 2021-08-21 review 1
public class P752OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new P752OpenTheLock().new Solution();
        System.out.println(solution.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> visited = new HashSet<>();
            for(String dead : deadends){
                visited.add(dead);
            }
            Queue<String> queue = new LinkedList<>();
            String start = "0000";
            if(!visited.contains(start)){
                queue.offer(start);
                visited.add(start);
            }
            int count = 0;
            while (!queue.isEmpty()) {
                Queue<String> temp = new LinkedList<>();
                for(String lock : queue){
                    if(target.equalsIgnoreCase(lock)){
                        return count;
                    }
                    for(int i = 0; i < lock.length(); i++){
                        StringBuilder newLock = new StringBuilder(lock);
                        char c = lock.charAt(i);
                        char before = c == '0' ? '9' : (char)(c - 1);
                        newLock.replace(i, i + 1, String.valueOf(before));
                        String beforeLock = newLock.toString();
                        if(!visited.contains(beforeLock)){
                            temp.offer(beforeLock);
                            visited.add(beforeLock);
                        }
                        char after = c == '9' ? '0' : (char)(c + 1);
                        newLock.replace(i, i + 1, String.valueOf(after));
                        String afterLock = newLock.toString();
                        if(!visited.contains(afterLock)){
                            temp.offer(afterLock);
                            visited.add(afterLock);
                        }
                    }
                }
                queue = temp;
                count++;
            }
            return -1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



