package com.haa.动态规划.java;

public class 最大子序列 {
    /*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    /*
    方法：动态规划+标记
        用dp数组记录以第i个数结尾的最大连续子数组的和,用maxSum标记连续子数组的最大和，在填表的过程中，用这个数和dp[i]比较，取最大值。

        第 1 步：定义状态
            dp[i]: 表示第i个数结尾的最大连续子数组的和
        第 2 步: 思考状态转移方程
            如果之前的最大和+当前数字>当前数字，那么最大和就是之前的最大和+当前数字；否则，最大和就是当前数字
            dp[i] = Math.max(   dp[i-1] + nums[i],nums[i]);
        第 3 步: 考虑初始化
            看题目：找到一个具有最大和的连续子数组（子数组最少包含一个元素），所以
            dp[0] = nums[0]

        复杂度分析：
        时间复杂度 O(N)
        空间复杂度 O(N)
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //定义dp数组
        int[] dp = new int[n];
        //初始化
        dp[0] = nums[0];
        int maxSum = dp[0];     //标记子数组的最大和
        //填表
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(   dp[i-1] + nums[i],nums[i]);
            if(maxSum < dp[i]){     //更新最大和
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
    /*
     第 5 步: 考虑空间优化
        dp[i]的计算之和dp[i-1]有关，可以考虑进行空间优化

     复杂度分析：
        时间复杂度 O(N)
        空间复杂度 O(1)
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        //定义dp数组
        int dp;
        //初始化
        dp = nums[0];
        int maxSum = dp;     //标记子数组的最大和
        //填表
        for(int i = 1; i < n; i++){
            dp = Math.max(   dp + nums[i],nums[i]);
            if(maxSum < dp){     //更新最大和
                maxSum = dp;
            }
        }
        return maxSum;
    }

}
