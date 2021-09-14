package com.haa.algorithm.简单;

import java.util.Arrays;

public class 视频拼接 {
    /*
    你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
    视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，
        例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
    我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
     */
    /*
    题意：给定区间 [0,T) 的一系列子区间（可能重叠），要求从中选出尽可能少的子区间，使得这些子区间能够完全覆盖区间 [0,T)。
     */
    /*
    方法一：动态规划，
        分析：最后的状态是求T对应的最小选择，
        可设dp[i] = k 表示i对应的最小选择是K个
        那么就是求dp[T]
        动态转移方程：
            对于dp[i],我们可枚举clips数组，如果存在一个片段（a,b）使得a < i <= b;那么我们就可以用dp[a]+1去更新，遍历所有的复合条件的片段，选出最小的填入

        边界：
            dp[0] = 0
     */
    public int videoStitching(int[][] clips, int T) {

        int[] dp = new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i = 1; i <= T; i++){
            for(int j = 0; j < clips.length;j++){
                if(clips[j][0] < i && clips[j][1]>= i)
                    dp[i] = Math.min(dp[i],dp[clips[j][0]]+1);
            }
        }
        return dp[T]==Integer.MAX_VALUE-1? -1:dp[T];


    }
    /*
    方法二：贪心算法
     */

}
