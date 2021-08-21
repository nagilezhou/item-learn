//Given a string s and an integer k.
//
// Return the maximum number of vowel letters in any substring of s with length
//k.
//
// Vowel letters in English are (a, e, i, o, u).
//
//
// Example 1:
//
//
//Input: s = "abciiidef", k = 3
//Output: 3
//Explanation: The substring "iii" contains 3 vowel letters.
//
//
// Example 2:
//
//
//Input: s = "aeiou", k = 2
//Output: 2
//Explanation: Any substring of length 2 contains 2 vowels.
//
//
// Example 3:
//
//
//Input: s = "leetcode", k = 3
//Output: 2
//Explanation: "lee", "eet" and "ode" contain 2 vowels.
//
//
// Example 4:
//
//
//Input: s = "rhythms", k = 4
//Output: 0
//Explanation: We can see that s doesn't have any vowel letters.
//
//
// Example 5:
//
//
//Input: s = "tryhard", k = 4
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10^5
// s consists of lowercase English letters.
// 1 <= k <= s.length
// Related Topics 字符串 Sliding Window
// 👍 17 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Java：Maximum Number of Vowels in a Substring of Given Length 字符串 滑动窗口
// 2021-08-21 review 1
public class P1456MaximumNumberOfVowelsInASubstringOfGivenLength{
    public static void main(String[] args) {
        Solution solution = new P1456MaximumNumberOfVowelsInASubstringOfGivenLength().new Solution();
        System.out.println(solution.maxVowels("leetcode",3));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVowels(String s, int k) {
        if(s == null || s.length() <= 0 || k<= 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxVowel = 0;
        int tempVowel = 0;
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        while (right < s.length()){
            if(vowelSet.contains(new Character(s.charAt(right)))){
                tempVowel++;
            }
            right++;
            if(right >= k){
                maxVowel = Math.max(maxVowel, tempVowel);
                if(vowelSet.contains(new Character(s.charAt(left)))){
                    tempVowel--;
                }
                left++;
            }
        }
        return maxVowel;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



