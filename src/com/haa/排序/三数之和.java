package com.haa.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    /*
    给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
     */
    /*
    方法：排序 + 双指针
        先对数组进行排序，排序后固定一个数 nums[i]，
        再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
        注意：
        1. 如果nus[i] > 0, 三数之和必然大于0，结束循环
        2. 如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
        3. 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
        4. 当 sum == 0时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R−-

        时间复杂度O( N ^ 2 )
        空间复杂度O( logN )
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int n = nums.length;
        if(n < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;           //去重
            }
            int left = i+1, right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;       //去重
                    while(left < right && nums[right] == nums[right-1]) right--;    //去重
                    left++;
                    right--;
                }
                else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
