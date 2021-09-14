package com.haa.动态规划.java;

public class 买卖股票的最佳时机_121 {

    /*
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    示例 1：
    输入：[7,1,5,3,6,4]
    输出：5
    解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
         注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     */

    /*
    系列题：
    121. 买卖股票的最佳时机
    122. 买卖股票的最佳时机 II
    123. 买卖股票的最佳时机 III
    188. 买卖股票的最佳时机 IV
    309. 最佳买卖股票时机含冷冻期
    714. 买卖股票的最佳时机含手续费
    剑指 Offer 63. 股票的最大利润
     */

    /*
    方法1：动态规划
      思想：题目只问最大利润，没有问这几天具体哪一天买、哪一天卖，因此可以考虑使用 动态规划 的方法来解决。
     第 1 步：定义状态
        dp[i][j]：下标为i这一天结束时，手上持股状态为j时，的利润
        (1)  j==0 ：表示当前不持股
        (2)  j==1 : 表示当前持股

     第 2 步：思考状态转移方程

        （1） dp[i][0]：规定了今天不持股，有以下两种情况：
            昨天不持股，今天什么都不做；
            昨天持股，今天卖出股票（现金数增加），
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

        （2）dp[i][1]：规定了今天持股，有以下两种情况：
            昨天持股，今天什么都不做（现金数与昨天一样）；
            昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
           dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

     第 3 步：考虑初始化
        对于i = 0,不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

     第四步：考虑输出
        最后的输出结果为dp[len-1][0]

      复杂度分析：
        时间复杂度：O(N)，遍历股价数组可以得到最优解；
        空间复杂度：O(N)，状态数组的长度为 N。
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 特殊判断
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];

        //初始化
        dp[0][0] = 0; dp[0][1] = -prices[0];

        //填表
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];

    }
    /*
    第五步：考虑空间优化
        dp[i][0]和dp[i][1]的计算只和dp[i-1][0]和dp[i-1][1]有关，可以考虑进行空间优化，并且
            下标为 i 的行并且状态为 0 的行参考了上一行状态为 0 和 1 的行；
            下标为 i 的行并且状态为 1 的行只参考了上一行状态为 1 的行。

        时间复杂度O(N)
        空间复杂度O(1)
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        // 特殊判断
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[2];

        //初始化
        dp[0] = 0; dp[1] = -prices[0];

        //填表
        for(int i = 1; i < n; i++){
            dp[0] = Math.max(dp[0],dp[1]+prices[i]);
            dp[1] = Math.max(dp[1],-prices[i]);
        }
        return dp[0];

    }
    /*
    方法2.只遍历一遍数组，在遍历的同时做两件事
        1.当前值小于值——更新最小值
        2.当前值大于最小值——更新利润(即差值)

       时间复杂度O(N)
       空间复杂度O(1)
     */
    public int maxProfit2(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxValue = 0;
        for (int price : prices) {
            if (price < minPrices) minPrices = price;
            else {
                maxValue = Math.max(maxValue, price - minPrices);
            }
        }
        return maxValue;
    }
}
