package com.haa.链表.链表Java;

import bean.ListNode;

public class 对链表进行插入排序 {
    /*
    对链表进行插入排序。

    插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
    每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

    插入排序算法：

    插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    重复直到所有输入数据插入完为止。
     */

    /*
    分析：
        思路：创建带哑结点的链表，每次拿一个节点往里插，为了方便插入，我们用一个指针lastSorted指向拍好序的最后一个节点，
        用另一个指针curr指向待排节点，分两种情况讨论，插入节点 大于 最后一个节点 直接插入  ，否则遍历寻找插入节点

        时间复杂度O(N^2)
        空间复杂度O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode node = new ListNode(0);
        //排好序的最后一个节点           待排节点
        ListNode lastSorted = head, curr = head.next;
        node.next = lastSorted;

        while(curr != null){
            //如果是待排节点 > 排好序的最后一个节点，直接插入
            if(lastSorted.val < curr.val){
                lastSorted = lastSorted.next;
             //否则，从头开始遍历
            }else{
                ListNode pre = node;
                while(pre.next.val < curr.val){
                    pre = pre.next;
                }
                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastSorted.next;
        }
        return node.next;
    }
}
