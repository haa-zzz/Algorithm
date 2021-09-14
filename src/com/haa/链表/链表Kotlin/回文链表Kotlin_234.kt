package com.haa.链表.链表Kotlin

import java.util.*

class 回文链表Kotlin_234 {
    class Solution {
        /**
        方法1：双指针+链表反转：快指针走到末尾，慢指针刚好到中间。其中慢指针将前半部分反转。然后比较。
        时间复杂度O(n),空间复杂度O(1)
         */
        fun isPalindrome(head: ListNode?): Boolean {
            if (head?.next == null){
                return true
            }
            var fast = head
            var slow = head
            var pre: ListNode? = null
            var cur = head
            while(fast?.next != null){
                slow = slow!!.next
                fast = fast.next!!.next
                cur!!.next = pre
                pre =cur
                cur = slow
            }
            if(fast != null){
                slow =  slow!!.next
            }
            while(slow != null){
                if(slow.`val` != pre!!.`val`) return false
                slow = slow.next
                pre = pre.next
            }
            return true
        }
        /**
        方法2：把链表中的节点值拿出来放在集合里判断，
        时间复杂度O(n) 空间复杂度O(n)
         */
        open fun isPalindrome1(head: bean.ListNode?): Boolean {
            var head = head
            val list = ArrayList<Int>()
            while (head != null) {
                list.add(head.`val`)
                head = head.next
            }
            var left = 0
            var right = list.size - 1
            while (left < right) {
                if (list[left] != list[right]) {
                    return false
                }
                left++
                right--
            }
            return true
        }
    }
}