//Given two strings s and t, return true if t is an anagram of s, and false othe
//rwise.
//
//
// Example 1:
// Input: s = "anagram", t = "nagaram"
//Output: true
// Example 2:
// Input: s = "rat", t = "car"
//Output: false
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.
//
//
//
// Follow up: What if the inputs contain Unicode characters? How would you adapt
// your solution to such a case?
// Related Topics 排序 哈希表
// 👍 383 👎 0

package leetcode.editor.cn;

//Java：Valid Anagram
public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("anagram","nagaram"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
                counts[t.charAt(i) - 'a']--;
            }
            for (int count : counts) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



