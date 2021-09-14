package com.haa.algorithm.中等;

public class 最长回文子串 {
    /*
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    /*
    方法1:动态规划
        对于一个长度大于2的回位串，去掉收尾仍然是一个回文串，可用动态规划解决
        dp[i][j]是回位子串，那么dp[i+1][j-1] = true && s[i]==s[j]
        否则 为false   1.本身不是回文串 2.i>j

        边界条件：
            len = 1   dp[i][i] = true
            len = 2   dp[i][i+1]  = s[i]==s[i+1]
     */
    /*
    时间复杂度 O(N^2)
    空间复杂度 O(N^2)
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int maxlen = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        /*
        注意遍历的方式
         */
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && maxlen < j - i + 1) {
                    start = i;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }
    /*
    方法2:中心扩展法
        遍历每一个可能是中心的点，向两边扩散，寻找是回位串的所有可能
        对于奇数的回文串，中心为一位
        对于偶数的回文串，中心为两位
        可分两种情况讨论，最后取最大值
     */
    public String longestPalindrome2(String s) {
      int len = s.length();
      if(len<2)
          return s;
      //初始大小为1，即默认最小的回文串为第一个字符
      int maxlen = 1;
      String res = s.substring(0,1);

      for(int i = 0; i < len-1; i++){
          //奇数
          String oneStr = centerSpread(s,i,i);
          //偶数
          String twoStr = centerSpread(s,i,i+1);
          String maxlenStr = oneStr.length()>twoStr.length()? oneStr:twoStr;
          if(maxlen < maxlenStr.length()){
              maxlen = maxlenStr.length();
              res = maxlenStr;
          }
      }
      return res;

    }

    private String centerSpread(String s, int i, int j) {
        int len = s.length();
        while(i>=0 && j < len){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }
            else{
                break;
            }
        }
        return s.substring(i+1,j);
    }
}
