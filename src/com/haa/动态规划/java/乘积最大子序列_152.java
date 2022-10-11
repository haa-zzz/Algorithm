package com.haa.动态规划.java;

public class 乘积最大子序列_152 {
    /*
    给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积
     */
    /*
    分析：动态规划
        定义dp数组，dp[i]表示以下标i结尾的最大值，那么dp[i] = Math.max( dp[i-1]*nums[i] , nums[i])
            但是这样做会漏掉这样一些情况：eq (3,-1,2,-2)  因为负负得正这种情况没有考虑进去
        解决办法：
            定义两个dp数组， dpMax[]和dpMin[],前者用来维护当前最大值，后者用来维护当前最小值
            那么dpMax[i] = max( dpMax[i-1]*nums[i] , nums[i] , dpMin[i-1] * nums[i])
                dpMin[i] = min( dpMin[i-1] * nums[i] , nums[i] , dpMax[i-1] * nums[i])
             这样就把两种情况都考虑进去了。
        时间复杂度O(N)
        空间复杂度O(N)
     */
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = dpMin[0] = nums[0];
        for(int i = 1; i < n; i++){
            dpMax[i] = Math.max(dpMax[i-1]*nums[i],Math.max(nums[i] , dpMin[i-1]*nums[i]));
            dpMin[i] = Math.min(dpMin[i-1]*nums[i], Math.min(nums[i] , dpMax[i-1]*nums[i]));
            ans = Math.max(ans,dpMax[i]);
        }
        return ans;
    }
    /*
    空间优化：
     */
    public int maxProduct1(int[] nums) {
        int ans = nums[0];
        int n = nums.length;
        int dpMax;
        int dpMin ;
        dpMax = dpMin = nums[0];
        for(int i = 1; i < n; i++){
            int lastMax = dpMax;
            dpMax = Math.max(dpMax*nums[i],Math.max(nums[i] , dpMin*nums[i]));
            dpMin = Math.min(dpMin*nums[i], Math.min(nums[i] , lastMax*nums[i]));
            ans = Math.max(ans,dpMax);
        }
        return ans;
    }
}
