package com.haa.algorithm

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int,Int>()
        for(i in nums.indices) {

            if(map.containsKey(target - nums[i])) {
                return intArrayOf(map[target - nums[i]]!! ?: 0, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}