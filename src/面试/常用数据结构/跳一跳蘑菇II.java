package 面试.常用数据结构;

public class 跳一跳蘑菇II {
    /*
       有n个格子，每个格子上有一 个蘑菇，蘑菇分为好蘑菇和毒蘑菇，好蘑菇增加体力值, 坏蘑菇减少体力值
       2、人的初始体力值为m 人从格子外开始跳，每次跳消耗体力值为距离的平方
       问题1： 判断是否可以跳到终点？ 如果可以返回最大剩余体力值
       问题2： 返回跳到终点的路径
        输入： 初始体力值m 和 蘑菇值序列 arrays
        case:
        array=[1, 2, -3, 4, 5, 6]  m = 5

        //dp思想：dp[i]定义为到达位置i还剩的最大体力值
        动态转移方程：x = max(dp[j] - (i-j) * (i-j)) 0 <= j < i, x >= 0说明能跳到,
            则 dp[i] = x + array[i-1]；否则跳不到i，退出循环，
     */
    static class Solution {
        public int canJump(int m, int[] arr) {
            int n = arr.length;
            int[] dp = new int[n+1];
            dp[0] = m;  //还在格子外，体力值为m
            for(int i = 1; i <= n; i++) {
                int x = 0;
                for(int j = 0; j < i; j++) {
                    x = Math.max(x, dp[j] - (i-j) * (i-j));
                }
                if(x <= 0) {
                    return -1;
                }
                dp[i] = x + arr[i-1];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(5, new int[]{1,2,-3,4,5,6}));
    }

}
