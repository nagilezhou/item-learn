//You are given two strings s and t of the same length. You want to change s to
//t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| t
//hat is, the absolute difference between the ASCII values of the characters.
//
// You are also given an integer maxCost.
//
// Return the maximum length of a substring of s that can be changed to be the s
//ame as the corresponding substring of twith a cost less than or equal to maxCost
//.
//
// If there is no substring from s that can be changed to its corresponding subs
//tring from t, return 0.
//
//
// Example 1:
//
//
//Input: s = "abcd", t = "bcdf", maxCost = 3
//Output: 3
//Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum leng
//th is 3.
//
// Example 2:
//
//
//Input: s = "abcd", t = "cdef", maxCost = 3
//Output: 1
//Explanation: Each character in s costs 2 to change to charactor in t, so the m
//aximum length is 1.
//
//
// Example 3:
//
//
//Input: s = "abcd", t = "acde", maxCost = 0
//Output: 1
//Explanation: You can't make any change, so the maximum length is 1.
//
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 10^5
// 0 <= maxCost <= 10^6
// s and t only contain lower case English letters.
//
// Related Topics 数组 Sliding Window
// 👍 126 👎 0

package leetcode.editor.cn;

//Java：Get Equal Substrings Within Budget 字符串 滑动窗口
// 2021-08-21 review 1
public class P1208GetEqualSubstringsWithinBudget{
    public static void main(String[] args) {
        Solution solution = new P1208GetEqualSubstringsWithinBudget().new Solution();
        System.out.println(solution.equalSubstring("tlslxtfcdjhmknqudilp","bvydddtftartnntdhyks",39));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
       int left = 0;
       int right = 0;
       int sum = 0;
       int res = 0;
       while (right < s.length()){
           sum += Math.abs(s.charAt(right) - t.charAt(right));
           right++;
           while (sum > maxCost){
               sum -= Math.abs(s.charAt(left) - t.charAt(left));
               left++;
           }
           res = Math.max(res,right - left);
       }
       return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



