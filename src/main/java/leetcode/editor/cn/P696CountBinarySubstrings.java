//Give a binary string s, return the number of non-empty substrings that have th
//e same number of 0's and 1's, and all the 0's and all the 1's in these substring
//s are grouped consecutively.
//
// Substrings that occur multiple times are counted the number of times they occ
//ur.
//
//
// Example 1:
//
//
//Input: s = "00110011"
//Output: 6
//Explanation: There are 6 substrings that have equal number of consecutive 1's
//and 0's: "0011", "01", "1100", "10", "0011", and "01".
//Notice that some of these substrings repeat and are counted the number of time
//s they occur.
//Also, "00110011" is not a valid substring because all the 0's (and 1's) are no
//t grouped together.
//
//
// Example 2:
//
//
//Input: s = "10101"
//Output: 4
//Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal nu
//mber of consecutive 1's and 0's.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s[i] is either '0' or '1'.
//
// Related Topics 字符串
// 👍 358 👎 0

package leetcode.editor.cn;

//Java：Count Binary Substrings
public class P696CountBinarySubstrings {
    public static void main(String[] args) {
        Solution solution = new P696CountBinarySubstrings().new Solution();
        System.out.println(solution.countBinarySubstrings("00110011"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String s) {
            int pre = 0;
            int cur = 1;
            int res = 0;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == s.charAt(i - 1)){
                    cur++;
                }else {
                    pre = cur;
                    cur = 1;
                }
                if(pre >= cur){
                    res++;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



