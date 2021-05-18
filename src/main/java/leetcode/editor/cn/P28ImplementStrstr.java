//Implement strStr().
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack.
//
// Clarification:
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview.
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf().
//
//
// Example 1:
// Input: haystack = "hello", needle = "ll"
//Output: 2
// Example 2:
// Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// Example 3:
// Input: haystack = "", needle = ""
//Output: 0
//
//
// Constraints:
//
//
// 0 <= haystack.length, needle.length <= 5 * 104
// haystack and needle consist of only lower-case English characters.
//
// Related Topics 双指针 字符串
// 👍 899 👎 0

package leetcode.editor.cn;
//Java：Implement strStr()
public class P28ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        // 分别读取原串和匹配串的长度
        int n = haystack.length(), m = needle.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        haystack = " " + haystack;
        needle = " " + needle;

        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) {
                j++;
            }
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) {
                j++;
            }
            // 整一段匹配成功，直接返回下标
            if (j == m) {
                return i - m;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



