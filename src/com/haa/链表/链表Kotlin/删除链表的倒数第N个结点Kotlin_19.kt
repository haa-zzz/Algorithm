package com.haa.链表.链表Kotlin

class 删除链表的倒数第N个结点Kotlin_19 {
    /*
   给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
   说明：给定的 n 保证是有效的。
   进阶：你能尝试使用一趟扫描实现吗？
    */
    /*
        方法：双指针  记链表的总长为L，       ------------|------
                                              L-n        n
                                         ------|------------
                                            n        L-n
        首先,让P1指针先走n次,那么剩余没走的长度就是L-n,此时让节点P2从起点出发，当P1走到末尾时，P2刚好走到要删除的节点
     */

    class Solution {

        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

            val node = ListNode(0)
            node.next = head
            var p1  = head
            var p2 = node
            for(i in 1..n){
                p1 = p1!!.next
            }
            while(p1 != null){
                p1 = p1.next
                p2 = p2.next!!
            }
            p2.next = p2.next!!.next
            return node.next
        }
    }
}