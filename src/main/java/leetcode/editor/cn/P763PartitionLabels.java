//A string s of lowercase English letters is given. We want to partition this st
//ring into as many parts as possible so that each letter appears in at most one p
//art, and return a list of integers representing the size of these parts.
//
//
//
// Example 1:
//
//
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it split
//s s into less parts.
//
//
//
//
// Note:
//
//
// s will have length in range [1, 500].
// s will consist of lowercase English letters ('a' to 'z') only.
//
//
//
// Related Topics 贪心算法 双指针
// 👍 504 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：Partition Labels
public class P763PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new P763PartitionLabels().new Solution();
        System.out.println(solution.partitionLabels("eaaaabaaec"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[][] helps = new int[26][2];
            for(int[] help : helps){
                Arrays.fill(help, -1);
            }
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (helps[index][0] == -1) {
                    helps[index][0] = i;
                }else {
                    helps[index][1] = i;
                }
            }
            Arrays.sort(helps, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
            int end = -2;
            List<Integer> res = new ArrayList<>();
            for(int[] help : helps){
                if(help[0] == -1){
                    continue;
                }
                if(help[0] > end){
                    //begin = help[0];
                    if(end  == -2){
                        end = help[1] == -1 ? help[0] : help[1];
                        continue;
                    }
                    res.add(end);
                    end = help[1] == -1 ? help[0] : help[1];
                    continue;
                }
                if(help[0] < end && help[1] > end){
                    end = help[1] == -1 ? help[0] : help[1];
                }
            }
            res.add(end);
            List<Integer> res2 = new ArrayList<>();
            int num = -1;
            for(int a : res){
                if(num == -1){
                    res2.add(a + 1);
                }else {
                    res2.add(a - num);
                }
                num = a;
            }
            return res2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



