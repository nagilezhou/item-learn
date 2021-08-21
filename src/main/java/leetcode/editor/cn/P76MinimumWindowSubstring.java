//Given two strings s and t, return the minimum window in s which will contain a
//ll the characters in t. If there is no such window in s that covers all characte
//rs in t, return the empty string "".
//
// Note that If there is such a window, it is guaranteed that there will always
//be only one unique minimum window in s.
//
//
// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
// Example 2:
// Input: s = "a", t = "a"
//Output: "a"
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 105
// s and t consist of English letters.
//
//
//
//Follow up: Could you find an algorithm that runs in O(n) time? Related Topics
//哈希表 双指针 字符串 Sliding Window
// 👍 1135 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Minimum Window Substring 滑动窗口
// 2021-08-01 review 1
public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("aa", "aa"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] help = new int[128];
            Arrays.fill(help,-1);
            for (char c : t.toCharArray()) {
               if(help[c] == -1){
                   help[c]++;
               }
                help[c]++;
            }
            int left = 0;
            int right = 0;
            int minLeft = 0;
            int minRight = 0;
            int minSize = s.length() + 1;
            int count = t.length();
            while (right < s.length()) {
                char c = s.charAt(right);
                if (help[c] > 0) {
                    count--;
                }
                help[c]--;
                while (count == 0) {
                    if (right - left + 1 < minSize) {
                        minSize = right - left + 1;
                        minLeft = left;
                        minRight = right;
                    }
                    c = s.charAt(left);
                    if (help[c] == 0) {
                        count++;
                    }
                    help[c]++;
                    left++;
                }
                right++;
            }
            return minSize > s.length() ? "" : s.substring(minLeft, minRight + 1);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



