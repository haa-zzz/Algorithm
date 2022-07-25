package com.haa.动态规划.java;

public class n个骰子的点数 {
    /*
    把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
    你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
    限制：
    1 <= n <= 11
     */

    /*
    分析：总共可能的结果为6+（n-1)*5，且结果是左右对称的
        结题思路：
            我们要求出所有点数出现的概率，点数k出现的概率为 P(k) = k出现的次数 / 总次数.  总次数为6^n,
            目的：计算出投掷完 n 枚骰子后每个点数出现的次数。
         解题方法:动态规划
            设dp[i][j]，表示掷完 i 个骰子后点数 j 可能出现的次数
            找状态转移方程：
                单看掷第 n 个骰子，可能出现的点数为1,2,3,4,5,6
                因此掷完 n 个骰子点数 j 可由 n-1 推出, dp[n][j] = dp[n-1][j-1]+dp[n-1][j-2]...+dp[n-1][j-6]
            边界处理
               当只有一个筛子时， dp[1][j] = 1
     */

    public double[] twoSum(int n) {
        double[][] dp = new double[n+1][6*n+1];    //最后最高的点数为6*n
        for(int i = 1; i <= 6; i++){       //初始化
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n; i++ ){
            for(int j = i ; j <= 6 * i; j++){   //掷第i个筛子时，点数出现的区间为 i - 6*i
                for(int number = 1; number <= 6 ; number++){
                    if(j - number <= 0){   //点数不能小于等于0
                        break;
                    }
                    dp[i][j] += dp[i-1][j-number];  ///掷第i个筛子时点数为number
                }
            }
        }
        double all =  Math.pow(6,n);    //总次数
        int len = 6+(n-1)*5;        //结果数
        double[] arr = new double[len];
        for(int i  = n; i <= 6*n ; i++){
            arr[i-n] = (dp[n][i])/all;
        }
        return arr;
    }
    /*
    空间优化
        由于每个阶段的状态只和他前一个阶段有关，因此可将二维数组转变为一维数组
        dp[i] 表示点数i 出现的次数
     */
    public double[] twoSum1(int n) {

        double[] dp = new double[6*n+1];
        for(int i = 1; i <= 6; i++){
            dp[i] = 1;
        }
        for(int i = 2; i <= n; i++ ){
            for(int j = 6 * i ; j >= i; j--){       //注意这里是逆序遍历的
                dp[j] = 0;  //因为是从后往前逐个累加，在加到当前点数时，必须把原先存放的n-1个骰子的数据置0，否则累加出错
                for(int number = 1; number <= 6 ; number++){
                    // 如果不加此判据，会取到n-2个骰子的数据，此时可认为是“脏数据”，会导致累加出错。
                    // 从实际情况来分析，n-1个骰子的最小值就 是n-1，不会比这再小，因此此处的判据是 i-1，而不是0；
                    if(j - number < i-1){
                        break;
                    }
                    dp[j] += dp[j-number];
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
