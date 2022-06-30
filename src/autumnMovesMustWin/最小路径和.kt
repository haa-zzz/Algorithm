package autumnMovesMustWin

/*
   给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

   说明：每次只能向下或者向右移动一步。
   力抠：64
    */
/*
dp思想： dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
考虑空间优化
当前的状态之和前一部的状态相关，所以可以进行空间优化
我们可以只用一个一维数组dp[i]来保存每一行的数据
此时的转移方程变为 dp[i] = Math.min(dp[i-1], dp[i]) + grid[i][j] (此时dp[i-1]保存它左边的状态，dp[i]保存它上面的状态)
考虑初始化：
    在第一行: dp[i] = dp[i-1] +  grid[0][i]
    在第一列： dp[i] = dp[i] + grid[i][0]

    时间复杂度 O(M * N)
    空间复杂度 O(N)
 */
fun minPathSum(grid: Array<IntArray>): Int {
    if(grid.isEmpty()){
        return 0
    }
    val n = grid[0].size
    val dp = IntArray(n+1)
    for(i in 1..grid.size) {
        for(j in 1..grid[0].size) {
            when {
                i == 1 -> {
                    dp[j] = grid[0][j-1] + dp[j-1]
                }
                j == 1 -> {
                    dp[j] = grid[i-1][0] + dp[j]
                }
                else -> {
                    dp[j] = Math.min(dp[j], dp[j-1]) + grid[i-1][j-1]
                }
            }
        }
    }
    return dp[n]
}
