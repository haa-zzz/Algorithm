package com.haa.链表.链表Kotlin

class 相交链表Kotlin_160 {
    /**
    方法二：双指针：
                                            _
                                              - a
                                                -
                                                  -------------
                                                 -      c
                                               -
                                             - b
                                           -

            如图，第一个链表的长度为a+c 第二个链表的长度为b+c
            让两个指针开始时都从各自的表头出发，判断当前是否有交点，如果没有交点，走到末尾时又从另一个的表头出发；

            - 当a==b时(此时遍历一趟就够了，不用走到末尾时又从另一个的表头出发)：
                如果有交点：
                    必会两个一块走到相交的起点
                 如果没有交点
                    两个最后到等于null返回
            - 当a！= b 时(此时让指针走到末尾时又从另一个的表头出发；)
                    如果有交点：
                        在交点处两者的路程： L1:a+c+b   L2:b+c+a
                        此时路程相同，两指针都指向相交的起始节点
                    如果没有交点：
                        当走向末尾时  L1:a+b      L2:b+a
                        此时路程相同，两指针都指向null，返回null
     */
    class Solution {
        fun getIntersectionNode(headA: ListNode?, headB: ListNode?):ListNode? {
            var aHead: ListNode?
            var bHead: ListNode?
            aHead = headA
            bHead = headB
            while (aHead !== bHead) {
                aHead = if (aHead != null) aHead.next else headB
                bHead = if (bHead != null) bHead.next else headA
            }
            return aHead

        }
    }
}