package com.haa.栈和队列;

public class 目标和 {
    /*
    给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 - 。
    对于数组中的任意一个整数，你都可以从 + 或 - 中选择一个符号添加在前面。
    返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     */
    /*
    方法一.递归的遍历全部的组合，如果最后的目标和和S相同，方法数+1
        时间复杂度O(2^N)
        空间复杂度O(N)
     */
    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        fun(nums,0,0,S);
        return count;
    }

    private void fun(int[] nums, int i, int sum, int s) {
        if(i == nums.length){
            if( sum == s ){
                count++;
            }
        }else {
            fun(nums,i+1,sum+nums[i],s);
            fun(nums,i+1,sum-nums[i],s);
        }
    }
    /*
    方法2.动态规划
        第 1 步：定义状态
            dp[i][j]: 表示用数字的前i个数组成和为j的方案数
        第 2 步：思考状态转移方程
            nums[i]这个元素可以执行 +/- ， 对应的dp[i][j]应该是执行这两个操作的和。
            dp[i][j] = dp[i-1][ j-nums[i] ] + dp[i-1][ j+nums[i] ]
            说明：因为考虑到和可能为负数，所以要开辟一个 sum * 2 + 1大小的数组(sum==数组和)
                用sum位置作为0号位置，0~sun-1作为负数的，sum+1~2*sum表示正数的
        第 3 步：考虑初始化
             if nums[0]!=0
                    dp[0][ sum + nums[0] ] = 1
                    dp[0][ sum - nums[0] ] = 1
             else
                    dp[0][ sum ] = 2         //这时加减都可以(注意以sum位置为0号位置)
        第 4 步：考虑输出
            最后的输出结果为 dp[length-1][sum+s]

        时间复杂度O( N * sum)
        空间复杂度O( N * sum)
     */
    public int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //因为最后输出dp[length-1][sum+s]，所以一定要在这里做判断，绝对值范围超过了sum的绝对值范围则无法得到
        if ( Math.abs(S) > Math.abs(sum) )
            return 0;
        int len = nums.length;
        int t = sum * 2 + 1;
        int[][] dp = new int[len][t];
        // 初始化
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        //填表
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {

                int last1 = (j - nums[i]) >= 0 ? dp[i - 1][j - nums[i] ] : 0;   //判断是否在范围内,不在的话对应的方案围为0
                int last2 = (j + nums[i]) < t ? dp[i - 1][ j + nums[i]] : 0;
                dp[i][j] = last1 + last2;
            }
        }
        return dp[len - 1][sum + S];
    }
    /*
        第 5 步：考虑空间优化
            因为dp[i]的计算之和dp[i-1]有关，因此可以考虑空间优化,注意在计算当前的dp数组时，会覆盖上一个状态的值，对结果造成影响，
                所以需要用一个数组保存上一个状态的值，把当前状态全部计算完后再修改dp数组。
        时间复杂度O( N * sum)
        空间复杂度O(  sum)
     */
    public int findTargetSumWays2(int[] nums, int S) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //因为最后输出dp[length-1][sum+s]，所以一定要在这里做判断，绝对值范围超过了sum的绝对值范围则无法得到
        if ( Math.abs(S) > Math.abs(sum) )
            return 0;
        int len = nums.length;
        int t = sum * 2 + 1;
        int[] dp = new int[t];
        int[] help = new int[t];
        // 初始化
        if (nums[0] == 0) {
            dp[sum] = 2;
        } else {
            dp[sum + nums[0]] = 1;
            dp[sum - nums[0]] = 1;
        }
        //填表
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {
                int last1 = (j - nums[i]) >= 0 ? dp[j - nums[i] ] : 0;   //判断是否在范围内,不在的话对应的方案围为0
                int last2 = (j + nums[i]) < t ? dp[ j + nums[i]] : 0;
                //dp[j] = last1 + last2;
                help[j] = last1 + last2;
            }
            if (t >= 0)
                System.arraycopy(help, 0, dp, 0, t);
        }
        return dp[sum + S];
    }

}
