package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * @author nagile_zhou
 * @date Created by moxu at 2021/5/1
 * 桶排序
 */
public class BucketSort {
    // 插入排序
    static void insertSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int p = a[i];
            insert(a, i, p);
        }
    }

    static void insert(int[] a, int index, int x) {
        // 元素插入数组a[0:index-1]
        int i;
        for (i = index - 1; i >= 0 && x < a[i]; i--) {
            a[i + 1] = a[i];
        }
        a[i + 1] = x;
    }

    private static void bucketSort(int[] nums) {
        // 10个桶
        int m = 10;
        int n = nums.length;
        // 用于存放每个桶中的元素个数
        int[] bucketNums = new int[m];
        // 构造一个二维数组b，用来存放A中的数据,这里的B相当于很多桶，B[i][]代表第i个桶
        int[][] buckets = new int[m][n];

        for (int num : nums) {
            int bucket = num / 10;
            // B[0][]中存放A中进行A[i]/10运算后高位为0的数据，同理B[1][]存放高位为1的数据
            buckets[bucket][bucketNums[bucket]] = num;
            // 用来计数二维数组中列中数据的个数，也就是桶A[i]中存放数据的个数
            bucketNums[bucket]++;
        }
        System.out.println("每个桶内元素个数：");
        System.out.println(Arrays.toString(bucketNums));

        System.out.println("数据插入桶后，桶内未进行排序前的结果为：");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(buckets[i]));
        }

        System.out.println("对每个桶进行插入排序，结果为：");
        // 下面使用直接插入排序对这个二维数组进行排序,也就是对每个桶进行排序
        for (int i = 0; i < m; i++) {
            // 下面是对具有数据的一列进行直接插入排序，也就是对B[i][]这个桶中的数据进行排序
            if (bucketNums[i] != 0) {
                // 插入排序
                for (int j = 1; j < bucketNums[i]; j++) {
                    int p = buckets[i][j];
                    int k;
                    for (k = j - 1; k >= 0 && p < buckets[i][k]; k--) {
                        buckets[i][k + 1] = buckets[i][k];
                    }
                    buckets[i][k + 1] = p;
                }
            }
        }

        // 输出排序过后的顺序
        for (int i = 0; i < 10; i++) {
            if (bucketNums[i] != 0) {
                for (int j = 0; j < bucketNums[i]; j++) {
                    System.out.print(buckets[i][j] + " ");
                }
            }
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 45, 34, 2, 78, 67, 34, 56, 98};
        bucketSort(arr);
    }
}
