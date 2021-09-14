package com.haa.数组和字符串.数组和字符串Java;

public class 删除排序数组中的重复项 {
    /*
    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    /*
    双指针，指针i用于遍历数组，指针j用于记录删除后的数组的最后一个元素的索引，即最后的返回就是j+1
    在每一次遍历时只要nums[i] != nums[j]就意味着找到新元素了，把这个新元素加入到删除后的数组
    时间复杂度O(N)
    空间复杂度O(1)
     */
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int length = nums.length;
        if(length==0)
            return 0;
        for(int i = 1; i < length; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

}
