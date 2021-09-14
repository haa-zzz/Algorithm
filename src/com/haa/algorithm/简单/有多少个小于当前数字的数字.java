package com.haa.algorithm.简单;

import java.util.Arrays;
import java.util.Comparator;

public class 有多少个小于当前数字的数字 {
    /*
    给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。
        2 <= nums.length <= 500
        0 <= nums[i] <= 100
     */
    /*
        方法一:快速排序，用一个二维数组储存这个数组，前一项存值，后一项存对应的下标，对第一项进行排序

     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] cur = new int[n][2];
        for(int i = 0; i < n; i++){
            cur[i][0] = nums[i];
            cur[i][1] = i;
        }
        Arrays.sort(cur,new Comparator<int[]>(){
            public int compare(int[] data1, int[] data2) {
                return data1[0] - data2[0];
            }
        });
        int[] arr = new int[n];
        int prev = -1;
        for(int i = 0; i < n; i++){
            if(prev==-1 || cur[i][0]!= cur[i-1][0]){
                prev = i;
            }
            arr[cur[i][1]] = prev;
        }
        return arr;
    }
    /*
    方法二：计数排序，由于0 <= nums[i] <= 100，我们可采用计数排序的方法进行排序


     */
    public int[] smallerNumbersThanCurrent1(int[] nums) {
       int[] cur = new int[101];
       int n = nums.length;
       for(int i = 0; i < n; i++){
           cur[nums[i]]++;
       }
       for(int i = 1; i < 100; i++){
           cur[i]+=cur[i-1];
       }
       int[] ret = new int[n];
       for(int i = 0; i < n; i++ ){
            ret[i] = nums[i]==0 ? 0:cur[nums[i]-1];
       }
       return ret;

    }






}
