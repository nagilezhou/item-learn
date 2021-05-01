package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * @author nagile_zhou
 * @date Created by moxu at 2021/5/1
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;//设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
