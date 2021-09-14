package com.haa.链表.链表Java;

import bean.ListNode;

public class 奇偶链表 {
    /*
    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，
        而不是节点的值的奇偶性。
    请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     */

    /**
    方法：把两个看做一组，两个指针开始时指向上一个对应的奇偶节点，一组完成，添加新的奇偶节点进链表并把两指针后移，最终实现把链表分成奇偶链表
     */
    public ListNode oddEvenList(ListNode head) {
        if(head==null ){
            return head;
        }
        ListNode pre = head;                            //奇指针开始指向第一个奇节点
        ListNode cur = head.next;                       //偶指针开始指向第一个偶节点
        ListNode node = cur;

        while(cur!=null && cur.next!=null){             //进行一组遍历

            pre.next = cur.next;                        //新的奇节点加入奇链表
            pre = pre.next;                             //更新奇指针
            cur.next = pre.next;                        //新的偶节点加入偶链表
            cur = cur.next;                             //更新偶指针
        }
        pre.next = node;                               //把偶链表连在奇链表之后
        return head;
    }
}
