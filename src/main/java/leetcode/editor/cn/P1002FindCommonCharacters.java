//Given an array words of strings made only from lowercase letters, return a lis
//t of all characters that show up in all strings within the list (including dupli
//cates). For example, if a character occurs 3 times in all strings but not 4 time
//s, you need to include that character three times in the final answer.
//
// You may return the answer in any order.
//
//
//
//
// Example 1:
//
//
//Input: ["bella","label","roller"]
//Output: ["e","l","l"]
//
//
//
// Example 2:
//
//
//Input: ["cool","lock","cook"]
//Output: ["c","o"]
//
//
//
//
// Note:
//
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 100
// words[i] consists of lowercase English letters.
//
//
//
// Related Topics 数组 哈希表
// 👍 221 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Find Common Characters 字符串 哈希表 字典
// 2021-08-21 review 1
public class P1002FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new P1002FindCommonCharacters().new Solution();
        System.out.println(solution.commonChars(new String[]{"bella","label","roller"}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] words) {
            int[][] dictionary = new int[words.length][26];
            for (int i = 0; i < words.length; i++) {
                for (char c : words[i].toCharArray()) {
                    dictionary[i][c - 'a']++;
                }
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                int tmp = words.length;
                for (int j = 0; j < words.length; j++) {
                    tmp = Math.min(tmp, dictionary[j][i]);
                }
                if (tmp == 0) {
                    continue;
                }
                char c = (char)('a' + i);
                for (int j = 0; j < tmp; j++) {
                    res.add(String.valueOf(c));
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



