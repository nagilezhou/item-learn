//Write a function that reverses a string. The input string is given as an array
// of characters s.
//
//
// Example 1:
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// Example 2:
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s[i] is a printable ascii character.
//
//
//
// Follow up: Do not allocate extra space for another array. You must do this by
// modifying the input array in-place with O(1) extra memory.
// Related Topics 双指针 字符串
// 👍 415 👎 0

package leetcode.editor.cn;
//Java：Reverse String
public class P344ReverseString{
    public static void main(String[] args) {
        Solution solution = new P344ReverseString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right){
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



