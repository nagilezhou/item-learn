//You are given an integer array heights representing the heights of buildings,
//some bricks, and some ladders.
//
// You start your journey from building 0 and move to the next building by possi
//bly using bricks or ladders.
//
// While moving from building i to building i+1 (0-indexed),
//
//
// If the current building's height is greater than or equal to the next buildin
//g's height, you do not need a ladder or bricks.
// If the current building's height is less than the next building's height, you
// can either use one ladder or (h[i+1] - h[i]) bricks.
//
//
// Return the furthest building index (0-indexed) you can reach if you use the g
//iven ladders and bricks optimally.
//
//
// Example 1:
//
//
//Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
//Output: 4
//Explanation: Starting at building 0, you can follow these steps:
//- Go to building 1 without using ladders nor bricks since 4 >= 2.
//- Go to building 2 using 5 bricks. You must use either bricks or ladders becau
//se 2 < 7.
//- Go to building 3 without using ladders nor bricks since 7 >= 6.
//- Go to building 4 using your only ladder. You must use either bricks or ladde
//rs because 6 < 9.
//It is impossible to go beyond building 4 because you do not have any more bric
//ks or ladders.
//
//
// Example 2:
//
//
//Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
//Output: 7
//
//
// Example 3:
//
//
//Input: heights = [14,3,19,3], bricks = 17, ladders = 0
//Output: 3
//
//
//
// Constraints:
//
//
// 1 <= heights.length <= 105
// 1 <= heights[i] <= 106
// 0 <= bricks <= 109
// 0 <= ladders <= heights.length
//
// Related Topics 贪心 数组 堆（优先队列）
// 👍 75 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：Furthest Building You Can Reach
public class P1642FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        Solution solution = new P1642FurthestBuildingYouCanReach().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for(int i = 1; i < heights.length; i++){
                int cnt = heights[i] - heights[i - 1];
                if(cnt <= 0){
                    continue;
                }
                heap.offer(cnt);
                bricks -= cnt;
                if (bricks < 0 && ladders > 0){
                    ladders--;
                    bricks += heap.poll();
                }
                if(bricks < 0){
                    return i - 1;
                }
            }
            return heights.length - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



