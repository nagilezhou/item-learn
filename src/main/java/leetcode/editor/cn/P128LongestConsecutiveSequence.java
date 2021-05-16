//Given an unsorted array of integers nums, return the length of the longest con
//secutive elements sequence.
//
//
// Example 1:
//
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
//
//
// Example 2:
//
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 104
// -109 <= nums[i] <= 109
//
//
//
//Follow up: Could you implement the O(n) solution? Related Topics 并查集 数组
// 👍 765 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//Java：Longest Consecutive Sequence
public class P128LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).distinct().boxed().collect(Collectors.toSet());
        int res = 0;
        while (!set.isEmpty()){
            int cur = set.iterator().next();
            set.remove(cur);
            int prev = cur - 1;
            int next = cur + 1;
            while (set.contains(prev)){
                set.remove(prev--);
            }
            while (set.contains(next)){
                set.remove(next++);
            }
            res  = Math.max(res, next - prev - 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



