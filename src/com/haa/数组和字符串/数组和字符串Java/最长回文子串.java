package com.haa.数组和字符串.数组和字符串Java;

public class 最长回文子串 {
    /*
    给你一个字符串 s，找到 s 中最长的回文子串。
     */
    /*
    方法一.
        动态规划，思想：对于一个子串，如果他是回文串，那么去掉首位它依旧是回文串，
        第 1 步：定义状态
            dp[i][j] 表示子串 s[i..j] 是否为回文子串，这里子串 s[i..j] 定义为左闭右闭区间，可以取到 s[i] 和 s[j]。
        第 2 步：思考状态转移方程
            在这一步分类讨论（根据头尾字符是否相等），根据上面的分析得到：
            dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
        第 3 步：考虑初始化
            初始化的时候，单个字符一定是回文串，因此把对角线先初始化为 true，即 dp[i][i] = true 。
            事实上，初始化的部分都可以省去。因为只有一个字符的时候一定是回文，dp[i][i] 根本不会被其它状态值所参考。

        第四步：考虑输出
        只要一得到 dp[i][j] = true，就记录子串的长度和起始位置，没有必要截取，
            这是因为截取字符串也要消耗性能，记录此时的回文子串的「起始位置」和「回文长度」即可。


     */
    public String longestPalindrome(String s) {

        int n = s.length();
        if(n < 2){
            return s;       //特判
        }
        boolean[][] dp = new boolean[n][n];
        int strLength = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < n; i++){
            dp[i][i] = true;            //初始化
        }

        for(int j = 1; j < n; j++){
            for(int i = 0; i < j; i++){
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i < 3){            //如果 (j-1) - (i+1) +1 < 2 此时不构成区间，比如 i = 1,j = 3
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }
        return "";
    }
}
