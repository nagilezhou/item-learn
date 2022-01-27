//(This problem is an interactive problem.)
//
// You may recall that an array arr is a mountain array if and only if:
//
//
// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
//
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//
//
//
//
// Given a mountain array mountainArr, return the minimum index such that mounta
//inArr.get(index) == target. If such an index does not exist, return -1.
//
// You cannot access the mountain array directly. You may only access the array
//using a MountainArray interface:
//
//
// MountainArray.get(k) returns the element of the array at index k (0-indexed).
//
// MountainArray.length() returns the length of the array.
//
//
// Submissions making more than 100 calls to MountainArray.get will be judged Wr
//ong Answer. Also, any solutions that attempt to circumvent the judge will result
// in disqualification.
//
//
// Example 1:
//
//
//Input: array = [1,2,3,4,5,3,1], target = 3
//Output: 2
//Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum
// index, which is 2.
//
// Example 2:
//
//
//Input: array = [0,1,2,4,2,1], target = 3
//Output: -1
//Explanation: 3 does not exist in the array, so we return -1.
//
//
//
// Constraints:
//
//
// 3 <= mountain_arr.length() <= 104
// 0 <= target <= 109
// 0 <= mountain_arr.get(index) <= 109
//
// Related Topics 数组 二分查找 交互
// 👍 141 👎 0

package leetcode.editor.cn;
//Java：Find in Mountain Array
public class P1095FindInMountainArray{
    public static void main(String[] args) {
        Solution solution = new P1095FindInMountainArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int peakIndex = findMountainTop(mountainArr, 0, len - 1);
        int res = findSortedArray(mountainArr, 0, peakIndex, target);
        if (res != -1) {
            return res;
        }
        return findReverseArray(mountainArr, peakIndex + 1, len - 1, target);
    }

    /**
     * 在 [left..right] 查找 target 的下标
     *
     * @param mountainArr
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int findReverseArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mountainArr.get(mid) > target) {
                // 下一轮搜索区间 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间 [mid..right]
                // [left..right(mid)]
                left = mid;
            }
        }

        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }

    /**
     * 在 [left..right] 查找 target 的下标
     *
     * @param mountainArr
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int findSortedArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                // 下一轮搜索区间 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left..mid]
                right = mid;
            }
        }

        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }

    /**
     * 在 [left..right] 查找山顶元素的下标
     *
     * @param mountainArr
     * @param left
     * @param right
     * @return
     */
    private int findMountainTop(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // 下一轮搜索区间 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left..mid]
                right = mid;
            }
        }
        // left == right
        return left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    interface MountainArray {
       int get(int index);
       int length();
  }

}



