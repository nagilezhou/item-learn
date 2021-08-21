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

//Java：Implement strStr() kmp字符串匹配
// 2021-07-31 review 1
public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        System.out.println(solution.strStr("abeababeabf", "aaabbbab"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /*
     *
     */
    class Solution {

        public int strStr(String haystack, String needle) {
            if (needle.isEmpty()) {
                return 0;
            }
            int n = haystack.length();
            int m = needle.length();

            int[] next = new int[m];
            for (int i = 1, j = 0; i < m; i++) {
                while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (needle.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }

            for (int i = 0, j = 0; i < n; i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    return i - m + 1;
                }
            }

            return -1;
        }

        //public int strStr2(String haystack, String needle) {
        //    int n = haystack.length(), m = needle.length();
        //    if (m == 0) {
        //        return 0;
        //    }
        //    int[] next = new int[m];
        //    for (int i = 1, j = 0; i < m; i++) {
        //        while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
        //            j = next[j - 1];
        //        }
        //        if (needle.charAt(i) == needle.charAt(j)) {
        //            j++;
        //        }
        //        next[i] = j;
        //    }
        //    for (int i = 0, j = 0; i < n; i++) {
        //        while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
        //            j = next[j - 1];
        //        }
        //        if (haystack.charAt(i) == needle.charAt(j)) {
        //            j++;
        //        }
        //        if (j == m) {
        //            return i - m + 1;
        //        }
        //    }
        //    return -1;
        //}

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



