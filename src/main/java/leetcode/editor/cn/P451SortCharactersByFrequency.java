//Given a string s, sort it in decreasing order based on the frequency of charac
//ters, and return the sorted string.
//
//
// Example 1:
//
//
//Input: s = "tree"
//Output: "eert"
//Explanation: 'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid a
//nswer.
//
//
// Example 2:
//
//
//Input: s = "cccaaa"
//Output: "aaaccc"
//Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
//answer.
//Note that "cacaca" is incorrect, as the same characters must be together.
//
//
// Example 3:
//
//
//Input: s = "Aabb"
//Output: "bbAa"
//Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 5 * 105
// s consists of English letters and digits.
//
// Related Topics 堆 哈希表
// 👍 252 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

import javafx.util.Pair;

//Java：Sort Characters By Frequency
public class P451SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new P451SortCharactersByFrequency().new Solution();
        System.out.println(solution.frequencySort("tree"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            int[] nums = new int[128];
            for (int i = 0; i < s.length(); i++) {
                nums[s.charAt(i)] += 1;
            }
            PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
            for (int i = 0; i < nums.length; i++) {
                heap.offer(new Pair<>(i, nums[i]));
            }
            StringBuilder res = new StringBuilder();
            while (!heap.isEmpty()){
                Pair<Integer, Integer> pair = heap.poll();
                for(int i = 0; i < pair.getValue(); i++){
                    res.append((char) pair.getKey().intValue());
                }
            }
            return res.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



