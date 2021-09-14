package com.haa.链表.链表Java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU缓存机制_146 {
    /*
    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
    实现 LRUCache 类：

    LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
    当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
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

    class LRUCache {
        /*
        双向链表的数据结构
         */
        class DLinkedNode{
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private Map<Integer,DLinkedNode> cache;
        private int size;
        private int capacity;
        private DLinkedNode head,tail;

        public LRUCache(int capacity) {
            cache = new HashMap<>();
            this.capacity = capacity;
            //创建伪头和伪尾
            head = new DLinkedNode(0,0);
            tail = new DLinkedNode(0,0);
            //建立链接关系
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if(node == null){
                return -1;
            }
            //此时对这个数据进行了访问，所以要把他调整到表头
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if(node == null){         //没有重复
                DLinkedNode newNode = new DLinkedNode(key,value);
                cache.put(key,newNode);
                addToHead(newNode);
                size++;
                if(size > capacity){        //此时超过最大容量了，要删除最久没用过的，即就是表尾的
                    DLinkedNode p = removeTail();
                    cache.remove(p.key);
                    size--;
                }
            }else{          //此时是添加重复的元素,需要删除原来的，并更新value放在表头
                node.value = value;     //修改value
                moveToHead(node);
            }
        }
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
        private void addToHead(DLinkedNode newNode) {
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
        }
    }
    /*
    LinkedHashMap实现
     */
    class LRUCache1 extends LinkedHashMap<Integer,Integer> {
        private int capacity;
        public LRUCache1(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


}
