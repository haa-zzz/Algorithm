package com.haa.链表.链表Java;

import bean.ListNode;

public class 合并两个有序链表_21 {
    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    /*
    方法1：迭代,由于两个链表都是升序的，迭代的每一趟只要判断当前那个小，就添加到合并链表中，并把对应指针后移，
    需要注意的是，迭代完成后，还要添加没有被遍历到的节点
    时间复杂度O(m+n)
    空间复杂度O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);            //定义合并链表并设置哨兵节点，方便操作
        ListNode headNode = node;

        while(l1!=null && l2!=null){                   //遍历

            if(l1.val < l2.val){
                headNode.next = l1;
                l1 = l1.next;
            }else{
                headNode.next = l2;
                l2 = l2.next;
            }
            headNode = headNode.next;
        }

        headNode.next = l1==null?l2:l1;                 //添加未被遍历到的节点

        return node.next;
    }
    /*
    方法2.递归，两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并。
    时间复杂度O(m+n)
    空间复杂度O(m+n)
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
