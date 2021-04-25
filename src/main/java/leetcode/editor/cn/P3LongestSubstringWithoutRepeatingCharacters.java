//Given a string s, find the length of the longest substring without repeating c
//haracters.
//
//
// Example 1:
//
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
// Example 2:
//
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
// Example 3:
//
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a
//substring.
//
//
// Example 4:
//
//
//Input: s = ""
//Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5364 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：Longest Substring Without Repeating Characters
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int maxCount = 0;
        Set<Character> charSet = new HashSet<>();
        int right = -1;
        for(int i = 0; i < s.length(); i++){
            if(i != 0){
                charSet.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !charSet.contains(s.charAt(right + 1))){
                charSet.add(s.charAt(right + 1));
                right++;
            }
            maxCount = Math.max(maxCount, charSet.size());
        }
        return maxCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



