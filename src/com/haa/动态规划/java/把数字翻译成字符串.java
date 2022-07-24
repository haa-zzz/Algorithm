package com.haa.动态规划.java;

public class 把数字翻译成字符串 {

    /*
    给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
    一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    /*
    方法： dp, dp[i]表示0-i位置有多少种翻译方法
        递归方程：
            dp[i] = dp[i-1] + (如果i-1，i位可以构成有效字母) dp[i-2]
        时间复杂度 O(n)
        空间复杂度 O(n)
        由于dp[i]之和dp[i-1]，dp[i-2]有关，所以可以进行空间优化。 优化后 空间复杂度O(1)
     */
    public int translateNum(int num) {
        //dp
        String str = String.valueOf(num);
        int n = str.length();
        if(n <= 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;  //只有一个数字，一定可以翻译
        for(int i = 2; i <= n; i++) {
            dp[i]+=dp[i-1];
            String value = str.substring(i-2, i);
            if(value.compareTo("10")>=0  && value.compareTo("25")<= 0) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
