package com.haa.链表.链表Kotlin

class 环形链表Kotlin_141 {

    /*
   给定一个链表，判断链表中是否有环。
   如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
   我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
   注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
   如果链表中存在环，则返回 true 。 否则，返回 false 。
   链接：https://leetcode-cn.com/leetbook/read/linked-list/jbex5/
    */
    /**
        题解：这个题有两种解法，
            第一：用哈希表存储每一个节点，根据哈希表不能存储重复的原则得到是否有环
            第二：快慢指针，让fast指针一次移动两个节点，slow一次移动一个节点，如果没有环，快指针一定先移动到尾节点指向null，此时即可说明没有环，
                    如果有环，那么快慢指针一定在某个节点相遇，相遇时，快指针比慢指针多走L(环的长度)
                 时间复杂度O(N)
                 空间复杂度O(1)
     */
    class Solution{
        fun hasCycle(head: ListNode?): Boolean {
            var slow = head
            var fast = head
            while(fast?.next != null){
                slow = slow?.next
                fast = fast.next?.next
                if(slow == fast){
                    return true
                }
            }
            return false

        }
    }
}