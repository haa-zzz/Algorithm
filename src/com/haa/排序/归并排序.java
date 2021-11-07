package com.haa.排序;

public class 归并排序 {

    /*
    将一个大的无序数组有序，我们可以把大的数组分成两个，然后对这两个数组分别进行排序，之后在把这两个数组合并成一个有序的数组。
    由于两个小的数组都是有序的，所以在合并的时候是很快的。
     */
    void mergeSort(int[] arr,int left,int right){
        if( left < right-1 ){
            //对数组进行分割
            int mid = left + ( right-left+1 )/2;
            //对左半部分进行排序
            mergeSort(arr,left,mid);
            //对右半部分进行排序
            mergeSort(arr,mid,right);
            //进行合并
            merge(arr,left,mid,right);
        }
    }
    private void merge(int[] arr, int left, int mid, int right) {
        int[] a = new int[right-left];
        int i = left;
        int j = mid;
        int k = 0;
        while(i < mid && j < right){
            if(arr[i] < arr[j]){
                a[k++] = arr[i++];
            }else{
                a[k++] = arr[j++];
            }
        }
        while(i < mid)  a[k++] = arr[i++];
        while(j<right) a[k++] = arr[j++];
        // 把临时数组复制到原数组
        for (i = 0; i < k; i++) {
            arr[left++] = a[i];
        }
    }

}
