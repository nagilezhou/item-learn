package leetcode.editor.cn.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author nagile_zhou
 * @date Created by moxu at 2021/5/1
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,1};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }



    private static Random random = new Random();

    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(arr, left, randomIndex);
            int pivot = left;
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (arr[i] < arr[pivot]) {
                    j++;
                    // j 的初值为 left，先右移，再交换，小于 pivot 的元素都被交换到前面
                    swap(arr, i, j);
                }
            }
            // 在之前遍历的过程中，满足 nums[left + 1..j] < pivot，并且 nums(j..i) >= pivot
            swap(arr, pivot, j);
            quickSort2(arr, left, j - 1);
            quickSort2(arr, j + 1, right);
        }
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //获取枢纽值，并将其放在当前待处理序列末尾
            dealPivot(arr, left, right);
            //枢纽值被放在序列末尾
            int pivot = right - 1;
            //左指针
            int i = left;
            //右指针
            int j = pivot;
            while (i < j) {
                while (i < j && arr[i] < arr[pivot]) {
                    i++;
                }
                while (j > i  && arr[j] > arr[pivot]) {
                    j--;
                }
                swap(arr, i, j);
            }
            if (i < right) {
                swap(arr, i, pivot);
            }
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }


    public static void dealPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        swap(arr, right - 1, mid);
    }

    /**
     * 交换元素通用处理
     *
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
