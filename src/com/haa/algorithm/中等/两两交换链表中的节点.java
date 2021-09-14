package com.haa.algorithm.中等;

import bean.ListNode;

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class 两两交换链表中的节点 {

    public static void main(String[] args){

        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;

        ListNode node = swapPairs(listNode1);

        System.out.println(node.next.val);


    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);

        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {

            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;

    }
}
