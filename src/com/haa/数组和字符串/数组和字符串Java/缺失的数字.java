package com.haa.数组和字符串.数组和字符串Java;

public class 缺失的数字 {
    /*
    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     */

    /*
     *  二分查找
     */
    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0;
            int right = nums.length -1;
            if(right < 0) return  0;
            while(left <= right) {
                int mid = left + (right-left) / 2;
                //当前值和下标相同， 说明左边肯定没有缺失的
                if(mid == nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
            return left;
        }
    }
}
