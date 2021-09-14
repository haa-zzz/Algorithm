package com.haa.数组和字符串.数组和字符串Java;

public class 数组拆分2 {
    /*
    给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。

    函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足
    1 <= answer[0] < answer[1] <= numbers.length 。

    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     */
    /*
    反析：双指针，数组是拍好序的，可用双指针，一个指向头(i = 0)，一个指向尾(j = numbers.length-1 )，判断当前的和，如果大了，j--,
        如果小了，i++，

        时间复杂度O(N)
        空间复杂度O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int nums = numbers[i]+numbers[j];
            if(nums > target){
                j--;
            }
            else if(nums < target){
                i++;
            }
            else{
                return new int[]{numbers[i],numbers[j]};
            }

        }
        return null;
    }

}
