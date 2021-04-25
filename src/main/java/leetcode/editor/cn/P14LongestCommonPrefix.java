//Write a function to find the longest common prefix string amongst an array of
//strings.
//
// If there is no common prefix, return an empty string "".
//
//
// Example 1:
//
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//
//
// Example 2:
//
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//
//
//
// Constraints:
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lower-case English letters.
//
// Related Topics 字符串
// 👍 1578 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Longest Common Prefix
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");
        if(strs == null || strs.length == 0){
            return result.toString();
        }
        int mixLength = Arrays.stream(strs).map(String::length).min(Integer::compareTo).get();
        boolean notEqual = false;
        for (int i = 0; i < mixLength; i++){
            Character c = null;
            for(String str : strs){
                if(c == null){
                    c = str.charAt(i);
                }else {
                    if(c != str.charAt(i)){
                        notEqual = true;
                        break;
                    }
                }
            }
            if(notEqual){
                break;
            }else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



