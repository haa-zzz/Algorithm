package autumnMovesMustWin

import bean.ListNode

/*
  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    力抠： 21
   */
/**
方法1：迭代,由于两个链表都是升序的，迭代的每一趟只要判断当前那个小，就添加到合并链表中，并把对应指针后移，
    需要注意的是，迭代完成后，还要添加没有被遍历到的节点
    时间复杂度O(m+n)
    空间复杂度O(1)
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val node = ListNode(0)
    var tail = node
    var p1 = list1
    var p2 = list2
    while(p1 != null && p2 != null) {
        val next = if(p1.`val` < p2.`val`) {
            val node = p1
            p1 = p1.next
            node
        } else {
            val node = p2
            p2 = p2.next
            node
        }
        tail.next = next
        tail = tail.next
    }
    tail.next = p1 ?: p2
    return node.next
}

/**
 * 递归，两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并。
    时间复杂度O(m+n)
    空间复杂度O(m+n)
 */
fun mergeTwoListsByMethod2(list1: ListNode?, list2: ListNode?): ListNode? {
    return when {
        list1 == null -> {
            list2
        }
        list2 == null -> {
            list1
        }
        list1.`val` < list2.`val` -> {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
        }
        else -> {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
        }
    }

}