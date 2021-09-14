package com.haa.链表.链表Java;

import bean.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 相交链表_160 {
    /*
    编写一个程序，找到两个单链表相交的起始节点。
    注意：
        如果两个链表没有交点，返回 null.
        在返回结果后，两个链表仍须保持原有的结构。
        可假定整个链表结构中没有循环。
        程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     */

    /*
     * 方法一：哈希表，先用哈希表存储一个链表，并尝试用哈希表存储另一个链表，如果可以存储，
     * 则没有重复节点，如果中途存储失败，说明此时的节点为相交的起始节点
     *  弊端：无法做到O(1)内存
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode aHead,bHead;
        aHead = headA;
        bHead = headB;
        while(aHead!=null){
            set.add(headA);
            aHead = aHead.next;
        }
        while(bHead!=null){
            if(set.add(headB)){
                bHead = bHead.next;
            }else{
                return bHead;
            }
        }
        return null;
    }
    /*
    方法二：双指针：
                                            _
                                              - a
                                                -
                                                  -------------
                                                 -      c
                                               -
                                             - b
                                           -

            如图，第一个链表的长度为a+c 第二个链表的长度为b+c
            让两个指针开始时都从各自的表头出发，判断当前是否有交点，如果没有交点，走到末尾时又从另一个的表头出发；

            当a==b时(此时遍历一趟就够了，不用走到末尾时又从另一个的表头出发)：
                如果有交点：
                    必会两个一块走到相交的起点
                 如果没有交点
                    两个最后到等于null返回
            当a！= b 时(此时让指针走到末尾时又从另一个的表头出发；)
                    如果有交点：
                        在交点处两者的路程： L1:a+c+b   L2:b+c+a
                        此时路程相同，两指针都指向相交的起始节点
                    如果没有交点：
                        当走向末尾时  L1:a+b      L2:b+a
                        此时路程相同，两指针都指向null，返回null
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode aHead,bHead;
        aHead = headA;
        bHead = headB;
        while(aHead!=bHead){
            aHead = aHead!=null? aHead.next:headB;
            bHead = bHead!=null? bHead.next:headA;
        }
        return aHead;

    }

}
