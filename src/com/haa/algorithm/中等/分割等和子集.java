package com.haa.algorithm.中等;

/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
每个数组中的元素不会超过 100
数组的大小不会超过 200
 */

public class 分割等和子集 {
    /*
    分析：动态规划问题
        问题可转化为选取的数字之和恰好等于数组总和的一般
        创建二维数组dp[len][target] （len为数组的长度，target为数组总和的一半）
        dp[i][j]表示选取下标从0到i的若干整数,是否存在选取方案使得这些数字之和等于j,那么我们最终要求的就是dp[len-1][target]

        动态转移方程：
           1.对于dp[i][0],如果不选取任何整数，那么成立，所以dp[i][0] = true;
           2.对于dp[0][i],我们只能选取nums[0],此时dp[0][nums[0] = true;
           3.对于普通的i>0,j>0

              如果j<nums[i],那么dp[i][j] = dp[i-1][j]
              如果j>nums[i],dp[i][j] = dp[i-1][ j-nums[i] ] || dp[i-1][j]

     */
    public boolean canPartition(int[] nums) {

        int target = 0;
        int Maxnum = 0;
        int n = nums.length;

        if(n<2){
            return false;
        }
        for(int num: nums){
            if(Maxnum<num)
                Maxnum = num;
            target+=num;
        }
        if(target%2!=0){
            return false;
        }
        target/=2;
        if(Maxnum > target)
            return false;

        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;

        for(int i = 1; i < nums.length; i++ ){
            for(int j = 1; j <= target; j++ ){

                if(j > nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
                else if(j==nums[i]){

                    dp[i][j] = true;
                }
               else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[n-1][target];
    }
    /*
    空间优化
        在「填表格」的时候，当前行总是参考了它上面一行 「头顶上」 那个位置和「左上角」某个位置的值。
            因此，我们可以只开一个一维数组，从后向前依次填表即可。
     */
    public boolean canPartition1(int[] nums) {

        int target = 0;
        int Maxnum = 0;
        int n = nums.length;

        if(n<2){
            return false;
        }
        for(int num: nums){
            if(Maxnum<num)
                Maxnum = num;
            target+=num;
        }
        if(target%2!=0){
            return false;
        }
        target/=2;
        if(Maxnum > target)
            return false;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i = 1; i < n; i++){
            for(int j = target; j >= nums[i] ;j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }

}
