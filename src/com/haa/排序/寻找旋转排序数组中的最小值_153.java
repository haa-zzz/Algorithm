package com.haa.排序;

import java.util.Arrays;

public class 寻找旋转排序数组中的最小值_153 {
    /*
        假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
        请找出其中最小的元素。
     */
    /*
    方法：二分查找
        因为是排序后的数组经旋转后得到的，可以考虑用二分查找的思想

        对于中间值 mid有两种可能：
            1.如果 midValue < highValue, 说明最小值在 [low,mid] 这个区间,应该让 high = mid
            2.否则，说明 midValue > highValue, 最小值在 [mid+1,high]这个区间,应该让low = mid+1

        这样一直逼近，最后left == high == 最小值

        复杂度分析：
        时间复杂度O(logN)
        空间复杂度O(1)
     */
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;

        while(low < high){

            int mid = low + (high - low) / 2;

            if(nums[mid] < nums[high]){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return nums[low];
    }
}
