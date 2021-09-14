package com.haa.algorithm.简单;

import java.util.HashMap;

public class 爬楼梯 {
   /*
   假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
   注意：给定 n 是一个正整数。
    */

    /*
    方法1.
        递归+优化
        用HashMap去存放n对应的值，减少递归查找的次数，在递归返回时返回HashMap中的n对应的值。
     */
    private HashMap<Integer,Integer> hashmap = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        if(!hashmap.containsKey(n)){
            hashmap.put(n, climbStairs(n-1)+climbStairs(n-2) );
        }
        return hashmap.get(n);
    }
    /*
    方法2.动态规划
    这个题的迭代思路就是基于动态规划
        动规方程dp[i] = dp[i-1]+dp[i-2]
        初始化：dp[0] = 1, dp[1] = 1,(为何不初始为dp[1]=1,dp[2]=2,因为当n==1时还要特判，比较麻烦)
     */
    public int climbStairs1(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
     }
     /*
     优化后的动态规划：
        时间复杂度O(N)
        空间复杂度O(1)
      */
     public int climbStairs2(int n) {

         int dp0 = 1;
         int dp1 = 1;
         for(int i = 2; i <= n; i++) {
             int value = dp0;
             dp0 = dp1;
             dp1 = value+dp1;
         }
         return dp1;
     }
}
