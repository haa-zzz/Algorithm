package com.haa.algorithm.简单;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
    相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
    例如，给定三角形：
    [
         [2],                                   2
        [3,4],                              3   4
       [6,5,7],                         6   5   7
      [4,1,8,3]                     4   1    8  3
    ]
    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/triangle
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    动态规划问题
    设f[i][j]为第（i,j）的最小路径和，那么第i行最小路径和为Math.min（f[i][0],f[i][1]……f[i][i])
    if(i==0)即第一行f[0][0]  = c[0][0]   (c[i][j]为(i,j)对应的值）
    if(j==0)  ->  f[i][0] = f[i-1][0]+c[i][0]
    if(j==i)  ->  f[i][i] = f[i-1][i-1] + c[i][i]
    else
        f[i][j] = Math.min(f[i-1][j],f[i-1][j-1])+ c[i][j];
 */
public class 三角形的最小路径和 {
    public static void main(String[] args){
        System.out.println("请输入三角行高");
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        List<List<Integer>> l = new ArrayList<List<Integer>>() ;
        for(int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                list.add(in.nextInt());
            }
            l.add(list);
        }
        int min = minimumTotal(l);
        System.out.println(min);


    }
    /*
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++){
            f[i][0] = f[i-1][0]+triangle.get(i).get(0);
            for(int j = 1; j < i; j++){
                f[i][j] = Math.min(f[i-1][j],f[i-1][j-1])+ triangle.get(i).get(j);
            }
            f[i][i] = f[i-1][i-1]+triangle.get(i).get(i);
        }
        int mintotal = f[n-1][0];
        for(int j = 1; j < n; j++){
            mintotal = Math.min(mintotal,f[n-1][j]);
        }
        return mintotal;

    }

     */
    /*
    空间优化
    对f[i][j]的推导只需要f[i-1][j]和f[i-1][j-1],可以用两个变量暂存
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        int prev = 0,cur = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                cur = dp[j];
                if(j == 0)
                    dp[j] = cur+triangle.get(i).get(0);
                else if(j==i)
                    dp[j] = prev + triangle.get(i).get(i);
                else
                    dp[j] = Math.min(prev,cur)+ triangle.get(i).get(j);
                prev = cur;
            }
        }
        int mintotal = dp[0];
        for(int j = 1; j < n; j++){
            mintotal = Math.min(mintotal,dp[j]);
        }
        return mintotal;

    }




}
