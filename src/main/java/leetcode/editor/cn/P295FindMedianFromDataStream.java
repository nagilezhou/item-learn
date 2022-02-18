//The median is the middle value in an ordered integer list. If the size of the
//list is even, there is no middle value and the median is the mean of the two mid
//dle values.
//
//
// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
//
//
// Implement the MedianFinder class:
//
//
// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data st
//ructure.
// double findMedian() returns the median of all elements so far. Answers within
// 10-5 of the actual answer will be accepted.
//
//
//
// Example 1:
//
//
//Input
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//Output
//[null, null, null, 1.5, null, 2.0]
//
//Explanation
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
//
//
//
// Constraints:
//
//
// -105 <= num <= 105
// There will be at least one element in the data structure before calling findM
//edian.
// At most 5 * 104 calls will be made to addNum and findMedian.
//
//
//
// Follow up:
//
//
// If all integer numbers from the stream are in the range [0, 100], how would y
//ou optimize your solution?
// If 99% of all integer numbers from the stream are in the range [0, 100], how
//would you optimize your solution?
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列）
// 👍 614 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：Find Median from Data Stream
public class P295FindMedianFromDataStream{
    public static void main(String[] args) {
        //Solution solution = new P295FindMedianFromDataStream().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

        // 大根堆 放小的数
        PriorityQueue<Integer> leftHeap;

        // 小根堆 放大的数
        PriorityQueue<Integer> rightHeap;

        public MedianFinder() {
            leftHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            rightHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        }

        public void addNum(int num) {
            if(rightHeap.isEmpty() || num > rightHeap.peek()){
                rightHeap.offer(num);
            }else{
                leftHeap.offer(num);
            }
            adjustHeap();
        }

        public double findMedian() {
            if(leftHeap.isEmpty() && rightHeap.isEmpty()){
                return (double)0;
            }
            if(leftHeap.size() == rightHeap.size()){
                return (leftHeap.peek() / 2.0  + rightHeap.peek() / 2.0);
            }else{
                return rightHeap.peek() * 1.0;
            }
        }

        private void adjustHeap(){
            while(leftHeap.size() > rightHeap.size()){
                rightHeap.offer(leftHeap.poll());
            }
            while(rightHeap.size() - leftHeap.size() > 1){
                leftHeap.offer(rightHeap.poll());
            }
        }


    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}



