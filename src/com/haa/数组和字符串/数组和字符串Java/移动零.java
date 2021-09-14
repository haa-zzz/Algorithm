package com.haa.数组和字符串.数组和字符串Java;

public class 移动零 {
    /*
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    /*
    分析:双指针，一个指针j用于遍历数组，一个指针i指向当前遍历位置移动零后最后一个非零元素的索引位置，
    当nums[j] != 0分两种情况：
        1.i==j，说明前面没有非零元素，直接i++,j++
        2.i!=j,交换nums[i]与nums[j]的值后，i++,j++
     */
    public void moveZeroes(int[] nums) {

        int i = 0;
        int len = nums.length;
        for(int j = 0; j < len; j++){

            if(nums[j] != 0){
                if(i!=j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }else{
                    i++;
                }

            }
        }

    }
}
