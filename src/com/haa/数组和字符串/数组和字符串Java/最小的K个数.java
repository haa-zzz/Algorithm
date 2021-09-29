package com.haa.数组和字符串.数组和字符串Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {
    /*
    输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     */
    /*
    方法1.
    直接将 arr 排序，然后取前 k 个返回。
    时间复杂度 O(n * Log(n) )
    空间复杂度 O( log n )
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] min = new int[k];
        Arrays.sort(arr);
        for(int i = 0; i < k; i++){
            min[i] =  arr[i];
        }
        return min;
    }
    /*
    方法2.使用堆
        使用大顶堆维护数组的前K个最小值。首先将前K个数插入到大顶堆中，随后从第 K+1 个数开始遍历，如果当前的数小于堆顶，就把堆顶弹出，把这个数插入。
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] min = new int[k];
        if(k == 0) return min;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 0; i < arr.length; i++){
            if(i < k){
                queue.offer(arr[i]);
            }else if(arr[i] < queue.peek() ) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for(int i = 0; i < k; i++){
            min[i] = queue.poll();
        }
        return min;
    }
}
