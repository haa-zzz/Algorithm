package com.haa.algorithm.简单;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数之和 {
    /*
    方法一:暴力法
     */
    /*
    方法二:哈希表
        分析：哈希表不会存储重复，我们只要边添加边判断表中是否存在 target-x
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
       return null;
    }

}
