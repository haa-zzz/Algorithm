package com.haa.链表.链表Kotlin

class 奇偶链表Kotlin_328 {
    class Solution {
        /*
           给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，
               而不是节点的值的奇偶性。
           请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
            */

        /**
        方法：把两个看做一组，两个指针开始时指向上一个对应的奇偶节点，一组完成，添加新的奇偶节点进链表并把两指针后移，
        最终实现把链表分成奇偶链表
         */
        fun oddEvenList(head: ListNode?): ListNode? {
            val oddNode  = ListNode(0)
            val evenNode = ListNode(0)

            var list1 = oddNode
            var list2 = evenNode
            var node = head

            while(node?.next != null){
                list1.next = node
                list2.next = node.next
                list1 = list1.next!!
                list2 = list2.next!!
                node = node.next!!.next
            }
            if(node != null){
                list1.next = node
                list1 = list1.next!!
            }
            list2.next = null
            list1.next = evenNode.next
            return oddNode.next
        }
    }
}