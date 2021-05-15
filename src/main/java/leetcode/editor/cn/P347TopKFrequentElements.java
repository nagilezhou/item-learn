//Given an integer array nums and an integer k, return the k most frequent eleme
//nts. You may return the answer in any order.
//
//
// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2:
// Input: nums = [1], k = 1
//Output: [1]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
//
//
//
// Follow up: Your algorithm's time complexity must be better than O(n log n), w
//here n is the array's size.
// Related Topics 堆 哈希表
// 👍 734 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：Top K Frequent Elements
public class P347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        Arrays.stream(solution.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)).forEach(System.out::print);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums == null || k <= 0 || nums.length < k) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
            for (Integer key : map.keySet()) {
                if (heap.size() < k) {
                    heap.add(key);
                } else if (map.get(key) > map.get(heap.peek())) {
                    heap.remove();
                    heap.add(key);
                }
            }
            return heap.stream().mapToInt(Integer::valueOf).toArray();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



