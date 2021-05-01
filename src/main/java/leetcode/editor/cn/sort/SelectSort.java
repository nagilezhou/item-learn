package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * @author nagile_zhou
 * @date Created by moxu at 2021/5/1
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
        selectSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }


    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
            }
        }
    }
}
