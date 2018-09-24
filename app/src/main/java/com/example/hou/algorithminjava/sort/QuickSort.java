package com.example.hou.algorithminjava.sort;

/**
 * Created by hou on 2018/9/23.
 */

public class QuickSort {
    private QuickSort() {
    }

    private static class Holder {
        private static QuickSort sInstance = new QuickSort();  //单例
    }

    public static QuickSort getInsatnce() {
        return Holder.sInstance;
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {  //如果开始的位置大于等于末尾位置 就退出
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);   //选择一个位置分成两段

        quickSort(arr, startIndex, pivotIndex - 1);//每次分两段进行递归索引
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        int index = startIndex;    //此为挖出来的

        while (right >= left) {  //从右至左进行检索交换
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;

            }

            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right++;
                    break;
                }
                left++;
            }

        }

        arr[index] = pivot;
        return index;

    }

}
