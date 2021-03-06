package leetcode.editor.cn.sort;

/**
 * @author nagile_zhou
 * @date Created by moxu at 2021/5/1
 * 基数排序
 */
public class RadixSorting {

    // d为数据长度
    private static void radixSorting(int[] arr, int d) {
        //arr = countingSort(arr, 0);
        for (int i = 0; i < d; i++) {
            arr = countingSort(arr, i); // 依次对各位数字排序（直接用计数排序的变体）
            print(arr, i + 1, d);
        }
    }

    // 把每次按位排序的结果打印出来
    static void print(int[] arr, int k, int d) {
        if (k == d) { System.out.println("最终排序结果为："); } else { System.out.println("按第" + k + "位排序后，结果为："); }
        for (int t : arr ) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    // 利用计数排序对元素的每一位进行排序
    private static int[] countingSort(int[] arr, int index) {
        int k = 9;
        int[] b = new int[arr.length];
        int[] c = new int[k + 1]; //这里比较特殊：数的每一位最大数为9

        for (int i = 0; i < k; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int d = getBitData(arr[i], index);
            c[d]++;
        }
        for (int i = 1; i <= k; i++) {
            c[i] += c[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int d = getBitData(arr[i], index);
            b[c[d] - 1] = arr[i];//C[d]-1 就代表小于等于元素d的元素个数，就是d在B的位置
            c[d]--;
        }
        return b;
    }

    // 获取data指定位的数
    private static int getBitData(int data, int index) {
        while (data != 0 && index > 0) {
            data /= 10;
            index--;
        }
        return data % 10;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {326, 453, 608, 835, 751, 435, 704, 690, 88, 79,
            79};//{ 333, 956, 175, 345, 212, 542, 99, 87 };
        System.out.println("基数排序前为：");
        for (int t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
        radixSorting(arr, 4);
    }

}
