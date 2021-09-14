package com.haa.algorithm;

public class 魔术索引 {
    /*
    魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/magic-index-lcci
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //方法一:直接暴力
    /*
    public int findMagicIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i==nums[i])
                return i;
        }
        return -1;
    }

     */
    //方法二：优化
    /*
    //如果nums[i]大于i+1,我们就让i加上nums[i] - 1，
    // 这里减1的目的是为了抵消上面for循环中的i++。
   //这里判断的时候为什么是nums[i] > i + 1而不是
   //nums[i] > i ,因为如果num[i]只比i大1的话，
   //直接执行上面的i++就可以了，没必要再执行下面的计算
     */
    /*
    public int findMagicIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i==nums[i])
                return i;
            if(nums[i]>i+1)
                i+=nums[i]-1;
        }
        return -1;
    }

     */
    //方法三:递归
    public int findMagicIndex(int[] nums) {
       return helper(nums,0,nums.length-1);
    }

    private int helper(int[] nums, int i, int i1) {
        if(i>i1)
            return -1;
        int mid = i+(i1-i)/2;
        int res = helper(nums,i,mid-1);
        if(res != -1)
            return res;
        else if(nums[mid]==mid)
            return mid;
        else
            return helper(nums,mid+1,i1);
    }
}
