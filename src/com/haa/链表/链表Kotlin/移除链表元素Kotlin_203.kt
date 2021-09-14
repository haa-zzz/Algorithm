package com.haa.链表.链表Kotlin

class 移除链表元素Kotlin_203 {
    /*
    给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     */
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dumbNode = ListNode(0)
        dumbNode.next = head
        var node = dumbNode
        while(node.next != null){
            if( node.next!!.`val` == `val` ){
                node.next = node.next!!.next
            }else{
                node = node.next!!
            }
        }
        return dumbNode.next
    }
}