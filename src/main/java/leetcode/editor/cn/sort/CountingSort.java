package leetcode.editor.cn.sort;

/**
 * @author nagile_zhou
 * @date Created by moxu at 2021/5/1
 * 计数排序
 */
public class CountingSort {
    // 类似bitmap排序
    public static void countSort(int[] a, int[] b, final int k) {
        // k>=n
        int[] c = new int[k + 1];
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }
        System.out.println("\n****************");
        System.out.println("计数排序第2步后,临时数组C变为：");
        for (int m : c) {
            System.out.print(m + " ");
        }

        for (int i = 1; i <= k; i++) {
            c[i] += c[i - 1];
        }
        System.out.println("\n计数排序第3步后,临时数组C变为：");
        for (int m : c) {
            System.out.print(m + " ");
        }
        for (int i = 0; i < a.length; i++) {
            b[c[a[i]] - 1] = a[i];//C[A[i]]-1 就代表小于等于元素A[i]的元素个数，就是A[i]在B的位置
            c[a[i]]--;
        }
        System.out.println("\n计数排序第4步后,临时数组C变为：");
        for (int n : c) {
            System.out.print(n + " ");
        }
        System.out.println("\n计数排序第4步后,数组B变为：");
        for (int t : b) {
            System.out.print(t + " ");
        }
        System.out.println();
        System.out.println("****************\n");
    }

    public static int getMaxNumber(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[] {2, 5, 3, 0, 2, 3, 0, 3};
        int[] b = new int[a.length];
        System.out.println("计数排序前为：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
            countSort(a, b, getMaxNumber(a));
        System.out.println("计数排序后为：");
        for (int value : b) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
