//Given two strings s and p, return an array of all the start indices of p's ana
//grams in s. You may return the answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once.
//
//
// Example 1:
//
//
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//
// Example 2:
//
//
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
//
//
//
// Constraints:
//
//
// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 759 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Find All Anagrams in a String
public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd","abc"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if(s == null || p == null){
                return null;
            }

            int[] countArray = new int[26];
            for(char c : p.toCharArray()){
                countArray[c - 'a']++;
            }

            int left = 0;
            int right = 0;
            List<Integer> res = new ArrayList();
            int differ = 0;
            for(int count : countArray){
                if(count != 0){
                    differ++;
                }
            }

            while(right < s.length()){
               if(--countArray[s.charAt(right) - 'a'] == 0){
                   differ--;
               }
                right++;
                if(right - left + 1 > p.length()){
                    if(differ == 0){
                        res.add(left);
                    }
                    if(++countArray[s.charAt(left) - 'a'] == 1){
                        differ++;
                    }
                    left++;
                }
            }
            return res;
        }

        private boolean check(int[] countArray){
            for(int count : countArray){
                if(count != 0){
                    return false;
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}



