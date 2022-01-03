package com.haa.动态规划.Kotlin

import kotlin.math.max
import kotlin.math.pow


/*
    给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
    例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
/*
    方法1：动态规划
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

fun cuttingRope(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[2] = 1
    for (i in 3..n) {
        for (j in 2 until i) {
            dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
        }
    }
    return dp[n]
}


/*
    方法2: 贪心算法
        尽可能把绳子分成长度为3的小段，这样乘积最大
        2         1*1
        3         2*1
        4         2*2 > 3*1     这种情况下2*2大
        5         3*2
        6         3*3
        7         3*2*2
        ......

        当 n == 2 时，返回1  当n==3时，返回2
        当n>3时   分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3
            如果最后一段长度为1 由于2*2 > 3*1 所有 结果为 res/3*4
            否则，结果为res*n
        时间复杂度 O(n)
        空间复杂度O(1)
 */
fun cuttingRope1(n: Int): Int {
    var n = n
    if (n == 2) return 1
    if (n == 3) return 2
    var res = 1
    while (n > 4) {
        res *= 3
        n -= 3
    }
    return res * n
}

/*
    数学推倒：1.每一段的长度相同时，乘积最大  2。每一段长度为3时，乘积最大
    时间复杂度 O(1)
    空间复杂度 O(1)
 */
fun cuttingRope2(n: Int): Int {
    if (n == 2) return 1
    if (n == 3) return 2
    val a = n / 3
    val b = n % 3
    if (b == 0) return 3.0.pow(a).toInt()
    if (b == 1) return 3.0.pow(a - 1).toInt() * 4
    return 3.0.pow(a).toInt() * 2
}

