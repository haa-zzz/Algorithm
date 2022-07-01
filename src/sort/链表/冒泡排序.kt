package sort.链表

import bean.ListNode

/**
 * 链表实现冒泡排序
 * 冒泡排序：重复走访要排序的数列，一次比较两个元素，若较小元素在后则交换，能看到越小的元素会经由交换慢慢浮到数列的顶端
 * <p>
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 稳定性：稳定排序
 */
fun bubbleSortByLinked(head: ListNode){
    val dumbNode = ListNode(0)      //建立哑节点
    dumbNode.next = head

    var pre = dumbNode.next         //一次比较的两个元素
    var cur: ListNode? = pre.next ?: return

    var upperNode = dumbNode    //pre,cur的前面一个元素，用来pre,cur的交换

    var lastNode: ListNode? = null  //排好序的最后一个节点

    var isChanged = false

    while(head.next != lastNode) {

        //当下一个节点为一次次排序的最后一个节点时，本次排序结束。
        if (cur === lastNode) {
            //在一趟结束后判断是否这一趟有交换
            if (!isChanged) {
                break
            }
            isChanged = false       //重置操作
            lastNode = pre
            pre = dumbNode.next     //pre重新指向第一个元素
            upperNode = dumbNode    //upperNode指向哑节点
        } else if (cur!!.`val` < pre.`val`) {   //交换
            isChanged = true
            pre.next = cur.next
            cur.next = pre
            upperNode.next = cur
            upperNode = cur
        } else {
            upperNode = pre
            pre = pre.next
        }
        cur = pre.next
    }
}