package autumnMovesMustWin

/*
    分析：最先想到的就是dfs，但是用dfs，由于时间复杂度太高，会超出时间限制
        使用动态规划的思想来做
         第 1 步： 定义状态
            dp[i][j]表示机器人从起始位置（1，1）到（i，j）的不同路径
         第 2 步： 思考状态转移方程
            走到(i，j)位置只有两种可能，
                1.从(i-1,j)位置向右走一步
                2.从(i,j-1)位置向下走一步
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
            细节注意：因为每一步的计算需要用到左边和上面的数据。所以要注意填表顺序
         第 3 步: 考虑初始化
            dp[1][1]显然为1
         第四步: 考虑输出
            dp[n][m]

         时间复杂度O(N*M)
         空间复杂度O(N*M)
     */

fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m+1){IntArray(n+1)}
    for(i in 1..m) {
        for(j in 1..n) {
            if(i == 1 && j == 1) {
                dp[i][j] = 1
            } else {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }

        }
    }
    return dp[m][n]

}

/*
考虑空间优化
因为dp[i][j] = dp[i-1][j]+dp[i][j-1];当前的状态之和前一部的状态相关，所以可以进行空间优化
我们可以只用一个一维数组dp[i]来保存每一行的数据
此时的转移方程变为 dp[i] = dp[i-1]+dp[i] (此时dp[i-1]保存它左边的状态，dp[i]保存它上面的状态)
考虑初始化：
    在第一行或者第一列，dp[i] == dp[1] = 1
 */
fun uniquePaths1(m: Int, n: Int): Int {
    val dp = IntArray(n+1)
    dp[1] = 1
    for(j in 1..m) {
        for(i in 2..n){
            if(j == 1 ) {
                dp[i] = 1
            } else {
                dp[i] = dp[i-1] + dp[i]
            }

        }    }
    return dp[n]

}