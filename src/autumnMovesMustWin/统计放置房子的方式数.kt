package autumnMovesMustWin
/*
一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。
现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 109 + 7 取余后再返回。
注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。
 */

/**
 * 方法：dp, dp[i]代表一边有i块地砖时的方法数
 *
 * 考虑dp[i]：分三种情况
 *   1. 两边都不放 方法数为 dp[i-1]
 *   2. 两边都放(则i-1位置两边都不能发) 方式数为dp[i-2]
 *   3. 两边只有一边放(则i-1位置的另一边可放可不放) 方法数为 (dp[i-2] + dp[i-3] + .... + dp[2] + 2) * 2
 *
 * 注意不能直接用int存储
 */
fun countHousePlacements(n: Int): Int {
    val mod = 1e9 + 7
    val dp = LongArray(n+1)
    var sum = 1L
    dp[0] = 1
    for(i in 1..n) {
        if(i == 1) {
            dp[i] = 4
        } else {
            sum += dp[i-2]
            sum = (sum % mod).toLong()
            dp[i] = ((dp[i-1] + dp[i-2] + 2*sum) % mod).toLong()
        }
    }
    return dp[n].toInt()
}