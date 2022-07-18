package 面试.常用数据结构.LRU;

import java.util.HashMap;

public class LRUJava<T> {

    class DListNode {
        int key;
        T value;
        DListNode prev;
        DListNode curr;

        public DListNode(int key, T value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private final DListNode head;
    private final DListNode tail;
    private int size;
    private final HashMap<Integer, DListNode> cache;

    public LRUJava(int capacity) {
        this.capacity = capacity;
        head = new DListNode(0,null);
        tail = new DListNode(0,null);
        head.curr = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public void put(int key, T value) {
       DListNode node = cache.get(key);
       if(node == null) {
            DListNode newNode = new DListNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size > capacity) {
                DListNode p = removeTail();
                if(p != null) {
                    cache.remove(p.key);
                    size--;
                }
            }

       } else {
            node.value = value;
            moveToHead(node);
       }
    }

    private void moveToHead(DListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DListNode node) {
        node.prev.curr = node.curr;
        node.curr.prev = node.prev;
    }

    private DListNode removeTail() {
        DListNode node = tail.prev;
        if(node == head) {
            return null;
        }
        removeNode(node);
        return node;
    }

    private void addToHead(DListNode newNode) {
        newNode.prev = head;
        newNode.curr = head.curr;
        head.curr.prev = newNode;
        head.curr = newNode;
    }

    public T get(int key) {
        DListNode node  = cache.get(key);
        if(node != null) {
            moveToHead(node);
            return node.value;
        }
        return null;
    }
}
