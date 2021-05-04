//You have a long flowerbed in which some of the plots are planted, and some are
// not. However, flowers cannot be planted in adjacent plots.
//
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty
//and 1 means not empty, and an integer n, return if n new flowers can be planted
//in the flowerbed without violating the no-adjacent-flowers rule.
//
//
// Example 1:
// Input: flowerbed = [1,0,0,0,1], n = 1
//Output: true
// Example 2:
// Input: flowerbed = [1,0,0,0,1], n = 2
//Output: false
//
//
// Constraints:
//
//
// 1 <= flowerbed.length <= 2 * 104
// flowerbed[i] is 0 or 1.
// There are no two adjacent flowers in flowerbed.
// 0 <= n <= flowerbed.length
//
// Related Topics 贪心算法 数组
// 👍 347 👎 0

package leetcode.editor.cn;

//Java：Can Place Flowers
public class P605CanPlaceFlowers {
    public static void main(String[] args) {
        Solution solution = new P605CanPlaceFlowers().new Solution();
        System.out.println(solution.canPlaceFlowers(new int[] {1, 0, 0, 0, 0, 1}, 2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (flowerbed == null || n < 0) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                if ((flowerbed[i] == 0) && (i <= 0 || flowerbed[i - 1] == 0) && (i >= flowerbed.length - 1
                    || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
            return count >= n;
        }

        //public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        //    if (flowerbed == null || n < 0) {
        //        return false;
        //    }
        //    int [] dp = new int[flowerbed.length];
        //    for()
        //    return false;
        //}
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



