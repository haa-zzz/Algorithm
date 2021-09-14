package com.haa.链表.链表Java;

import bean.ListNode;

public class 反转链表 {
    /*
    反转一个单链表。
    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    /*
    迭代法:反转链表，只需反转链表之间的指向关系即可,具体的做法是用双指针，一个在前，一个在后，每一趟的迭代，让后面的节点指向前面的节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;                //定于pre指针在前
        ListNode cur = head;                //定义cur在后
        while(cur!=null){
            ListNode node = cur.next;       //重新用一个链表来保存后面的节点
            cur.next = pre;                 //改变指向关系
            pre = cur;                      //一趟结束，两指针后移
            cur = node;
        }
        return pre;
    }
    /*
    递归法：递归的解法是一种回溯的过程,从最后面开始向前加节点，比如对于链表  1->2->3->4->5->null来说
                    reverseList(1)      reverseList(2)       reverseList(3)     reverseList(4)      reverseList(5)

     return的p   5->4->3->2->1->null    5->4->3->2-null        5->4->3-null        5->4->null         5->null
     */
    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) {        //递归的边界条件
            return head;
        }
        ListNode p = reverseList1(head.next);           //向下递归
        head.next.next = head;                          //回溯时添加节点
        head.next = null;
        return p;
    }
}
