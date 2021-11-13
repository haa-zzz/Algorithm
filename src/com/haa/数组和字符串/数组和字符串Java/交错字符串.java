package com.haa.数组和字符串.数组和字符串Java;


import java.util.Arrays;

public class 交错字符串 {
    /*
    给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
    动态规划问题

    用dp[i][j]表示用s1的前i个，s2的前j个可不可以组s3的前i+j个
    如果s1[i]==s3[i+j]那么dp[i+j]==true 的关键是 dp[i-1+j]==true
    同理，如果s2[j]==s3[i+j]那么dp[i+j]==true 的关键是 dp[i+j-1]==true
    只要上式之一成立即可
    动态转移方程：dp[i][j] == dp[i-1][j] && s1.get(i-1)==s3.get(i+j-1) || dp[i][j-1] && s2.get(j-1)==s3.get(i+j-1)
    边界条件：dp[0][0] = true


     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if(n+m!=t)
            return false;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
               int p = i+j-1;
               if(i>0)
                   dp[i][j] = dp[i][j]||dp[i-1][j]&&s3.charAt(p)==s1.charAt(i-1);
               if(j>0)
                   dp[i][j] = dp[i][j]||dp[i][j-1]&&s3.charAt(p)==s2.charAt(j-1);
            }
        }
        return dp[n][m];
    }

}
