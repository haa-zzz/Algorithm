package com.haa.动态规划.java;

import java.util.Arrays;

public class 零钱兑换 {
    /*
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
    你可以认为每种硬币的数量是无限的。
    力抠：322
     */
    /*
    方法1： 递归+记忆化搜索
    时间复杂度 O(CN) C是金额数，N是面额
    空间复杂度 O(C) 最大栈深度和记忆化数组都需要O(C)
     */
    class Solution {
        int[] cache;
        public int coinChange(int[] coins, int amount) {
            if(coins.length == 0){
                return -1;
            }
            cache = new int[amount];

            return dfs(coins,amount);
        }
        // cache[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
        // dfs函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
        public int dfs(int[] coins, int amount){
            if(amount < 0){
                return -1;
            }
            if(amount == 0){
                return 0;
            }
            // 记忆化的处理，cache[n]用有值的化，就不用继续下面的循环
            // 直接的返回cache[n] 的最优值
            if(cache[amount-1] != 0){
                return cache[amount-1];
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0;i < coins.length;i++){
                //拿到减去这个硬币后每一种可能的结果
                int res = dfs(coins,amount-coins[i]);
                if(res >= 0 && res < min){
                    min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
                }
            }
            //保存最后的结果
            cache[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
            return cache[amount-1];
        }
    }
    /*
    方法2：dp： dp[i] = j 表示金额为i时最少面额为j
    类似于上楼梯， dp【i】 = [i - 面额]中的最大值
     */
    public int coinChange1(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;
        }
        return (dp[amount] == Integer.MAX_VALUE)? -1:dp[amount];
    }
}
