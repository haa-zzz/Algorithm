package com.haa.数组和字符串.数组和字符串Java;

public class 在排序数组中查找数字1 {
    /*
    统计一个数字在排序数组中出现的次数。
    力抠：剑指 Offer 53 - I
     */
    class Solution {
        public int search(int[] nums, int target) {
            //二分查找
            if(nums.length == 0) return 0;
            int left = 0;
            int right = nums.length - 1;
            int ansL, ansR;
            //第一次二分查找左值
            while(left < right) {
                int mid = left + (right-left) / 2;
                if(nums[mid] >= target) {
                    right = mid;
                }  else {
                    left = mid+1;
                }
            }
            if(nums[left] != target) {
                return 0;
            }
            ansL = left;
            left = 0;
            right = nums.length - 1;
            //第二次二分查找右值
            while(left < right) {
                //注意细节，这里mid的取值要+1再除2：比如如果对于 nums[8,8],target = 8如果不处理
                int mid = left + 1 + (right-left) / 2;
                if(nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid -1 ;
                }
            }
            ansR = left;
            return ansR - ansL + 1;

        }
    }
}
