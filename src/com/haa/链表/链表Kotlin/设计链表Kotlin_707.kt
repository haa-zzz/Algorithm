package com.haa.链表.链表Kotlin


/*
    设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，
        next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
        假设链表中的所有节点都是 0-index 的。


    在链表类中实现这些功能：

    get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
            如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
/*
第一种：单链表实现
 */
class MyLinkedList() {
    private val head : ListNode  = ListNode(0)
    private var size : Int = 0
    operator fun get(index: Int): Int {
        var index = index
        if (index in 0 until size) {
            var node = head.next
            while (index > 0) {
                node = node!!.next
                index--
            }
            return node!!.`val`
        }
        return -1
    }

    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }
    fun addAtTail(`val`: Int) {
        addAtIndex(size, `val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        var index = index
        if (index < 0) {
            index = 0
        }
        if (index > size) {
            return
        }
        var node: ListNode? = head
        while (index > 0) {
            node = node!!.next
            index--
        }
        val newNode = ListNode(`val`)
        newNode.next = node!!.next
        node.next = newNode
        size++
    }

    fun deleteAtIndex(index: Int) {
        var index = index
        if (index >= 0 && index < size) {
            var node: ListNode? = head
            while (index > 0) {
                node = node!!.next
                index--
            }
            node!!.next = node.next!!.next
            size--
        }
    }

}
/*
第二种：双链表实现
 */
class DListNode(var `var`: Int){
    @JvmField
    var next : DListNode? = null
    @JvmField
    var prev : DListNode? = null
}

class MyLinkedList1 {
    private val head = DListNode(0)
    private val tail = DListNode(0)
    private var size = 0
    init {
        head.next = tail
        tail.prev = head
    }

    fun get(index: Int): Int {
        if(index < 0 || index >= size){
            return -1
        }
        var index = index
        var node : DListNode
        if(index >= size/2){
            node = tail.prev!!
            while(index != size-1){
                node = node.prev!!
                index++
            }
            return node.`var`
        }else{
            node = head.next!!
            while(index != 0){
                node = node.next!!
                index--
            }
            return node.`var`
        }
    }
    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }
    fun addAtTail(`val`: Int) {
        addAtIndex(size, `val`)
    }
    fun addAtIndex(index: Int, `val`: Int) {
        var index = index
        if(index < 0){
            index = 0
        }
        if(index > size){
            return
        }
        var pre : DListNode
        var curr : DListNode
        if(index >= size/2){
            curr = tail
            while(index != size){
                curr = curr.prev!!
                index++
            }
            pre = curr.prev!!
        }else{
            pre = head
            while (index != 0){
                pre = pre.next!!
                index--
            }
            curr = pre.next!!
        }
        val newNode = DListNode(`val`)
        newNode.prev = pre
        newNode.next = curr
        pre.next = newNode
        curr.prev = newNode
        size++
    }
    fun deleteAtIndex(index: Int) {
        var index = index

        if(index in 0 until size){
            var node : DListNode
            var pre : DListNode
            var curr : DListNode
            if(index >= size/2){
                curr = tail
                while(index != size-1){
                    curr = curr.prev!!
                    index++
                }
                pre = curr.prev!!.prev!!
            }else{
                pre = head
                while( index != 0){
                    pre = pre.next!!
                    index--
                }
                curr = pre.next!!.next!!
            }
            pre.next = curr
            curr.prev = pre
            size--
        }
    }
}