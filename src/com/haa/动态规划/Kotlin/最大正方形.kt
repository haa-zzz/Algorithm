package com.haa.动态规划.Kotlin

class 最大正方形

/*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
/*
分析：动态规划问题
定义dp数组  dp[i][j]表示以 i,j 为右下角的正方体边长的最大值
转移方程： dp[i][j] = ath.Main(dp[row + 1][col], dp[row][col + 1]),dp[row][col])+1
初始化：最左边和最上边的dp[i][j] = (Int)matrix[i][j],为了统一处理，可以申请dp[n+1][m+1]大小的数组，从[1][1]开始记

时间复杂度O(n*M)
空间复杂度O(n*M)
 */

fun maximalSquare(matrix: Array<CharArray>?): Int {
    // base condition
    if (matrix == null || matrix.size < 1 || matrix[0].size < 1) return 0

    val height = matrix.size
    val width: Int = matrix[0].size
    var maxSide = 0

    val dp = Array(height + 1) { IntArray(width + 1) }
    for (row in 0 until height) {
        for (col in 0 until width) {
            if (matrix[row][col] == '1') {
                dp[row + 1][col + 1] = Math.min( Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col])+1
                maxSide = Math.max(maxSide, dp[row + 1][col + 1])
            }
        }
    }
    return maxSide * maxSide
}