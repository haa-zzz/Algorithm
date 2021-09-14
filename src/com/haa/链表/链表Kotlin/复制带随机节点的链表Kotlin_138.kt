package com.haa.链表.链表Kotlin

fun main(args : Array<String> ) {
   // val dp = Array(n + 1) { IntArray(m + 1) }
    val str = "123"
}
class 复制带随机节点的链表Kotlin_138 {

    class Node(var `val` : Int){
        var next: Node? = null
        var random: Node? = null
    }

    /*
  题目分析：这道题要求我们原封不动的复制给定的链表并返回我们复制的链表，
      如果是一般的链表，我们只需进行一趟遍历申请空间来加节点就好了，
      难点在于还有一个random指针，复制时还要指定这个指针的指向,如何在复制时找到这个指向关系
   */
    class Solution {

        /*
       方法一：使用hashMap来完成复制，要进行两次遍历，第一次时复制每个节点对应的val,第二次进行节点间的串接
        */
        fun copyRandomList(node: Node?): Node? {
            if(node == null)   return null
            val map = HashMap<Node,Node>()
            var p = node
            while(p != null){
                map[p] = Node(p.`val`)
                p = p.next
            }
            p = node
            while(p != null){
                map.get(p)!!.next = map.get(p.next)
                map.get(p)!!.random = map.get(p.random)
                p = p.next
            }
            return map.get(node)
        }
        /*
           方法二：常数空间，不借助 HashMap 也完成克隆，借助HashMap我们可以很容易的找到要复制链表的next和random，
            不借助HashMap,为了能够找到要复制链表的next和random，我们把复制的节点放在原节点之后，
             这样如果当前节点的random的为p,复制节点的random就是p.next
                    先复制：a - a' - b - b' - c - c' - d - d' - null
                    后分离： a' - b' - c' - d' - null
            */
        fun copyRandomList1(node: Node?): Node? {
            if(node == null){
                return null
            }
            //克隆源节点
            var head = node
            while(head != null){
                val p = Node(head.`val`)
                p.next = head.next
                head.next = p
                head = head.next!!.next
            }
            //给random赋值
            head = node
            while(head != null){
                if(head.random != null) head.next!!.random = head.random!!.next
                head = head.next!!.next
            }
            //拆分
            head = node
            val copyhead = head.next
            var copyP = copyhead

            while(copyP!!.next != null){
                head!!.next = head.next!!.next
                head = head.next

                copyP.next = copyP.next!!.next
                copyP = copyP.next!!
            }
            head!!.next = null
            return copyhead
        }
    }
}