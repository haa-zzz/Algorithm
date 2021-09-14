package com.haa.数组和字符串.数组和字符串Kotlin

import java.util.*

class 数组中的第K个最大元素 {
    class Solution {
        fun findKthLargest(nums: IntArray, k: Int): Int {
            Arrays.sort(nums)
            val n = nums.size
            return nums[n-k]
        }
    }
}