package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * @author nagile_zhou
 * @date Created by moxu at 2021/5/1
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr,j,j-1);
                j--;
            }
        }
    }

}
