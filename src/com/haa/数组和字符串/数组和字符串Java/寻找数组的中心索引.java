package com.haa.数组和字符串.数组和字符串Java;

import java.util.Arrays;

public class 寻找数组的中心索引 {
    /*
    给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
    数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
    如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
    注意：中心索引可能出现在数组的两端。
     */
    /*
    方法：前缀和
        首先记全部元素和为sum_right，遍历数组，动态改变当前索引位置对应的左右和，判断左右和是否相等，如果相等直接返回
        时间复杂度O(N)
        空间复杂度O(1)
     */
    public int pivotIndex(int[] nums) {

        int sum_right = Arrays.stream(nums).sum();          //求和
        int sum_left = 0;
        for(int i = 0; i < nums.length; i++){
            if(i!=0){
                sum_left+=nums[i-1];
            }
            sum_right-=nums[i];
            if(sum_left == sum_right){
                return i;
            }

        }
        return -1;
    }
}
