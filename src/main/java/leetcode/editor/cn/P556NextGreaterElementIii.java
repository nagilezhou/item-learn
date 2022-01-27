//Given a positive integer n, find the smallest integer which has exactly the sa
//me digits existing in the integer n and is greater in value than n. If no such p
//ositive integer exists, return -1.
//
// Note that the returned integer should fit in 32-bit integer, if there is a va
//lid answer but it does not fit in 32-bit integer, return -1.
//
//
// Example 1:
// Input: n = 12
//Output: 21
// Example 2:
// Input: n = 21
//Output: -1
//
//
// Constraints:
//
//
// 1 <= n <= 231 - 1
//
// Related Topics 数学 双指针 字符串
// 👍 182 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Next Greater Element III
public class P556NextGreaterElementIii{
    public static void main(String[] args) {
        Solution solution = new P556NextGreaterElementIii().new Solution();
        System.out.println(solution.nextGreaterElement(42));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        char[] c = str.toCharArray();
        int[] nums = new int[c.length];
        for(int i = 0; i < c.length; i++){
            nums[i] = Integer.parseInt(String.valueOf(c[i]));
        }
        nextPermutation(nums);
        long res = 0;
        for(int num : nums){
            res = res * 10 +  num;
        }
        if(res > Integer.MAX_VALUE){
            return -1;
        }
        return (int)res == n ? -1 : (int)res;
    }


        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
                reverse(nums, i + 1);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}



