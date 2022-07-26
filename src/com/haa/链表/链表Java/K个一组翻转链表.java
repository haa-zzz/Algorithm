package com.haa.链表.链表Java;

import bean.ListNode;

public class K个一组翻转链表 {
    /*
    根据题意进行k次翻转，往后遍历，每次找到要翻转的部分，然后进行翻转
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode dummy = new ListNode(0);  //哑节点。
            dummy.next = head;
            ListNode pre = dummy;   //pre指向每次要翻转的链表的头结点的上一个节点
            ListNode end = dummy;   //end指每次要翻转的链表的尾节点
            while(end.next != null){
                for(int i = 1; i <= k && end != null; i++){ //循环k次，找到需要翻转的链表的结尾
                    end = end.next;
                }
                if(end==null) break; //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
                ListNode next = end.next; //先记录下end.next,方便后面链接链表
                end.next = null;  //然后断开链表
                ListNode start = pre.next;     //要翻转链表的头节点
                pre.next = reverse(start);    //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
                start.next = next;    //翻转后头节点变到最后。通过.next把断开的链表重新链接。
                pre = start;    //更新pre
                end = start;  //更新end
            }
            return dummy.next;
        }
        //翻转
        public ListNode reverse(ListNode head) {
            //单链表为空或只有一个节点，直接返回原单链表
            if (head == null || head.next == null){
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = null;
            while (cur != null){
                next = cur.next;
                cur.next= pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
