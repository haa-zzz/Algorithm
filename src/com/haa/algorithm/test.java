package com.haa.algorithm;

import bean.ListNode;

public class test {
    /*
    在一个带头结点的单链表中，头指针为L,如何把倒数第二个结点，插入到头结点的后面第一个工作结点的前面，写出关键伪代码。
     */
    public void fixListNode(ListNode head){
        //双指针找倒数第二个节点,保存在l1中
        ListNode l1 ,l2;
        l1  = head;
        l2 = head.next;
        while(l2!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        //插入
        ListNode node = head.next;
        head.next = l1;
        l1.next = node;
    }
}
