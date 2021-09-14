package com.haa.数组和字符串.数组和字符串Java;

public class 移除元素 {
    /*
    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

     */
    //方法1：遍历，用一个数slow记录修改数组的下标，由于不用管后面的元素，只要这个数不是val,修改当前值，slow++即可
    //时间复杂度O(N)
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=val){
                nums[slow]=nums[i];
                slow++;
            }
        }

        return slow;
    }
    /*
    方法2：双指针，用两个指针一个指头，一个指尾，当start <= end 是，对nums[start]做相应的判断
    时间复杂度O(N)
     */
    public int removeElement1(int[] nums, int val) {
        int start = 0,end = nums.length-1;
        while(start <= end){
            if(nums[start] == val ){
                if(nums[end]!=val){
                    nums[start] = nums[end];
                    start++;
                }
                end--;
            }else{
                start++;
                if(nums[end]==val){
                    end--;
                }
            }
        }
        return start;
    }
}
