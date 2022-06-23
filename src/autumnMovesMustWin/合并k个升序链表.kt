package autumnMovesMustWin

import bean.ListNode
import java.util.*

/*
 *  给你一个链表数组，每个链表都已经按升序排列。
    请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *   力抠：23
 */
/**
 *方法1：在 合并两个有序链表 的思想上，考虑每次顺序合并两个有序链表。
        时间复杂度:假设每个链表的最长长度为n,那么时间复杂度为O(K^2 * n)
        空间复杂度O(1)
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var list: ListNode? = null
    lists.forEach {
        list = mergeTwoLists(list, it)
    }
    return list
}

/**
 *方法2： 分治合并
 *  在上面的基础上，用分治的方法进行合并。和归并排序有点想。将K个链表两两配对，
    这一趟合并完后，剩余K/2个待合并的链表，然后是K/4, K/8 .....
        时间复杂度O(Kn * log K)
        空间复杂度O(log k)
 */
fun mergeKListsByMethod2(lists: Array<ListNode?>): ListNode? {
    return mergeSort(lists, 0, lists.size - 1)
}
private fun mergeSort(lists: Array<ListNode?>, left: Int, right: Int): ListNode?{
    return when {
        left == right -> {
            lists[left]
        }
        left > right -> {
            null
        }
        else -> {
            val mid = left + (right - left) / 2
            mergeTwoLists(mergeSort(lists, left, mid), mergeSort(lists, mid + 1, right))
        }
    }
}

/**
 * 使用优先队列合并
        按链表头的val从小到大的顺序维护一个优先队列。每次从队列里poll出最小的链表，把此链表的头添加到排序好的链表表尾，
        然会把此链表的下一个节点作为头添加进优先队列。直到链表为空
        时间复杂度O(kn * log k)
        空间复杂度O(k)
 */
fun mergeKListsByMethod3(lists: Array<ListNode?>): ListNode? {
    val n = lists.size
    if(n == 0) return null
    if(n == 1) return lists[0]
    val queue = PriorityQueue<ListNode>(n) {p1, p2 -> p1.`val` - p2.`val`}
    lists.forEach {
        if(it != null) {
            queue.offer(it)
        }
    }
    val dumbNode = ListNode(0)
    var head = dumbNode
    while(queue.isNotEmpty()) {
        val node = queue.poll()
        head.next = node
        head = head.next
        if(node.next != null) {
            queue.add(node.next)
        }
    }
    return dumbNode.next
}





