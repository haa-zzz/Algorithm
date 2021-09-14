package com.haa.algorithm;

public class 最长公共子序列 {
    /*
    给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

    一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
    例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

    若这两个字符串没有公共子序列，则返回 0。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-common-subsequence
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    做法:动态规划
            让其下标从1开始其中，dp[i][j] 的含义是：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]。
            状态转移方程：
                if(c1[i-1] == c2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);

     */
    public int longestCommonSubsequence(String text1, String text2) {
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
