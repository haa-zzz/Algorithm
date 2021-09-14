package com.haa.algorithm.中等;


import bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

    说明：不允许修改给定的链表。

   进阶：
    你是否可以不用额外空间解决此题？
     */
public class 环形链表2 {
    /*
    法一：哈希表储存
        缺点：空间复杂度：O(N)
     */
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if( !set.add(head) ){
                return head;
            }
            head = head.next;
        }
        return null;
    }
    /*
    法二：快慢指针
        设链表外部长度为a,入环点到快慢指针相遇点为b,相遇点到入环点为c
            则:相遇时快指针走过的路程：a+(b+c)*n+b = a+(n+1)b+nc
            由于快指针走过的路程是慢指针的2倍有：a+(n+1)b+nc = 2a+2b
                                        即:a = c +(n-1)(b+c)

            所以在相遇时我们重新用一个指针指向头结点，让他和慢指针一起移动，他们相遇的位置即为入环点

       时间复杂度：O(N)
       空间复杂度：O(1)

     */
    public ListNode detectCycle1(ListNode head) {

        if(head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            if(fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                ListNode prop = head;
                while(prop != slow){
                    prop = prop.next;
                    slow = slow.next;
                }
                return prop;
            }
        }
        return null;
    }

}
