package com.haa.数组和字符串.数组和字符串Java;

import java.util.Arrays;

public class 数组拆分1 {
    /*
    给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
    使得从 1 到 n 的 min(ai, bi) 总和最大。
    返回该 最大总和 。
     */
    /*
    分析：当把数组从小到大排序后，依次最小的两个一组，最后的总和最大
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i+=2){
            sum+=nums[i];
        }

        return sum;
    }
}
