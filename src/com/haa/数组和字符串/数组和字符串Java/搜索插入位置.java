package com.haa.数组和字符串.数组和字符串Java;

/*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。
 */
public class 搜索插入位置 {


    //解法----二分查找
    public int searchInsert(int[] nums, int target) {
        int n =nums.length;
        int left = 0, right = n-1,ans = n;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                ans = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return ans;

    }
     /*
    //自己的做法：
    // 缺点：1，内存较大
    //      2，如果改成有重复元素返回最小索引就出错
    public int searchInsert(int[] nums, int target) {
        Set<Integer> set  = new TreeSet<>();
        for(int num:nums){
            set.add(num);
        }
        set.add(target);
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)==target)
                return i;
        }
        return 0;

    }
     */

}
