//Given a string s and a string array dictionary, return the longest string in t
//he dictionary that can be formed by deleting some of the given string characters
//. If there is more than one possible result, return the longest word with the sm
//allest lexicographical order. If there is no possible result, return the empty s
//tring.
//
//
// Example 1:
//
//
//Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//Output: "apple"
//
//
// Example 2:
//
//
//Input: s = "abpcplea", dictionary = ["a","b","c"]
//Output: "a"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 1000
// s and dictionary[i] consist of lowercase English letters.
//
// Related Topics 排序 双指针
// 👍 148 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//Java：Longest Word in Dictionary through Deleting 字符串
// 2021-08-21 review 1
public class P524LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new P524LongestWordInDictionaryThroughDeleting().new Solution();
        System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("a","b","c")));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String maxLengthStr = "";
            for (String word : dictionary) {
                if (isSubsequence(s, word)) {
                    if (word.length() > maxLengthStr.length() || (word.length() == maxLengthStr.length()
                        && word.compareTo(maxLengthStr) < 0)) {
                        maxLengthStr = word;
                    }
                }
            }
            return maxLengthStr;
        }

        public boolean isSubsequence(String s, String word) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }
            return j == word.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



