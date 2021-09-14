package com.haa.数组和字符串.数组和字符串Kotlin

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashSet


class 最长连续序列128_Kotlin {
    /*
    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     */
    class Solution {
        /*
            首先想到的就是排序+动态规划，首先排序，然后定义dp记录当前元素的最长序列。维护一个最大值最后返回。
            但是排序的时间复杂度是o( n*Log(n) ),不符合要求。
         */
        fun longestConsecutive(nums: IntArray): Int {
            val n = nums.size
            if (n == 0) {
                return 0
            }
            Arrays.sort(nums)

            var dp = 1
            var max = 1
            for (i in 1 until n) {
                if (nums[i] - nums[i - 1] == 1) {
                    dp++
                } else if (nums[i] == nums[i - 1]) {
                    continue
                } else {
                    dp = 1
                }
                max = dp.coerceAtLeast(max)
            }
            return max
        }
    }
    class Solution1 {
        /*
        官方的题解是借助 哈希表，这样的好处有两点 1.自动去除重复 2.查找元素的复杂度为O(1)
        首先我们用哈希表存储数组的元素。然后遍历数组，以当前数为起点，做内层遍历。如果它的下一个连续数在哈希表中存在，就将对应的当前序列数加1。最后更新最大值；

        进一步优化：我们最终是要最长的连续序列，所以只需要从没有前驱的节点找起。这样之后，每个节点一定只会被访问一次，复杂度达到了O(n)
        时间复杂度 O(n)
        空间复杂度O(n)
         */
        open fun longestConsecutive(nums: IntArray): Int {
            val set = HashSet<Int>()
            var max = 0
            for( num in nums) set += num
            for(num in nums){
                //找没有前驱的节点
                if( !set.contains(num-1) ){
                    var count  = 1
                    var number  = num+1
                    //内层循环找从当前数开始的连续序列
                    while(set.contains(number)){
                        count++
                        number++
                    }
                    max = Math.max(max,count)
                }
            }
            return max
        }
    }
}