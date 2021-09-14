package com.haa.数组和字符串.数组和字符串Java;

public class 下一个排序 {
    /*
    实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须 原地 修改，只允许使用额外常数空间。
     */
    /*
    分析：
        从后向前查找相邻元素(i,j)，分三种情况
            1.如果nums[i] < nums[j]，说明i位置就是下一个排列要改变的位置，此时(j,n)一定是降序排列，
                从n开始向前检索，找到第一个大于nums[i]的元素，并和nums[i]作交换，然后吧(i+1,n)的元素升序排列(即直接反转)，结束。
            2.如果nums[i] >= nums[j]，直接i--，
            3.i == 0 && nums[i] >= nums[j],说明此时整个数组降序排列，吧它改为升序排列。

        时间复杂度O(N)
        空间复杂度O(1)
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length-1;
        for(int i = n-1; i >=0; i-- ){

            if(nums[i] < nums[i+1]){
                while (nums[i] >= nums[n]) n--;
                swap(nums,i,n);
                reverse(nums,i+1);  //反转
                return;
            }
        }
        reverse(nums,0);
    }
    private void reverse(int[] nums, int start) {
        int end = nums.length-1;
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    private static void swap(int[] array, int a, int b) {
        if (array[a] != array[b]) {
            array[a] = array[a] ^ array[b];
            array[b] = array[a] ^ array[b];
            array[a] = array[a] ^ array[b];
        }
    }

}
