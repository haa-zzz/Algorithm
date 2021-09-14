package com.haa.链表.链表Java;

import bean.ListNode;

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

/*
第一种：单链表
 */
public class 设计链表_707 {
}
/*
    第一种：用单链表实现
    单链表的数据结构：
    public class ListNode {
          public int val;
          public ListNode next;
          public ListNode(int x) {
              val = x;
              next = null;
          }
    }
 */
class MyLinkedList1 {

    private int length;
    private ListNode head;

    public MyLinkedList1() {
        length = 0;
        head = new ListNode(0);
    }
    public int get(int index) {
        if(index < 0 || index >= length){
            return -1;
        }else{
            ListNode node = head.next;
            while(index!=0){
                node = node.next;
                index--;
            }
            return node.val;
        }
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(length,val);
    }

    public void addAtIndex(int index, int val) {
        if(index<=0){
            index = 0;
        }
        if(index <= length){
            ListNode node = head;
            while(index!=0){
                node = node.next;
                index--;
            }
            ListNode addNode = new ListNode(val);
            addNode.next = node.next;
            node.next = addNode;
            length++;
        }
    }
    public void deleteAtIndex(int index) {
        if(index>=0 && index < length){
            ListNode node = head;
            while(index!=0){
                node = node.next;
                index--;
            }
            node.next = node.next.next;
            length--;
        }
    }

}
/*
    第二种：用双链表实现
    双链表的数据结构：
    public class ListNode {
          public int val;
          public ListNode next;
          public ListNode prev;
          public ListNode(int x) {
              val = x;
          }
    }
    双链表比单链表多了一个prev域，可以指向前面的节点，在插入和删除时先判断离头近还是离尾近，离那个近用那个操作，速度更快
 */
class MyLinkedList2 {
    int length;
    ListNode head, tail;         //伪头，伪尾

    public MyLinkedList2() {
        length = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }


    public int get(int index) {

        if (index < 0 || index >= length) {
            return -1;
        }
        ListNode node;
        //距离那边近从那边找起
        if (index + 1 < length - index) {
            node = head.next;
            while (index != 0) {
                node = node.next;
                index--;
            }
        } else {
            node = tail.prev;
            while (index != length - 1) {
                node = node.prev;
                index++;
            }
        }
        return node.val;
    }


    public void addAtHead(int val) {
        addAtIndex(0, val);

    }


    public void addAtTail(int val) {
        addAtIndex(length, val);
    }


    public void addAtIndex(int index, int val) {

        if (index < 0) {
            index = 0;
        } else if (index > length)
            return;
        ListNode pred, succ;

        if (index + 1 < length - index) {
            pred = head;
            while (index != 0) {
                pred = pred.next;
                index--;
            }
            succ = pred.next;
        } else {
            succ = tail;
            while (index != length) {
                succ = succ.prev;
                index++;
            }
            pred = succ.prev;
        }
        // insertion itself
        ++length;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }


    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length)
            return;
        ListNode pred, succ;
        if (index + 1 < length - index) {
            pred = head;
            while (index != 0) {
                pred = pred.next;
                index--;
            }
            succ = pred.next.next;

        } else {
            succ = tail;
            while (index != length - 1) {
                succ = succ.prev;
                index++;
            }
            pred = succ.prev.prev;

        }
        length--;
        pred.next = succ;
        succ.prev = pred;
    }
}

