package com.haa.algorithm;


public class 两数之和2 {
    /*
    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    双指针
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start = 0,end = n-1;
        while(start<end){
            if(numbers[start]+numbers[end]==target){
                return new int[]{start+1,end+1};
            }

            else if(numbers[start]+numbers[end]<target)
                start++;
            else if(numbers[start]+numbers[end]>target)
                end--;
        }
        return null;

    }
}
