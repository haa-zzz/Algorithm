package com.haa.数组和字符串.数组和字符串Java;

public class 长度最小的子数组 {
    /*
    给定一个含有 n 个正整数的数组和一个正整数 target 。
    找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
        并返回其长度。如果不存在符合条件的子数组，返回 0 。

        示例 1：

        输入：target = 7, nums = [2,3,1,2,4,3]
        输出：2
         解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */
    /*
        分析：滑动窗口
        定义两个指针 start 和 end 分别表示子数组（滑动窗口窗口）的开始位置和结束位置，维护变量 sum 存储子数组中的元素和
        开始时，start和end 都是0
        每一轮迭代，将 nums[end] 加到 sum，如果 sum≥s，则更新子数组的最小长度（此时子数组的长度是 end-start+1），
        然后将 nums[start] 从 sum 中减去并将 start 右移，直到 sum<s，在此过程中同样更新子数组的最小长度。
        在每一轮迭代的最后，将 end 右移。


     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;    //记录最终的值
        while(end < n){
            sum+=nums[start] ;
            while(sum >= s){
                ans = Math.min(ans,end-start+1);    //更新ans
                sum-=nums[start];
                start++;
            }
            end++;
        }
        return ans==Integer.MAX_VALUE ? 0:ans;
    }

}
