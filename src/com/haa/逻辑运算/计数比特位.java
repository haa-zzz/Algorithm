package com.haa.逻辑运算;

public class 计数比特位 {
    /*
    给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     */
    /*
    方法1.直接写一个函数来计算每一个数字对应的1的个数，利用按位与运算快速计算1的个数
        对于任意整数 x，令 x = x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0。
     */
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        for(int i = 0; i <= num; i++){
            arr[i] = funBits(i);
        }
        return arr;
    }

    private int funBits(int x) {
        int ans = 0;
        while(x != 0){
            x &= (x-1);
            ans++;
        }
        return ans;
    }
    /*
    方法2.也是位运算的思想，对数的每一位和1相与，为了囊括所有的数，需要32位，时间复杂度O(32N)
     */
    public int[] countBits1(int num) {
        int[] arr = new int[num+1];
        for(int i = 0; i <= num; i++){
            arr[i] = funBits1(i);
        }
        return arr;
    }

    private int funBits1(int x) {
        int ans = 0;
        for(int i = 0; i < 32; i++) ans += x>>i & 1;
        return ans;
    }

    /*
    方法3.动态规划———低位有效
        第 1 步：定义状态
            dp[i]:表示i对应的二进制中1的个数
        第 2 步：思考状态转移方程
           dp[i] = dp[i>>1] + (i&1)
           对于dp[i]如果dp[i>>1]已经知道了，我们只要知道最高位是否为1，是1就加上，
        第 3 步：考虑初始化
            dp[0] = 0,0对应的二进制中1的个数为0
        第 4 步：考虑输出
            最后的输出结果为dp[num]
     */
    public int[] countBits2(int num) {
        int[] dp = new int[num+1];
        for(int i = 1; i <= num; i++){
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }
    /*
    方法4.动态规划———最低设置位
    和刚才的思路一样，只是状态转移方程不同，
        dp[i] = dp[i&(i-1)] +1;     先找到将i的最低位设置位0对应的二进制中1的个数然后加1
     */
    public int[] countBits3(int num) {
        int[] dp = new int[num+1];
        for(int i = 1; i <= num; i++){
            dp[i] = dp[i&(i-1)] + 1;
        }

        return dp;

    }
}
