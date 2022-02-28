//You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elem
//ents to the right of nums[i].
//
//
// Example 1:
//
//
//Input: nums = [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
//
//
// Example 2:
//
//
//Input: nums = [-1]
//Output: [0]
//
//
// Example 3:
//
//
//Input: nums = [-1,-1]
//Output: [0,0]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序
// 👍 750 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Count of Smaller Numbers After Self
public class P315CountOfSmallerNumbersAfterSelf{
    public static void main(String[] args) {
        Solution solution = new P315CountOfSmallerNumbersAfterSelf().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int len = nums.length;
            if (len == 0) {
                return result;
            }

            int[] temp = new int[len];
            int[] res = new int[len];

            // 索引数组，作用：归并回去的时候，方便知道是哪个下标的元素
            int[] indexes = new int[len];
            for (int i = 0; i < len; i++) {
                indexes[i] = i;
            }
            mergeAndCountSmaller(nums, 0, len - 1, indexes, temp, res);

            // 把 int[] 转换成为 List<Integer>，没有业务逻辑
            for (int i = 0; i < len; i++) {
                result.add(res[i]);
            }
            return result;
        }

        /**
         * 针对数组 nums 指定的区间 [left, right] 进行归并排序，在排序的过程中完成统计任务
         *
         * @param nums
         * @param left
         * @param right
         */
        private void mergeAndCountSmaller(int[] nums, int left, int right, int[] indexes, int[] temp, int[] res) {
            if (left == right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeAndCountSmaller(nums, left, mid, indexes, temp, res);
            mergeAndCountSmaller(nums, mid + 1, right, indexes, temp, res);

            // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
            if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
                return;
            }
            mergeOfTwoSortedArrAndCountSmaller(nums, left, mid, right, indexes, temp, res);
        }

        /**
         * [left, mid] 是排好序的，[mid + 1, right] 是排好序的
         *
         * @param nums
         * @param left
         * @param mid
         * @param right
         * @param indexes
         * @param temp
         * @param res
         */
        private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int left, int mid, int right, int[] indexes, int[] temp, int[] res) {
            for (int i = left; i <= right; i++) {
                temp[i] = indexes[i];
            }

            int i = left;
            int j = mid + 1;
            for (int k = left; k <= right; k++) {
                if (i > mid) {
                    indexes[k] = temp[j];
                    j++;
                } else if (j > right) {
                    indexes[k] = temp[i];
                    i++;
                    res[indexes[k]] += (right - mid);
                } else if (nums[temp[i]] <= nums[temp[j]]) {
                    // 注意：这里是 <= ，保证稳定性
                    indexes[k] = temp[i];
                    i++;
                    res[indexes[k]] += (j - mid - 1);
                } else {
                    indexes[k] = temp[j];
                    j++;
                }
            }
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}



