//Given two strings s and t, return true if they are equal when both are typed i
//nto empty text editors. '#' means a backspace character.
//
// Note that after backspacing an empty text, the text will continue empty.
//
//
// Example 1:
//
//
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
//
//
// Example 2:
//
//
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
//
//
// Example 3:
//
//
//Input: s = "a##c", t = "#a#c"
//Output: true
//Explanation: Both s and t become "c".
//
//
// Example 4:
//
//
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".
//
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 200
// s and t only contain lowercase letters and '#' characters.
//
//
//
// Follow up: Can you solve it in O(n) time and O(1) space?
// Related Topics 栈 双指针
// 👍 287 👎 0

package leetcode.editor.cn;
//Java：Backspace String Compare
public class P844BackspaceStringCompare{
    public static void main(String[] args) {
        Solution solution = new P844BackspaceStringCompare().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0){
            while (i >= 0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }else if(skipS > 0){
                    skipS--;
                    i--;
                }else {
                    break;
                }
            }

            while (j >= 0){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                }else if(skipT > 0){
                    skipT--;
                    j--;
                }else {
                    break;
                }
            }
            if(i >= 0 && j >= 0){
                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}



