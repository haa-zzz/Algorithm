package com.haa.动态规划.java

class 回文子串Kotlin_647 {
    /*
    给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
    具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     */

    class Solution {
        /*
        方法1.动态规划
        需要注意的是填表顺序需要竖着往后填，这样保证了对于每一对[i,j] 那么[i+1][j-1]一定是有过定义的。
            时间复杂度O(N ^ 2)
            空间复杂度O( N ^ 2)
         */
        fun countSubstrings(s: String): Int {
            //dp动态规划
            val length = s.length
            val dp = Array(length){ BooleanArray(length) }

            var ans = 0
            //初始化

            //填表
            for(i in 0 until length){
                for(j in 0..i){
                    if(i==j){
                        dp[j][i] = true
                    }else if(i == j+1){
                        dp[j][i] = s[j]==s[i]
                    }else{
                        dp[j][i] = dp[j+1][i-1] && s[j] == s[i]
                    }
                    if( dp[j][i] ){
                        ans++
                    }
                }
            }
            return ans
        }
        /*
        空间复杂度优化到n的思路
        最后填表的时候填的是一个上三角矩阵，我们可以把这个上三角矩阵转换为一维数组
         */
        fun countSubstrings1(s: String): Int {
            //dp动态规划

            val length = s.length
            val dp = BooleanArray(length)
            var ans = 0
            //初始化
            //填表
            for(i in 0 until length){
                for(j in 0..i){

                    if(i==j){
                        dp[j] = true
                    }else if(i == j+1){
                        dp[j] = s[j]==s[i]
                    }else{
                        dp[j] = dp[j+1]  && s[j] == s[i]
                    }
                    if( dp[j] ){
                        ans++
                    }
                }
            }
            return ans
        }
        //中心扩展法
        /*
        中心扩展法的思路就是 从一个点出发，向左右查找是当前字符串是否是回文串，如果是回文串，就记录并继续查找。如果不是，就从下一个中心点开始。
        注意中心点分为 1个字符和2个字符两种
         */
        fun countSubstrings2(s: String): Int {
            var ans = 0
            for (i in 0 until 2*s.length-1){
                var left = i/2
                var right = left + i%2
                while(left >= 0 && right < s.length && s[left]==s[right]){
                    left--
                    right++
                    ans++
                }
            }
            return ans
        }

    }

}