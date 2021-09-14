package com.haa.algorithm;

public class 让字符串变成回文串的最少插入次数 {
    /*
    给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。

    请你返回让 s 成为回文串的 最少操作次数 。

    「回文串」是正读和反读都相同的字符串。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    动态规划，将原字符串改为回文串，只需要求原字符串中的最长回文子串的长度，然后用总字符串长度减去它即可。
    而最长回位子串的长度可变换为p可p的反转的最长公共子序列
    所以先求最长公共子序列
     */
    public int minInsertions(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        return s.length()-longestCommonSubsequence(s,s1);

    }
    private int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1 ; i++){
            for(int j = 1; j <= len2; j++){
                if(c1[i-1] == c2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }
}
