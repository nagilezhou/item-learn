//Given an integer array of size n, find all elements that appear more than ⌊ n/
//3 ⌋ times.
//
// Follow-up: Could you solve the problem in linear time and in O(1) space?
//
//
// Example 1:
//
//
//Input: nums = [3,2,3]
//Output: [3]
//
//
// Example 2:
//
//
//Input: nums = [1]
//Output: [1]
//
//
// Example 3:
//
//
//Input: nums = [1,2]
//Output: [1,2]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
//
// Related Topics 数组
// 👍 362 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Majority Element II 数组 摩尔投票
// 2021-08-14 review 1
public class P229MajorityElementIi {
    public static void main(String[] args) {
        Solution solution = new P229MajorityElementIi().new Solution();
        System.out.println(solution.majorityElement(new int[]{3,3}).toString());
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            int candidateOne = nums[0];
            int ballotOne = 0;
            int candidateTwo = nums[0];
            int ballotTwo = 0;
            for (int num : nums) {
                if(candidateOne == num){
                    ballotOne++;
                    continue;
                }
                if(candidateTwo == num){
                    ballotTwo++;
                    continue;
                }
                if(ballotOne == 0){
                    candidateOne = num;
                    ballotOne++;
                    continue;
                }
                if(ballotTwo == 0){
                    candidateTwo = num;
                    ballotTwo++;
                    continue;
                }
                ballotOne--;
                ballotTwo--;
            }

            ArrayList<Integer> res = new ArrayList<>();
            ballotOne = 0;
            ballotTwo = 0;
            for (int num : nums) {
                if (candidateOne == num) {
                    ballotOne++;
                } else if (candidateTwo == num) {
                    ballotTwo++;
                }
            }
            if (ballotOne > nums.length / 3) {
                res.add(candidateOne);
            }
            if (ballotTwo > nums.length / 3) {
                res.add(candidateTwo);
            }
            //ArrayList<Integer> res = new ArrayList<>();
            //res.add(candidateOne);
            //res.add(candidateTwo);
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



