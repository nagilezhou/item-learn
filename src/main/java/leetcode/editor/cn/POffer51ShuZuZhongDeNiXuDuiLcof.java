//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序
// 👍 634 👎 0

package leetcode.editor.cn;
//Java：数组中的逆序对  LCOF
public class POffer51ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args) {
        Solution solution = new POffer51ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[]{7,8,3,10}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int count;
        public int reversePairs(int[] nums) {
            this.count = 0;
            merge(nums, 0, nums.length - 1);
            return count;
        }

        public void merge(int[] nums, int left, int right) {
            int mid = left + ((right - left) >> 1);
            if (left < right) {
                merge(nums, left, mid);
                merge(nums, mid + 1, right);
                mergeSort(nums, left, mid, right);
            }
        }

        public void mergeSort(int[] nums, int left, int mid, int right) {
            int[] temparr = new int[right - left + 1];
            int index = 0;
            int temp1 = left, temp2 = mid + 1;

            while (temp1 <= mid && temp2 <= right) {
                if (nums[temp1] <= nums[temp2]) {
                    temparr[index++] = nums[temp1++];
                } else {
                    //用来统计逆序对的个数
                    count += (mid - temp1 + 1);
                    temparr[index++] = nums[temp2++];
                }
            }
            //把左边剩余的数移入数组
            while (temp1 <= mid) {
                temparr[index++] = nums[temp1++];
            }
            //把右边剩余的数移入数组
            while (temp2 <= right) {
                temparr[index++] = nums[temp2++];
            }
            //把新数组中的数覆盖nums数组
            for (int k = 0; k < temparr.length; k++) {
                nums[k + left] = temparr[k];
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}



