//Given an array of integers numbers that is already sorted in ascending order,
//find two numbers such that they add up to a specific target number.
//
// Return the indices of the two numbers (1-indexed) as an integer array answer
//of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
//
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice.
//
//
// Example 1:
//
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
//
//
// Example 2:
//
//
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//
//
// Example 3:
//
//
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//
//
//
// Constraints:
//
//
// 2 <= numbers.length <= 3 * 104
// -1000 <= numbers[i] <= 1000
// numbers is sorted in increasing order.
// -1000 <= target <= 1000
// Only one valid answer exists.
//
// Related Topics 数组 双指针 二分查找
// 👍 512 👎 0

package leetcode.editor.cn;

//Java：Two Sum II - Input array is sorted
public class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if (numbers == null || numbers.length == 0) {
                return null;
            }
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target){
                    break;
                }else if(sum > target){
                    right--;
                }else {
                    left++;
                }
            }
            return new int[] {left + 1, right + 1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



