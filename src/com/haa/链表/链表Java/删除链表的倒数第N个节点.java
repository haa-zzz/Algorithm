package com.haa.链表.链表Java;

import bean.ListNode;

public class 删除链表的倒数第N个节点 {
    /*
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    说明：给定的 n 保证是有效的。
    进阶：你能尝试使用一趟扫描实现吗？
     */
    /*
        方法：双指针  记链表的总长为L，       ------------|------
                                              L-n        n
                                         ------|------------
                                            n        L-n
        首先,让P1指针先走n次,那么剩余没走的长度就是L-n,此时让节点P2从起点出发，当P1走到末尾时，P2刚好走到要删除的节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p1 = head;
        ListNode p2 = node;
        for(int i = 1; i <= n; i++) {            //P1先走n个节点
            p1 = p1.next;
        }
        while(p1 != null){     //p1继续走，p2从头节点出发
            p1 = p1.next;   // 注意：如果正常两个一块走，最后p2刚好走到要删除的节点，但是在删除时我们要找的是删除节点的前驱节点，所以需要让他少走一步
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return node.next;
    }
}
