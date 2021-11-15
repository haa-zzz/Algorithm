package com.haa.排序;

public class 快速排序 {
    /*
        首先选取一个枢轴,经过一次排序后将整段序列分为两个部分，使得数轴左侧都小于枢轴，右侧都大于枢轴；然后再递归的对这两个部分进行排序。
        时间复杂度 O(nlogn)
        空间复杂度O(logn)
     */
    void quickSort(int[] arr, int left, int right) {
        if (left < right - 1) {
            int pivot = partition(arr, left, right - 1);
            quickSort(arr, left, pivot);
            quickSort(arr, pivot + 1, right);
        }
    }
    private int partition(int[] arr, int low, int high) {
        int pivotKey = arr[low];
        while (low < high) {
            while (low < high && pivotKey <= arr[high]) {
                high--;
            }
            swap(arr,low,high);
            while (low < high && pivotKey >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
            swap(arr,low,high);
        }
        return low;
    }
    private void swap(int[] arr, int i, int j) {
        int num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
    }

    /*
    优化：1.三数取中法获取枢轴  2.优化不必要的交换  3.优化小数组的排序方案  4.优化递归过程：采用尾递归
     */
    void quickSortPro(int[] array, int left, int right){
        while (left < right-1){
            int pivot = partitionPro(array,left,right-1);
            quickSort(array,left,pivot);
            left = pivot+1;
        }
    }
    private  int partitionPro(int[] array, int low, int high) {
        //优化1.三数取中法选取中轴元素
        int mid = low + (high - low) / 2;
        if (array[low] > array[high])
            swap(array, low, high);
        if (array[mid] > array[high])
            swap(array, mid, high);
        if (array[mid] > array[low])
            swap(array, low, mid);
        //优化2. 优化不必要的交换
        int pivotKey = array[low];     //首先选最左边的元素记为中轴元素
        while (low < high) {
            while (low < high && array[high] >= pivotKey)
                high--;
            array[low] = array[high];       //采用替换而不是交换的方式进行操作
            while (low < high && array[low] <= pivotKey)
                low++;
            array[high] = array[low];       //采用替换而不是交换的方式进行操作
        }
        array[low] = pivotKey;              //将枢轴数值替换回array[low]
        return low;                         //返回枢轴所在位置
    }

}
