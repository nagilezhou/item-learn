//Given a list of non-negative integers nums, arrange them such that they form t
//he largest number.
//
// Note: The result may be very large, so you need to return a string instead of
// an integer.
//
//
// Example 1:
//
//
//Input: nums = [10,2]
//Output: "210"
//
//
// Example 2:
//
//
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
//
//
// Example 3:
//
//
//Input: nums = [1]
//Output: "1"
//
//
// Example 4:
//
//
//Input: nums = [10]
//Output: "10"
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 109
//
// Related Topics 贪心 字符串 排序
// 👍 736 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

import javafx.util.Pair;

//Java：Largest Number
public class P179LargestNumber {
    public static void main(String[] args) {
        Solution solution = new P179LargestNumber().new Solution();
        System.out.println(solution.largestNumber(new int[]{34323,3432}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            String[] ss = new String[n];
            for (int i = 0; i < n; i++) {
                ss[i] = "" + nums[i];
            }
            Arrays.sort(ss, (a, b) -> {
                String sa = a + b, sb = b + a ;
                return sb.compareTo(sa);
            });

            StringBuilder sb = new StringBuilder();
            for (String s : ss) {
                sb.append(s);
            }
            int len = sb.length();
            int k = 0;
            while (k < len - 1 && sb.charAt(k) == '0') {
                k++;
            }
            return sb.substring(k);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



