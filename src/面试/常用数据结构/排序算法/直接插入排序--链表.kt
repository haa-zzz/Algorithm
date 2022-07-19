package 面试.常用数据结构.排序算法

import autumnMovesMustWin.nextPermutation
import bean.ListNode

//单链表直接插入排序

/*
分析：
    思路：创建带哑结点的链表，每次拿一个节点往里插，为了方便插入，我们用一个指针lastSorted指向拍好序的最后一个节点，
    用另一个指针curr指向待排节点，分两种情况讨论，插入节点 大于 最后一个节点 直接插入  ，否则遍历寻找插入节点

    时间复杂度O(N^2)
    空间复杂度O(1)
 */
fun insertionSort(head: ListNode?): ListNode? {
    if (head?.next == null)
        return head
    val node = ListNode(0)
    //最后一个排好序的节点
    var lastSortNode = head
    //待排节点
    var curr = head.next

    node.next = lastSortNode

    while (curr != null) {
        if (lastSortNode!!.`val` < curr.`val`) {
            lastSortNode = lastSortNode.next
        } else {
            var pre = node
            while (curr.`val` > pre.next.`val`) {
                pre = pre.next
            }
            lastSortNode.next = curr.next
            curr.next = pre.next
            pre.next = curr
        }
        curr = lastSortNode!!.next
    }
    return head.next
}