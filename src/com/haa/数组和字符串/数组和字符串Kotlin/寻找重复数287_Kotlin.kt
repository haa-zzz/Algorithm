package com.haa.数组和字符串.数组和字符串Kotlin

class 寻找重复数287_Kotlin {
    /*
    给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
    假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
    你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。

    进阶：
        如何证明 nums 中至少存在一个重复的数字?
        你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 */
    /*
    分析：可以排序后查找，但是时间复杂度O( nlogn )不符合要求
    解法：快慢指针
        和链表里面寻找入环点解法相同
        以 i -> nums[i] -> [ nums[i] ] -> .... 建立链表，如果有重复数，那么一定存在环，就可以按【环形链表2Kotlin_142】这道题来做
     */
    class Solution {
        fun findDuplicate(nums: IntArray): Int {
            //快慢指针
            var fast = 0
            var slow = 0
            do{
                fast = nums[ nums[fast] ]
                slow = nums[ slow ]
            }while(slow != fast)
            slow = 0
            while(slow != fast){
                slow = nums[slow]
                fast = nums[fast]
            }
            return slow

        }
    }
}