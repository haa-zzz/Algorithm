package com.haa.二叉树;

import java.util.Scanner;


public class 不同的二叉搜索树_96 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(numTrees1(n));
    }
    /*
    给定一个整数 n，求以1 ...n为节点组成的二叉搜索树有多少种？

    示例:

    输入: 3
    输出: 5
    解释:
    给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3



    二叉搜索树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，
                则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树
    方法：动态规划
     第 1 步： 定义状态
            dp[i]表示i个节点的二叉搜索数的总和
     第 2 步： 思考状态转移方程
        设f(j)为以j为根节点的二叉搜索树的总数。则dp[i] = f(1)+(f2)+...+f(j)+...+f(i);
        又因为它的左、右子树也分别为二叉排序树则f(j) = dp(j-1) * dp(i-j);
        所以：dp[i] = dp[0] * dp[i-1] + dp[1] * dp[i-2] +......+ dp[i-1]*dp[0];
     第 3 步: 考虑初始化
        在计算f(1)时，f(1) = dp[0]*dp[i-1],它的含义是以1为根节点的二叉树的总数,值也应该等于dp[i-1],所以
            dp[0] = 1
        同理：dp[1] = 1

     第四步: 考虑输出
         最后的结果为dp[n]

     时间复杂度O(N^2)
     空间复杂度O(N)
 */


    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 1;
        dp[1] = 1;
        //填表
        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }

        }
        return dp[n];
    }


    /*方法二：事实上我们在方法一中推导出的 G(n)函数的值在数学上被称为卡塔兰数 Cn
        C0 = 1;
        C(n+1) = 2*(z*n+1)/(n+2)*C(n);

     */
    public static int numTrees1(int n) {
        long c = 1;

        for (int i = 0; i < n; i++) {

            c = c * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) c;

    }


}
