package com.haa.链表.链表Kotlin

class 反转链表Kotlin_203 {
    /*
    定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
     */
    /*
  迭代法:反转链表，只需反转链表之间的指向关系即可,具体的做法是用双指针，一个在前，一个在后，每一趟的迭代，让后面的节点指向前面的节点
   */
    fun reverseList(head: ListNode?): ListNode? {
        var pre : ListNode? = null
        var cur = head
        while(cur != null){
            var node = cur.next
            cur.next = pre
            pre = cur
            cur = node
        }
        return pre
    }
}