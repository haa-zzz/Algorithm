package com.haa.algorithm.简单;

import java.util.Arrays;

public class 数组中重复的数字 {
    /*
    找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
    也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     */
    public int findRepeatNumber(int[] nums) {

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i+1]-nums[i]==0)
                return nums[i];
        }
        return 0;

    }
    /*
    原地置换:如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，
     */
    public int findRepeatNumber1(int[] nums) {

        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }


}
