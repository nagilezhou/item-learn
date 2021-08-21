//Given a string array words, return the maximum value of length(word[i]) * leng
//th(word[j]) where the two words do not share common letters. If no such two word
//s exist, return 0.
//
//
// Example 1:
//
//
//Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
//Output: 16
//Explanation: The two words can be "abcw", "xtfn".
//
//
// Example 2:
//
//
//Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
//Output: 4
//Explanation: The two words can be "ab", "cd".
//
//
// Example 3:
//
//
//Input: words = ["a","aa","aaa","aaaa"]
//Output: 0
//Explanation: No such pair of words.
//
//
//
// Constraints:
//
//
// 2 <= words.length <= 1000
// 1 <= words[i].length <= 1000
// words[i] consists only of lowercase English letters.
//
// Related Topics 位运算
// 👍 164 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：Maximum Product of Word Lengths 位运算 哈希表
// 2021-08-17 review 1
public class P318MaximumProductOfWordLengths{
    public static void main(String[] args) {
        Solution solution = new P318MaximumProductOfWordLengths().new Solution();
        System.out.println(solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0){
            return 0;
        }
        // 创建每个字符串的掩码
        Map<Integer,Integer> map = new HashMap<>(words.length);
        for(String word : words){
            Integer bitMask = 0;
            for(char c : word.toCharArray()){
                bitMask |= 1 << (c - 'a');
            }
            Integer wordLength = word.length();
            Integer otherLength = map.get(bitMask);
            if(otherLength == null || wordLength > otherLength){
                map.put(bitMask, wordLength);
            }
        }
        // 真实计算
        int res = 0;
        for(int i : map.keySet()){
            for(int j : map.keySet()){
                if((i & j) == 0){
                    res = Math.max(res,map.get(i) * map.get(j));
                }
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}



