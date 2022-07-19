package com.haa.动态规划.java;

public class 买卖股票的最佳时机II_122 {
    /*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    /*
    方法1.动态规划
        思路：题目只问最大利润，没有问这几天具体哪一天买、哪一天卖，因此可以考虑使用 动态规划 的方法来解决。
         第 1 步：定义状态
            dp[i][j]:表示下标为i的这一天结束时，手上持股状态为j时的利润
            （1）j = 0 : 表示当前不持股
             (2) j = 1 : 表示当前持股
         第 2 步：思考状态转移方程
            dp[i][0]:规定了今天不持股，有一下两种情况
                昨天不持股，今天什么都不做；
                昨天持股，今天卖出股票（现金数增加），
                dp[i][0] = Math.max( dp[i-1][1] + prices[i], dp[i-1][0]);
            dp[i][1]:规定了今天持股，有一下两种情况
                昨天持股，今天什么都不做（现金数与昨天一样）；
                昨天不持股，今天买入股票(注意这里和121的区别)。
                dp[i][1] = Math.max( dp[i-1][1],dp[i-1][0]-prices[i] );
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

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int[][] dp = new int[n][2];
        //初始条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //填表
        for(int i = 1; i < n; i++){
            //今天不持股票
            dp[i][0] = Math.max( dp[i-1][1] + prices[i], dp[i-1][0]);
            //今天持有股票(注意这里和121题不同，如果是今天买入股票，今天的利润情况是dp[i-1][0]-prices[i])
            dp[i][1] = Math.max( dp[i-1][1],dp[i-1][0]-prices[i] );
        }
        return dp[n-1][0];
    }
    /*
    第 5 步：考虑空间优化
        dp[i][0]和dp[i][1]的计算只和dp[i-1][0]和dp[i-1][1]有关，可以考虑进行空间优化
        注意：这里也和121题不同，因为在计算dp[i][1]是要用到dp[i-1][0],所以要用一个变量提前保存这个值
     */
    public int maxProfit1(int[] prices) {

        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int[] dp = new int[2];
        //初始条件
        dp[0] = 0;
        dp[1] = -prices[0];
        //填表
        for(int i = 1; i < n; i++){
            //用一个变量提前保存dp[0],因为下面的计算会覆盖dp[0]的值
            int value = dp[0];
            //今天不持股票
            dp[0] = Math.max( dp[1] + prices[i], dp[0]);
            //今天持有股票(注意这里和121题不同，如果是今天买入股票，今天的利润情况是dp[i-1][0]-prices[i])
            dp[1] = Math.max( dp[1],value-prices[i] );
        }
        return dp[0];
    }

    /*
    方法2.贪心
        股票买卖策略：
            单独交易日：设今天价格 p1,明天价格 p2 ，则今天买入、明天卖出可赚取金额 p2-p1
            连续上涨交易日:设此上涨交易日股票价格分别为p1,p2,....pn，则p1天买入pn天卖出获得的利润最大,即pn-p1
                等价于(p2-p1)+(p3-p2)+...+( Pn-P(n-1) )
            连续下降交易日:不买卖收益最大，即不会亏钱
     */
    public int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
