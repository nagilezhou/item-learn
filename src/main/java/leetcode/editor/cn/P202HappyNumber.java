//Write an algorithm to determine if a number n is happy.
//
// A happy number is a number defined by the following process:
//
//
// Starting with any positive integer, replace the number by the sum of the squa
//res of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loop
//s endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
//
//
// Return true if n is a happy number, and false if not.
//
//
// Example 1:
//
//
//Input: n = 19
//Output: true
//Explanation:
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//
//
// Example 2:
//
//
//Input: n = 2
//Output: false
//
//
//
// Constraints:
//
//
// 1 <= n <= 231 - 1
//
// Related Topics 哈希表 数学
// 👍 618 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：Happy Number
public class P202HappyNumber{
    public static void main(String[] args) {
        Solution solution = new P202HappyNumber().new Solution();
        System.out.println(solution.isHappy(19));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true){
            if(n == 1){
                return true;
            }
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = getNum(n);
        }
    }

    public int getNum(int num){
        int sum = 0;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



