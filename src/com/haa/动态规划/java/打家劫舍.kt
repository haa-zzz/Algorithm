package com.haa.动态规划.java

class 打家劫舍
/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
internal class Solution {

    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = Array(n){ IntArray(2) }

        dp[0][0] = 0
        dp[0][1] = nums[0]
        for( i in 1 until n){
            dp[i][0] = Math.max( dp[i-1][0] , dp[i-1][1] )
            dp[i][1] = dp[i-1][0] + nums[i]
        }
        return Math.max(dp[n-1][0], dp[n-1][1])

    }
}
/*
   无脑动态规划
   对于每一个房屋，都有两种状态   dp[i][0]:没被偷   dp[i][1]:被偷
   动态方程：
        当前房屋没偷的金额为前一家的两种状态的最大值
        dp[i][0] = Math.max( dp[i-1][0] , dp[i-1][1] )
        当前房屋被偷：则前一家已经没被偷
            dp[i][1] = dp[i-1][0] + nums[i]
   时间复杂度O(n)
   空间复杂度O(1)
   */
internal class Solution1 {
    fun rob(nums: IntArray): Int {
        var dp1 = 0
        var dp2 = nums[0]
        for (i in 1 until nums.size) {
            val money = dp1
            dp1 = Math.max(dp1, dp2)
            dp2 = money + nums[i]
        }
        return Math.max(dp1, dp2)
    }
}