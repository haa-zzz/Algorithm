package com.haa.algorithm.简单;

import java.util.Scanner;

public class 新21点 {
    /*
    爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：

    爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。

    当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/new-21-game
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    分析:
       动态规划
            关键在于求出状态转移方程
       这个思想很重要：目标是求出手中没有牌时获胜的概率
       令dp[x] 表示从得分为dp[x]的情况开始游戏并且获胜的概率，目标是求dp[0]的值
       比如N = 21, K = 17, W = 10
       dp[k,N] = 1,dp[N+1,26] = 0;
       当x = k-1时很容易想到获胜概率为 ( min(N-k+1,W) )/W;
       即为(dp[k-1+1]+dp[k-1+2]+...+dp[k-1+W])/w;
       当x = k-2时还是可以抽[1,W]中的一个，抽到1的概率为1/W.抽到1获胜的概率为dp[k-1],同理抽到2的概率为1/W.抽到2获胜的概率为dp[k]
       即为(dp[k-1]+dp[k]+...+dp[k-2+W])/w
       即可得到状态转移方程dp[x] = （dp[x+1]+dp[x+2]+...+dp[x+w])/W;
       进一步可解出dp[0];
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int w = in.nextInt();
        System.out.println(new21Game(n,k,w));

    }
    public static double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];       //dp[k-1]在算时要用到dp[k+w-1]所以定义长度为K+W
        if (K - 1 + W <= N)
            return 1;
        //此时k-1获胜的概率一定是（N-K+1)/w;
        for (int i = K; i <= N; i++) {
            dp[i] = 1;                 // dp[k,N] = 1,dp[N+1,26] = 0;
        }
        double sumProb = N - K + 1;        //计算[x+1,x+k]的概率和
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sumProb/W;
            sumProb  = sumProb-dp[i+W]+dp[i];          //dp[i-1] = (dp[i]-dp[i+W]+dp[i])/W;

        }
        return dp[0];
    }
}
