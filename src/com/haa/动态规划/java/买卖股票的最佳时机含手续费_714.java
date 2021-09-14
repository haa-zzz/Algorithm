package com.haa.动态规划.java;

public class 买卖股票的最佳时机含手续费_714 {

    /*
    给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
    你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
    返回获得利润的最大值。
    注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     */
    /*
    这个题除了加手续费其他的和买卖股票的最佳时机II_122完全一样，所以在实现时的思路也完全相同，只是动规方程略有不同
     */
    /*
    方法1.动态规划
         第 1 步：定义状态
            dp[i][j]:表示下标为i的这一天结束时，手上持股状态为j时的利润
            （1）j = 0 : 表示当前不持股
             (2) j = 1 : 表示当前持股
             
         第 2 步：思考状态转移方程
            dp[i][0]:规定了今天不持股，有一下两种情况
                昨天不持股，今天什么都不做；
                昨天持股，今天卖出股票（现金数增加），
                dp[i][0] = Math.max( dp[i-1][0] , dp[i-1][1] + prices[i]-fee );
            dp[i][1]:规定了今天持股，有一下两种情况
                昨天持股，今天什么都不做（现金数与昨天一样）；
                昨天不持股，今天买入股票(注意这里和121的区别)。
                dp[i][1] = Math.max( dp[i-1][1], dp[i-1][0]-prices[i] );
         第 3 步：考虑初始化
            对于i = 0,不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
         第 4 步：考虑输出
            最后的输出结果为dp[len-1][0]

        复杂度分析：
        时间复杂度：O(N)，遍历股价数组可以得到最优解；
        空间复杂度：O(N)，状态数组的长度为 N。
     */
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        if(n < 2){
            return 0;
        }

        //定义dp数组
        int[][] dp = new int[n][2];

        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //填表
        for(int i = 1; i < n; i++){

            dp[i][0] = Math.max( dp[i-1][0] , dp[i-1][1] + prices[i]-fee );
            dp[i][1] = Math.max( dp[i-1][1], dp[i-1][0]-prices[i] );

        }
        return dp[n-1][0];
    }
    
    /*
    第 5 步: 考虑空间优化
     dp[i][0]和dp[i][1]的计算只和dp[i-1][0]和dp[i-1][1]有关，可以考虑进行空间优化
     注意: 在计算dp[i][1]是要用到dp[i-1][0],所以要用一个变量提前保存这个值
     */
    public int maxProfit1(int[] prices, int fee) {

        int n = prices.length;
        if(n < 2){
            return 0;
        }

        //定义dp数组
        int[] dp = new int[2];

        //初始化
        dp[0] = 0;
        dp[1] = -prices[0];

        //填表
        for(int i = 1; i < n; i++){
            int state0 = dp[0];
            dp[0] = Math.max( dp[0] , dp[1] + prices[i]-fee );
            dp[1] = Math.max( dp[1], state0-prices[i] );

        }
        return dp[0];
    }


}
