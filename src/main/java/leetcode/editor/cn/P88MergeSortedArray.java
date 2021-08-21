//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array.
//
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. You may assume that nums1 has a size equal to m + n such that it has enough s
//pace to hold additional elements from nums2.
//
//
// Example 1:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
// Example 2:
// Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//
//
// Constraints:
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 942 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：Merge Sorted Array 数组+双指针
// 2021-08-01 review 1
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        int[] nums1 = new int[] {0};
        solution.merge(nums1, 0, new int[] {1}, 1);
        System.out.println(Arrays.toString(nums1));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (nums1 == null || nums2 == null) {
                return;
            }
            int last = m + n - 1;
            m--;
            n--;
            while (m >= 0 && n >= 0){
                nums1[last--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }
            while (n >= 0){
                nums1[last--] = nums2[n--];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



