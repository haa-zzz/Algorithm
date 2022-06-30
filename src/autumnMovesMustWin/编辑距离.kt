package autumnMovesMustWin

/*
给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符

来源：力扣72
 */
/**
 * dp思想： dp[i][j]表示word1(0,i) -> word2(0,j)所需要的最少操作数
 * 状态转移方程：
 *      dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+int(word1[i]!=word2[j]))
 * 解释：
 *  举个例子，word1 = "abcde", word2 = "fgh",我们现在算这俩字符串的编辑距离，就是找从word1，最少多少步，能变成word2？那就有三种方式：
        1.知道"abcd"变成"fgh"多少步（假设X步），那么从"abcde"到"fgh"就是"abcde"->"abcd"->"fgh"。（一次删除，加X步，总共X+1步）
        2. 知道"abcde"变成“fg”多少步（假设Y步），那么从"abcde"到"fgh"就是"abcde"->"fg"->"fgh"。（先Y步，再一次添加，加X步，总共Y+1步）
        3.知道"abcd"变成“fg”多少步（假设Z步），那么从"abcde"到"fgh"就是"abcde"->"fge"->"fgh"。（先不管最后一个字符，把前面的先变好，用了Z步，然后把最后一个字符给替换了。这里如果最后一个字符碰巧就一样，那就不用替换，省了一步）
        以上三种方式算出来选最少的，就是答案。
    初始化：
        如果其中一个字符串是空串，那么编辑距离是另一个字符串的长度。比如空串“”和“ro”的编辑距离是2（做两次“插入”操作）。
 */
fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    val dp = Array(m+1){IntArray(n+1)}
    for(i in 0.. m) {
        dp[i][0] = i
    }
    for(i in 0..n){
        dp[0][i] = i
    }
    for(i in 1..m) {
        for(j in 1..n) {
            dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1),dp[i-1][j-1] + if(word1[i-1] == word2[j-1]) 0 else 1)

        }
    }
    return dp[m][n]

}