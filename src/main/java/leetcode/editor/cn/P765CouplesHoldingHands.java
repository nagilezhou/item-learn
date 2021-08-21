//There are n couples sitting in 2n seats arranged in a row and want to hold han
//ds.
//
// The people and seats are represented by an integer array row where row[i] is
//the ID of the person sitting in the ith seat. The couples are numbered in order,
// the first couple being (0, 1), the second couple being (2, 3), and so on with t
//he last couple being (2n - 2, 2n - 1).
//
// Return the minimum number of swaps so that every couple is sitting side by si
//de. A swap consists of choosing any two people, then they stand up and switch se
//ats.
//
//
// Example 1:
//
//
//Input: row = [0,2,1,3]
//Output: 1
//Explanation: We only need to swap the second (row[1]) and third (row[2]) perso
//n.
//
//
// Example 2:
//
//
//Input: row = [3,2,0,1]
//Output: 0
//Explanation: All couples are already seated side by side.
//
//
//
// Constraints:
//
//
// 2n == row.length
// 2 <= n <= 30
// n is even.
// 0 <= row[i] < 2n
// All the elements of row are unique.
//
// Related Topics 贪心 深度优先搜索 广度优先搜索 并查集 图
// 👍 273 👎 0

package leetcode.editor.cn;

//Java：Couples Holding Hands 并查集
// 2021-08-21 review 1
public class P765CouplesHoldingHands {
    public static void main(String[] args) {
        Solution solution = new P765CouplesHoldingHands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] p = new int[70];

        void union(int a, int b) {
            p[find(a)] = p[find(b)];
        }

        int find(int x) {
            if (p[x] != x) { p[x] = find(p[x]); }
            return p[x];
        }

        public int minSwapsCouples(int[] row) {
            int n = row.length;
            int m = n / 2;
            for (int i = 0; i < m; i++) { p[i] = i; }
            for (int i = 0; i < n; i += 2) { union(row[i] / 2, row[i + 1] / 2); }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (i == find(i)) { cnt++; }
            }
            return m - cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



