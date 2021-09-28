package com.haa.链表.链表Java;

import bean.ListNode;

public class 旋转链表 {
    /*
    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     */
    /*
    方法：第一次遍历将单链表转换为循环链表，第二次遍历寻找头尾节点。
        时间复杂度 O(N)
        空间复杂度 O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){            //特判
            return head;
        }
        ListNode pre,cur;
        pre = cur = head;
        int length = 0;
        while(head!=null){          //第一次遍历
            length++;               //记录节点的个数
            cur = head;
            head = head.next;
        }
        cur.next = pre;             //将单链表转换为循环链表
        k = k%length;
        int i = length-(k+1);
        while(i!=0){                //第二次遍历寻找旋转后的头尾节点
            pre = pre.next;
            i--;
        }
        ListNode node = pre.next;
        pre.next = null;
        return node;
    }
}
