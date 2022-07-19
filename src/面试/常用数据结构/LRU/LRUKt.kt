package 面试.常用数据结构.LRU

class LRUCache(capacity: Int) {

    inner class DlinkedList(val key : Int, var value : Int ){
        var prev : DlinkedList? = null
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
