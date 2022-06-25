package com.haa.二分查找;

public class 搜索旋转排序数组 {
    /*
    整数数组 nums 按升序排列，数组中的值 互不相同 。
    在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
    使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
    例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。给你 旋转后 的数组 nums 和一个整数 target ，
    如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
     */
    /*
    方法：二分查找
        每次找一个中间值把数组一分为二，其中一个一定是有序的，另一个可能有序，可能无序。先在有序的部分用首尾值来判断目标值是否这个范围内，
        在就保留这一部分，否则就舍弃这一部分，保留另一部分。这样一直二分下去。
        时间复杂度O(log n)
        空间复杂度O(1)
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0 , right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < nums[right]){      //右边有序
                if( target > nums[mid] && target <= nums[right] ){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{                                  //左边有序
                if( target >= nums[left] && target < nums[mid] ){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }

        return -1;

    }
}
