package com.haa.链表.链表Java;

import bean.ListNode;

public class 删除排序链表中的重复元素II {
    /*
    给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) return null;
            ListNode dummy = new ListNode(0);
            ListNode pre = dummy;
            pre.next = head;
            ListNode cur = head;
            while(cur != null && cur.next != null){
                if(cur.val == cur.next.val){    //有重复
                    int val = cur.val;
                    while(cur != null && cur.val == val){       //检索完所有重复
                        cur = cur.next;
                    }
                    pre.next = cur;     //改变指向关系
                }else{
                    pre = cur;      //后移
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
}
