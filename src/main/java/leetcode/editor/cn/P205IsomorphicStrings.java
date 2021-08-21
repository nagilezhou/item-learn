//Given two strings s and t, determine if they are isomorphic.
//
// Two strings s and t are isomorphic if the characters in s can be replaced to
//get t.
//
// All occurrences of a character must be replaced with another character while
//preserving the order of characters. No two characters may map to the same charac
//ter, but a character may map to itself.
//
//
// Example 1:
// Input: s = "egg", t = "add"
//Output: true
// Example 2:
// Input: s = "foo", t = "bar"
//Output: false
// Example 3:
// Input: s = "paper", t = "title"
//Output: true
//
//
// Constraints:
//
//
// 1 <= s.length <= 5 * 104
// t.length == s.length
// s and t consist of any valid ascii character.
//
// Related Topics 哈希表
// 👍 353 👎 0

package leetcode.editor.cn;

//Java：Isomorphic Strings 哈希表
// 2021-08-12 review 1
public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        System.out.println(solution.isIsomorphic("ab","aa"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            // ascii 一共256个字符 这里建立257个空间,0空间默认不用
            int[] sIndex = new int[256];
            int[] tIndex = new int[256];
            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);
                if(sIndex[sc] != tIndex[tc]){
                    return false;
                }
                sIndex[sc] = tIndex[tc] = i + 1;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



