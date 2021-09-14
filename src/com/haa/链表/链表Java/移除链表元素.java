package com.haa.链表.链表Java;

import bean.ListNode;

public class 移除链表元素 {



    /*
        删除链表中等于给定值 val 的所有节点。

     */
    /*
        需要注意的地方：
            1.为了不增加额外的判断，要给链表增添哨兵节点,即带头节点的链表
            2.删除一个节点后不能直接跳到下一节点，因为可能有相连的待删除节点
     */

    public ListNode removeElements(ListNode head, int val) {

        ListNode rehead = new ListNode(0);          //哨兵节点
        ListNode rehead1 = rehead;

        rehead.next = head;

        while(rehead.next!=null){
            if(rehead.next.val==val){

                rehead.next = rehead.next.next;     //删除
            }else {
                rehead = rehead.next;               //后移
            }
        }
        return rehead1.next;
    }
}
