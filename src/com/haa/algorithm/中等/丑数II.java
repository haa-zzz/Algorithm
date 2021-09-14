package com.haa.algorithm.中等;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 丑数II {
    /*
    给你一个整数 n ，请你找出并返回第 n 个 丑数 。

    丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     */
    /*
    方法1.最小堆+hash表查重
        首先将1加入堆，每次取出堆顶元素(即最小元素)x，那么2x,3x,5x也是丑数，把他们也加入堆中，但是在加时可能会有重复元素出现，所以还需要
        用到hash表查重。
        时间复杂度 O(N log N)
        空间复杂度 O(N)
     */
    public int nthUglyNumber(int n) {
        int[] nums = {2,3,5};
        Set<Long> set = new HashSet<>();

        PriorityQueue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.offer(1L);
        int ugly = 0;
        for(int i = 1; i <= n; i++){
            long curr = queue.poll();
            ugly = (int)curr;
            for(int num : nums){
                long next = num * curr;
                if(set.add(next)){
                    queue.offer(next);
                }
            }
        }
        return ugly;
    }
    /*
    方法2.动态规划
     第 1 步：定义状态
        dp[i]：表示第i个丑数

     第 2 步：思考状态转移方程

        定义3个指针p2,p3,p5  表示下一个丑数是当前指针指向的丑数乘以对应的质因数。初始时，三个指针的值都是 1。
        令dp[i] = min(dp[p2]*2,dp[p3]*3,dp[p5]*5)
        最后：如果dp[i]用的是那个指针得到的，就把对应指针+1

     第 3 步：考虑初始化
        dp[1] = 1

     第四步：考虑输出
        最后的输出结果为dp[n]

      复杂度分析：
        时间复杂度：O(N)
        空间复杂度：O(N)
     */
    public int nthUglyNumber1(int n) {
       int[] dp = new int[n+1];
       //初始化
       dp[1] = 1;
       //初始化三指针
       int p2,p3,p5;
       p2 = p3 = p5 = dp[1];
       for(int i = 2; i <= n ; i++){
           int num2 = p2*2, num3 = p3 * 3, num5 = p5*5;
           dp[i] = Math.min(num2,Math.min(num3,num5));
           if(num2 == dp[i]){
               p2++;
           }
           if(num3 == dp[i]){
               p3++;
           }
           if(num5 == dp[i]){
               p5++;
           }
       }
       return dp[n];
    }
}
