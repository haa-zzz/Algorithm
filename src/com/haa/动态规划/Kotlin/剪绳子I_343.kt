package com.haa.动态规划.Kotlin

import kotlin.math.max


/*
    给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
    例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
/*
    分析：动态规划
    第一步: 定义状态
        dp[i] 表示长度为i的绳子，剪成m端后的最大乘积
    第二步: 思考状态转移方程
        对于一条绳子，我们可以先剪去一段j，对于剩下的部分可以剪也可以不减,如果剪，那么乘积就是j*dp[i-j]。 如果不剪，乘积就是j*(i-j)
        两者取最大值即可。
        即转移方程为 dp[i] = max(j*dp[i-j], j*(i-j))
        然后遍历所有可能的j ,取最大值即可
    第三步：考虑初始化
        dp[2]  = 1

    时间复杂度O(n^2)
    空间复杂度O(n)
 */
class Solution {
    fun cuttingRope(n: Int): Int {
        val dp = IntArray(n+1)
        dp[2] = 1
        for (i in 3..n){
            for(j in 2 until  i){
                dp[i] = max(dp[i], max(j*(i-j),j*dp[i-j]))
            }

        }
        return dp[n]
    }
}


