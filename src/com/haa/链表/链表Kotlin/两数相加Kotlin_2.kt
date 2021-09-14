package com.haa.链表.链表Kotlin

class 两数相加Kotlin_2 {
    /*
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    /*
        方法：模拟
            根据两数相加的特性，由于链表存的是逆序的数字，所以可直接同时遍历两链表，把对应位的数字相加，在加上进位，就是当前节点对应值
            注意：1.如果在遍历中一个链表为变为null,则他对应的数字应为0
                 2.在遍历结束后，如果进位的数不为零，应在添加一个节点
     */
    class Solution {
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var head : ListNode? = null
            var tail : ListNode? = null
            var number = 0
            var l1 = l1
            var l2 = l2
            while(l1 != null || l2 != null){
                val number1 = if(l1==null) 0 else l1.`val`
                val number2 = if(l2==null) 0 else l2.`val`
                val node = ListNode( (number1+number2+number)%10 )
                number = (number + number1 + number2) / 10
                if( head == null){
                    head = node
                }
                else{
                    tail!!.next = node
                }
                tail = node
                if(l1 != null){
                    l1 = l1.next
                }
                if(l2 != null){
                    l2 = l2.next
                }
            }
            if(number == 1){
                tail!!.next = ListNode(1)
            }
            return head
        }
    }

}