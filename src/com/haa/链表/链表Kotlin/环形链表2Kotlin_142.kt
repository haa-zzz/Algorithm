package com.haa.链表.链表Kotlin

class 环形链表2Kotlin_142 {
    /*
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中
     */
    /**
     * 方法1:哈希表，利用哈希表不能存储重复的原则来存储节点，当前节点存储失败时的节点就是入环点
     * 方法2：快慢指针
     *        设链表外部长度为a,入环点到快慢指针相遇点长度为b,相遇点重新回到入环点长度为c
     *        则:相遇时快指针走过的路程：a+(b+c)*n+b = a+(n+1)b+nc
     *             由于快指针走过的路程是慢指针的2倍有：a+(n+1)b+nc = 2a+2b
     *                                         即:a = c +(n-1)(b+c)
     *             所以在相遇时我们重新用一个指针指向头结点，让他和慢指针一起移动，他们相遇的位置即为入环点
     *        时间复杂度：O(N)
     *        空间复杂度：O(1)
     */
    class Solution {
        fun detectCycle(head: ListNode?): ListNode? {

            var slow = head
            var fast = head
            var node = head
            while(fast != null && fast.next != null){
                slow = slow!!.next
                fast = fast.next!!.next
                if(fast == slow){
                    fast = head
                    while( fast!= slow){
                        fast = fast!!.next
                        slow = slow!!.next
                    }
                    return slow
                }
            }
            return null
        }
    }
}