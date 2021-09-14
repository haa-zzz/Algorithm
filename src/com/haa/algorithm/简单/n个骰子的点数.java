package com.haa.algorithm.简单;

public class n个骰子的点数 {
    /*
    把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
    你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
    限制：

    1 <= n <= 11
     */
    /*
    分析：
        总共可能的结果为6+（n-1)*5，且结果是左右对称的
        结题思路：
            我们要求出所有点数出现的概率，点数k出现的概率为 P(k) = k出现的次数/总次数
            总次数为6^n,
            目的：计算出投掷完 n 枚骰子后每个点数出现的次数。
         结题方法:动态规划
            最后一个阶段即为我们要求的掷完 n 枚骰子后每个点数出现的次数
            那么可设dp[i][j]，表示掷完i个骰子后点数j出现的次数

            找状态转移方程：
                单看掷第n个骰子，可能出现的点数为1,2,3,4,5,6
                因此掷完n个骰子点数j可由n-1推出，应点数 j-1, j-2, j-3, ... , j-6j−1,j−2,j−3,...,j−6 出现的次数之和转化过来
                for (第n枚骰子的点数 i = 1; i <= 6; i ++) {
                    dp[n][j] += dp[n-1][j - i]
                }
            边界处理
                for (int i = 1; i <= 6; i ++) {
                    dp[1][i] = 1;
                }

     */

    public double[] twoSum(int n) {

        double[][] dp = new double[n+1][6*n+1];
        for(int i = 1; i <= 6; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n; i++ ){
            for(int j = i ; j <= 6*i; j++){
                for(int cur = 1; cur <= 6 ; cur++){
                    if(j-cur<=0){
                        break;
                    }
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }
        double all =  Math.pow(6,n);
        int len = 6+(n-1)*5;
        double[] arr = new double[len];
        for(int i  = n; i <= 6*n ; i++){
            arr[i-n] = ((double) dp[n][i])/all;
        }
        return arr;
    }
    /*
    空间优化
        由于每个阶段的状态只和他前一个阶段有关，因此可将二维数组转变为一维数组
        问题:
            由于我们在当前状态变化dp数组时，上次记录的值可能要被重复利用，如果和上面一样遍历，那么第一次使用后值就变了，显然不行，比如
                n = 2时，我们要更新dp[2],dp[3],  dp[2] += dp[1](上次状态的dp[1])
                                               dp[3] += dp[2](上次状态的dp[2])+dp[1](上次状态的dp[1])
                可是由于先更新的dp[2],dp[2]的值已经发生变化，显然不行
            做法:我们可以改变遍历顺序，从后到前遍历，注意此时要把dp[]数组先制空(本来就应该为空，但是第一次我们给他赋值了)，因为dp[]里如果存上次的结果，那么从后到前+=显然是错的
     */
    public double[] twoSum1(int n) {

        double[] dp = new double[6*n+1];
        for(int i = 1; i <= 6; i++){
            dp[i] = 1;
        }
        for(int i = 2; i <= n; i++ ){
            for(int j = 6*i ; j >= i; j--){
                dp[j] = 0;
                for(int cur = 1; cur <= 6 ; cur++){
                    if(j-cur < i-1){
                        break;
                    }
                    dp[j]+=dp[j-cur];
                }
            }
        }
        double all =  Math.pow(6,n);
        int len = 6+(n-1)*5;
        double[] arr = new double[len];
        for(int i  = n; i <= 6*n ; i++){
            arr[i-n] = ( (double) dp[i])/all;
        }
        return arr;
    }

}
