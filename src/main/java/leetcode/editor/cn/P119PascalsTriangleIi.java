//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal
//'s triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly abov
//e it as shown:
//
//
// Example 1:
// Input: rowIndex = 3
//Output: [1,3,3,1]
// Example 2:
// Input: rowIndex = 0
//Output: [1]
// Example 3:
// Input: rowIndex = 1
//Output: [1,1]
//
//
// Constraints:
//
//
// 0 <= rowIndex <= 33
//
//
//
// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra sp
//ace?
// Related Topics 数组 动态规划
// 👍 302 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java：Pascal's Triangle II
public class P119PascalsTriangleIi{
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(4).toString());
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        dp[0] = 1;
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 0; j--){
                if(j - 1 >= 0){
                    dp[j] += dp[j -1];
                }else {
                    dp[j] = 1;
                }
            }
        }
        return Arrays.stream(dp).boxed().collect(Collectors.toList());

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



