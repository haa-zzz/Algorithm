package com.haa.排序;

public class 寻找旋转排序数组中的最小值II_154 {
    /*
    已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7]
        在变化后可能得到：
        若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
        若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
        注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
        给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
        请你找出并返回数组中的 最小元素 。
     */
    /*
    分析：这道题相对于寻找旋转排序数组中的最小值主要增加了两点难度：
        1.数组中可能存在重复元素
        2.旋转次数不一定，可能经过n次旋转后，数组还是有序的

        方法：二分查找

         对于索引为mid(中间)对应的值有三种可能：

            1.如果 midValue < highValue, 说明最小值在 [low,mid] 这个区间,应该让 high = mid
            2.如果 midValue > highValue, 说明最小值在 [mid+1,high]这个区间,应该让low = mid+1
            3.如果 midValue == lowValue, 此时无法判断最小值在哪个区间 , 可以让 high-1(因为即使highValue是最小值，它还有一个替代品mid)
        这样一直逼近，最后left == high == 最小值

        注意：一定要和最后的元素比较，(不能和最左边的元素比较)

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
            }else if(nums[mid] > nums[high]){
                low = mid+1;
            }else{
                high--;
            }

        }
        return nums[low];
    }


}
