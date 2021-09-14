package com.haa.动态规划.java;

public class 最小路径和_64 {
    /*
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

    说明：每次只能向下或者向右移动一步。
     */
    /*
    分析：
        这道题和不同路径是一类问题，可以通过动态规划的思想来做。
        对于每一个位置来说，选择下一步的走法有4种，即向左，向右，向上，向下。但是是从左上走到右下，并且求得是最小路径和。所以不用考虑向左和向上的情况。
        第 1 步： 定义状态
            dp[i][j]表示从起始位置（0，0）到（i，j）的最小路径
         第 2 步： 思考状态转移方程
            1.i = 0     此时走到（i，j）位置只能是（i，j-1）
                dp[i][j] = dp[i][j-1]+grid[i][j]
            2.j = 0     此时走到（i，j）位置只能是（i-1，j）
                dp[i][j] = dp[i-1][j]+grid[i][j]
            3.一般情况
               走到(i，j)位置只有两种可能，
                 1.从(i-1,j)位置向下走一步
                 2.从(i,j-1)位置向右走一步
               dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + grid[i][j]
         第 3 步: 考虑初始化
            dp[0][0] = grid[0][0]
         第四步: 考虑输出
            dp[n-1][m-1]

         时间复杂度O(N*M)
         空间复杂度O(N*M)
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for(int i = 1;  i < n; i++ ){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
    /*
    考虑空间优化
        对于这道题来说，可以直接在原地dp,空间复杂度为O(1)
     */
    public int minPathSum1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    grid[i][j] += grid[i][j-1];
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }

            }
        }
        return grid[n-1][m-1];
    }

}
