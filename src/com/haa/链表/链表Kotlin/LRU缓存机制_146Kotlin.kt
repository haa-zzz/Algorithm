package com.haa.链表.链表Kotlin

class LRU缓存机制_146Kotlin {
    /*
       运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
       实现 LRUCache 类：

       LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
       int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
       void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
       当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    
       进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
        */
    /*
    分析：双向链表+hash表查找
        算法的关键点在于当缓存容量达到上限时，它要删除之前最久未使用的数据值。
        我们可以用一个哈希表和一个双向链表维护所有在缓存中的键值对。
            双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
            哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。

        时间复杂度O(1),get和put方法的时间复杂度都是O(1)
        空间复杂度O(N)，hash表和双向链表的空间复杂度都为O(N)
     */
    class LRUCache(capacity: Int) {

        internal inner class DlinkedList(val key : Int, var value : Int ){
            @JvmField
            var prev : DlinkedList? = null
            @JvmField
            var curr : DlinkedList? = null
        }

        private var head : DlinkedList
        private var tail : DlinkedList
        private var size : Int
        private val capacity : Int
        private val cache : MutableMap<Int,DlinkedList>
        init {
            //初始化双端链表
            head = DlinkedList(0,0)
            tail = DlinkedList(0,0)
            head.curr = tail
            tail.prev = head

            //初始化Map集合
            cache = HashMap()
            //初始化其他
            size = 0
            this.capacity = capacity
        }

        fun get(key: Int): Int {
            val node = cache[key] ?: return -1
            moveToHead(node)
            return node.value

        }

        fun put(key: Int, value: Int) {
            //先从哈希表中查找
            val node  = cache[key]
            //如果不存在
            if(node == null){
                //判断缓存容量是否达到上限
                val newNode = DlinkedList(key,value)

                if(size == capacity){
                    val rNode = removeTail()
                    cache.remove(rNode.key)
                    size--
                }
                addToHead(newNode)
                cache[key] = newNode
                size++
            }else{
                moveToHead(node)
                node.value = value
            }
        }

        private fun moveToHead(node: DlinkedList) {
            removeNode(node)
            addToHead(node)
        }

        private fun addToHead(newNode: DlinkedList) {
            newNode.prev = head
            newNode.curr = head.curr
            head.curr!!.prev = newNode
            head.curr = newNode
        }

        private fun removeNode(node : DlinkedList){
            node.prev!!.curr = node.curr
            node.curr!!.prev = node.prev
        }

        private fun removeTail(): DlinkedList {
            val node = tail.prev
            removeNode(node!!)
            return node
        }
    }
}