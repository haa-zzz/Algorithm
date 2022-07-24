package com.haa.动态规划.java;

public class 礼物的最大价值 {
    /*
    在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
    并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     */
    /*
    dp就完了：
        dp[i][j] 表示(i,j)位置的最大价值
            dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        考虑空间优化；
        用dp[j]表示每一行的礼物最大价值
        dp[j] = max(dp[j] (左边) , dp[j-1] (上边) ) + grid[i][j]

        时间复杂度 O(M*N)
        空间复杂度 O(M)
     */
    class Solution {
        public int maxValue(int[][] grid) {
            //dp: dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + grid[i][j]
            int n = grid.length;
            if(n == 0) return 0;
            int m = grid[0].length;
            if(m == 0) return 0;

            int[] dp = new int[m+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j-1]) + grid[i-1][j-1];
                }
            }
            return dp[m];
        }
    }
}
