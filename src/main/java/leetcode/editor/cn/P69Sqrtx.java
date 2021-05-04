//Given a non-negative integer x, compute and return the square root of x.
//
// Since the return type is an integer, the decimal digits are truncated, and on
//ly the integer part of the result is returned.
//
//
// Example 1:
//
//
//Input: x = 4
//Output: 2
//
//
// Example 2:
//
//
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part is
// truncated, 2 is returned.
//
//
// Constraints:
//
//
// 0 <= x <= 231 - 1
//
// Related Topics 数学 二分查找
// 👍 670 👎 0

package leetcode.editor.cn;

//Java：Sqrt(x)
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        System.out.println(solution.mySqrt(8));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int left = 1;
            int right = x;
            int sqrt;
            int mid;
            while (left <= right){
                mid = left + (right - left) / 2;
                sqrt = x / mid;
                if(mid == sqrt){
                    return mid;
                }else if(mid > sqrt){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return right;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



