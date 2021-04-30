//You are given an array of people, people, which are the attributes of some peo
//ple in a queue (not necessarily in order). Each people[i] = [hi, ki] represents
//the ith person of height hi with exactly ki other people in front who have a hei
//ght greater than or equal to hi.
//
// Reconstruct and return the queue that is represented by the input array peopl
//e. The returned queue should be formatted as an array queue, where queue[j] = [h
//j, kj] is the attributes of the jth person in the queue (queue[0] is the person
//at the front of the queue).
//
//
// Example 1:
//
//
//Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//Explanation:
//Person 0 has height 5 with no other people taller or the same height in front.
//
//Person 1 has height 7 with no other people taller or the same height in front.
//
//Person 2 has height 5 with two persons taller or the same height in front, whi
//ch is person 0 and 1.
//Person 3 has height 6 with one person taller or the same height in front, whic
//h is person 1.
//Person 4 has height 4 with four people taller or the same height in front, whi
//ch are people 0, 1, 2, and 3.
//Person 5 has height 7 with one person taller or the same height in front, whic
//h is person 1.
//Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
//
//
// Example 2:
//
//
//Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
//Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
//
//
//
// Constraints:
//
//
// 1 <= people.length <= 2000
// 0 <= hi <= 106
// 0 <= ki < people.length
// It is guaranteed that the queue can be reconstructed.
//
// Related Topics 贪心算法
// 👍 862 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

//Java：Queue Reconstruction by Height
public class P406QueueReconstructionByHeight{
    public static void main(String[] args) {
        Solution solution = new P406QueueReconstructionByHeight().new Solution();
        int[][] people = new int[][]{
            {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        System.out.println(Arrays.deepToString(people));
        solution.reconstructQueue(people);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



