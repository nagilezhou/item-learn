//For some fixed n, an array nums is beautiful if it is a permutation of the int
//egers 1, 2, ..., n, such that:
//
// For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i]
// + nums[j].
//
// Given n, return any beautiful array nums. (It is guaranteed that one exists.)
//
//
//
//
// Example 1:
//
//
//Input: n = 4
//Output: [2,1,4,3]
//
//
//
// Example 2:
//
//
//Input: n = 5
//Output: [3,1,2,5,4]
//
//
//
//
// Note:
//
//
// 1 <= n <= 1000
//
//
//
//
//
// Related Topics 分治算法
// 👍 128 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：Beautiful Array 分治
// 2021-08-21 review 1
public class P932BeautifulArray {
    public static void main(String[] args) {
        Solution solution = new P932BeautifulArray().new Solution();
        System.out.println(Arrays.toString(solution.beautifulArray(4)));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, int[]> memory = new HashMap();

        public int[] beautifulArray(int n) {
            int[] temp = memory.get(n);
            if (temp != null) { return temp; }

            int[] result = new int[n];

            int i = 0; // result数组的访问下标 这里使用ArrayList更简洁 但是性能略差

            if (n != 1) {
                // 这里注意哈 (n + 1) / 2 + n / 2 = n 整数除法有个向下取整
                // 所以当n为奇数时 左半区元素比右边要多一个 习惯就好
                for (int num : beautifulArray((n + 1) / 2)) { result[i++] = num * 2 - 1; }

                for (int num : beautifulArray(n / 2)) { result[i++] = num * 2; }
            } else { result[0] = 1; }
            // 之所以 n != 1放前面 是因为 当记忆化之后 这个else几乎不会运行到 所以放前面 每次用不到还多运行一次比较指令 浪费性能：） 你还可以优雅一点 一开始想办法给memory添加这个记录 那也可

            memory.put(n, result);
            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



