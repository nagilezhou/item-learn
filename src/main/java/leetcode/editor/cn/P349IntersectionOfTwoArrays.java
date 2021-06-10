//Given two integer arrays nums1 and nums2, return an array of their intersectio
//n. Each element in the result must be unique and you may return the result in an
//y order.
//
//
// Example 1:
//
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
//
//
// Example 2:
//
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.
//
//
//
// Constraints:
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 375 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：Intersection of Two Arrays
public class P349IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for(int num : nums2){
            if(set.contains(num) && !res.contains(num)){
                res.add(num);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



