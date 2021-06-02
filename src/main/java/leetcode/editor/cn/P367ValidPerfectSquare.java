//Given a positive integer num, write a function which returns True if num is a
//perfect square else False.
//
// Follow up: Do not use any built-in library function such as sqrt.
//
//
// Example 1:
// Input: num = 16
//Output: true
// Example 2:
// Input: num = 14
//Output: false
//
//
// Constraints:
//
//
// 1 <= num <= 2^31 - 1
//
// Related Topics 数学 二分查找
// 👍 218 👎 0

package leetcode.editor.cn;
//Java：Valid Perfect Square
public class P367ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new P367ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(1));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 1){
            return true;
        }
        int low = 0;
        int high = num;
        while (low < high){
            int mid = low + (high - low) / 2;
            if(num / mid <= mid){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low * low == num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



