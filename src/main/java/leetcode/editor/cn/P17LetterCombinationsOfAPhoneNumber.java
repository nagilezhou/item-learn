//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order.
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters.
//
//
//
//
// Example 1:
//
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// Example 2:
//
//
//Input: digits = ""
//Output: []
//
//
// Example 3:
//
//
//Input: digits = "2"
//Output: ["a","b","c"]
//
//
//
// Constraints:
//
//
// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1344 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：Letter Combinations of a Phone Number
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            for (char c : digits.toCharArray()) {
                res = covert(res, c);
            }
            return res;
        }

        public List<String> covert(List<String> stringList, char c) {
            List<String> paramList = new ArrayList<>();
            switch (c) {
                case '2':
                    paramList = Arrays.asList("a", "b", "c");
                    break;
                case '3':
                    paramList = Arrays.asList("d", "e", "f");
                    break;
                case '4':
                    paramList = Arrays.asList("g", "h", "i");
                    break;
                case '5':
                    paramList = Arrays.asList("j", "k", "l");
                    break;
                case '6':
                    paramList = Arrays.asList("m", "n", "o");
                    break;
                case '7':
                    paramList = Arrays.asList("p", "q", "r", "s");
                    break;
                case '8':
                    paramList = Arrays.asList("t", "u", "v");
                    break;
                case '9':
                    paramList = Arrays.asList("w", "x", "y", "z");
                    break;
            }
            if (stringList.isEmpty()) {
                return paramList;
            }
            List<String> res = new ArrayList<>();
            for (String str : stringList) {
                for (String param : paramList) {
                    res.add(str + param);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



