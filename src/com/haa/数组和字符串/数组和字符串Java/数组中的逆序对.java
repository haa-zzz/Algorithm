package com.haa.数组和字符串.数组和字符串Java;

public class 数组中的逆序对 {
    /*
    数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     */
    /*
    方法：
    归并排序，归并排序是从小数组到大数组，然后交换的过程，刚好符合找逆序对
    在合并两个子数组的时候， 如果位于后面的子数组元素小，那么说明这个数和前数组还未排序的每一个成逆序对。
        如 前数组【2，5，6，7】 后数组【1，3，4，8】 1<2 所以先插入1，又因为前数组是递增数组，所以1和前数组每一个都成逆序对
     */
    class Solution {
        int count;
        public int reversePairs(int[] nums) {
            mergeSort(nums, 0 , nums.length);
            return count;
        }
        //归并排序
        void mergeSort(int[] arr, int left, int right) {
            if(left < right - 1) {
                //找中间节点
                int mid = left + (right - left) / 2;
                //排左边
                mergeSort(arr, left, mid);
                //排右边
                mergeSort(arr, mid, right);
                //合并左右两个有序数组
                merge(arr, left, mid, right);
            }
        }
        void merge(int[] arr, int left, int mid, int right) {
            int[] newArr = new int[right - left];
            int i = left;
            int j = mid;
            int k = 0;
            //开始往新数组中插入
            while(i < mid && j < right) {
                if(arr[i] <= arr[j]) {  //前数组小，直接插入前数组元素，更新下标
                    newArr[k++] = arr[i++];
                } else {    //后数组元素小，说明这个元素小于前数组要排序的每一个
                    newArr[k++] = arr[j++];
                    count += mid - i;   //添加逆序对
                }
            }
            while(j < right) newArr[k++] = arr[j++];
            while(i < mid) newArr[k++] = arr[i++];
            i = left;
            for(j = 0; j < k; j++) {
                arr[i++] = newArr[j];
            }
        }
    }
}
