package com.haa.链表.链表Java;

import bean.ListNode;

public class 链表排序_148 {
    /*
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    进阶：
        你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     */

    /*
    要想在O(n log n)内完成，可以用归并排序的思想来实现。
    归并排序：自顶向下归并排序(递归解法)
    时间复杂度O(n log n)
    空间复杂度O( log n )
     */
    class Solution1{
        public ListNode sortList(ListNode head) {
            //递归的结束条件
            if(head == null || head.next == null ){
                return head;
            }

            //找链表的中点并分割链表
            ListNode midNode = middleNode(head);
            ListNode rightHead = midNode.next;
            midNode.next = null;        //吧链表分割为两个

            ListNode left = sortList(head);
            ListNode right = sortList(rightHead);

            //合并两个有序链表
            return mergeTwoLists(left,right);

        }

        //  找到链表中间节点（876. 链表的中间结点）
        private ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        // 合并两个有序链表（21. 合并两个有序链表）
        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    }
    /*
    方法二：自底向上归并排序
    在刚才的归并排序中，递归需要调用栈空间，可以通过自底向上的归并排序达到O(1)空间复杂度

     */
    class Solution2{
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return head;
            }

            //求链表的长度
            int length = 0;
            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }
            //建立哑节点
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            for (int subLength = 1; subLength < length; subLength <<= 1) {
                ListNode prev = dummyHead, curr = dummyHead.next;
                while (curr != null) {
                    ListNode head1 = curr;
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }
                    ListNode merged = mergeTwoLists(head1, head2);
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummyHead.next;
        }

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
    }
}
