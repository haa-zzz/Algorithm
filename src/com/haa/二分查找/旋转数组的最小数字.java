package com.haa.二分查找;

import java.util.Arrays;

public class 旋转数组的最小数字 {
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
    例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     */
    /*
    一：暴力
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
     */

    /*
    所有变化点左侧元素 > 数组第一个元素
    所有变化点右侧元素 < 数组第一个元素
    二分法
            比如 4 5 6 7 1 2 3
            左排序数组 4 5 6 7
            右排序数组         1 2 3
            mid = i+(j-i)/2
            [mid] > [j]   组说明m在左排序数 旋转点一定在[m+1,j]内 即 i = m+1;
            [mid] < [j]   说明m在右排序数组 旋转点一定在[i,m]内 即 j = m;
            [mid] = [j]    无法判断 因此执行j--缩小范围
     */
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int mid = i+(j-i)/2;
            if( numbers[mid] > numbers[j]){
                i = mid+1;
            }else if(numbers[mid] < numbers[j]){
                j = mid;
            }else {
                j--;
            }
        }
        return numbers[i];
    }
}
