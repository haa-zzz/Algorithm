package com.haa.algorithm.中等;

import java.util.Arrays;

public class 长度最小的子数组 {
    /*
    二分查找算法：
       官方文档:
     private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
     */
   /*
        方法一:前缀和+二分查找
            用一个数组存储给定数组的前缀和，使用二分查找法查找满足要求的子数组
    */
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7
        };

        System.out.println(Arrays.binarySearch(arr,10));
    }
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n+1];
        for(int i =1; i <= n; i++){
            sums[i]  = sums[i-1]+nums[i-1];
        }
        for(int i = 1; i <= n; i++){
            int target = s+sums[i-1];
            int bound = Arrays.binarySearch(sums,target);
            if(bound<0){
                /*二分查找在没有找到时返回值为 -(low+1);
                    如果刚好找到返回对应的下标
                    如果没有找到有三种情况：
                        1.target < 数组最小值 此时返回的应该是-1(这种情况不会出现，因为target = s+sums[i-1])
                        2.target > 数组的最大值， 此时返回的应该是-(sums.length+1),即-(n+2)
                        3.target在中间，比如suns[i]<target<sums[j]  此时返回的是-(j+1)
                 */
                bound = -bound-1;
            }
            if(bound<=n){

                ans = Math.min(ans,bound-(i-1));
            }
        }
        return ans==Integer.MAX_VALUE ? 0:ans;
    }
    /*
    方法二 ：
        双指针
            定义两个指针，start和end分别表示子数组的开始位置和结束位置，维护变量 sum 存储子数组中的元素和
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        int start = 0,end = 0;
        int sum = 0;
        while(end < n){
            sum += nums[end];
            while(sum >= s){
                ans = Math.min(ans,end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }

}
