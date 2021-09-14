package com.haa.数组和字符串.数组和字符串Java;

public class 连续最大1的个数 {
    /*
    给定一个二进制数组， 计算其中最大连续 1 的个数。

     */
    /*
    分析：遍历，用maxone记录最大1的个数，在遍历中当最大1的个数大于这个值是更新即可
    时间复杂度O(N)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxone = 0;
        for(int i = 0; i < nums.length; i++){
            int j = 0;
            while(i<nums.length && nums[i]==1){
                i++;
                j++;
            }
            if(j > maxone){
                maxone = j;
            }
        }
        return maxone;

    }
}
