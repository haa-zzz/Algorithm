package AlgorithmByKotlin

class 买卖股票的最佳时机Kotlin_121 {
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
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        // 特殊判断
        if (n < 2) {
            return 0
        }
        val dp = Array(n) { IntArray(2) }

        //初始化
        dp[0][0] = 0
        dp[0][1] = -prices[0]

        //填表
        for (i in 1 until n) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i])
        }
        return dp[n - 1][0]
    }
}