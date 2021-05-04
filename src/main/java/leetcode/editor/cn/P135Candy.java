//There are n children standing in a line. Each child is assigned a rating value
// given in the integer array ratings.
//
// You are giving candies to these children subjected to the following requireme
//nts:
//
//
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
//
//
// Return the minimum number of candies you need to have to distribute the candi
//es to the children.
//
//
// Example 1:
//
//
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1,
//2 candies respectively.
//
//
// Example 2:
//
//
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2,
//1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
//
//
//
// Constraints:
//
//
// n == ratings.length
// 1 <= n <= 2 * 104
// 0 <= ratings[i] <= 2 * 104
//
// Related Topics 贪心算法
// 👍 543 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Candy
public class P135Candy{
    public static void main(String[] args) {
        Solution solution = new P135Candy().new Solution();
        // TO TEST
        System.out.println(solution.candy(new int[]{1,3,4,5,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null){
            return 0;
        }
        int length = ratings.length;
        int [] candy = new int[length];
        for(int i = 0; i < length; i++){
            candy[i] = 1;
        }
        for(int i = 1; i < length; i++){
            if(ratings[i] > ratings[i -1]){
                candy[i] = candy[i - 1] + 1;
            }
        }
        for(int i = length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]){
                candy[i] = candy[i + 1] + 1;
            }
        }
        return Arrays.stream(candy).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



