package autumnMovesMustWin

import bean.ListNode

/*
给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0开头。

力扣2
 */
/**
 *  方法：模拟
 *   根据两数相加的特性，由于链表存的是逆序的数字，所以可直接同时遍历两链表，把对应位的数字相加，在加上进位，就是当前节点对应值
 *   注意：1.如果在遍历中一个链表为变为null,则他对应的数字应为0
 *   2.在遍历结束后，如果进位的数不为零，应在添加一个节点
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var head: ListNode? = null
    var tail = head
    var number = 0
    var l1 = l1
    var l2 = l2
    while(l1 != null || l2 != null) {
        val number1 = l1?.`val` ?: 0
        val number2 = l2?.`val` ?: 0
        val node = ListNode((number + number1 + number2) % 10)
        number = (number + number1 + number2) / 10
        if(head == null) {
            head = node
        } else {
            tail?.next = node
        }
        tail = node

        l1 = l1?.next
        l2 = l2?.next
    }
    if(number != 0) {
        tail?.next = ListNode(number)
    }
    return head
}
/**
 * java
 *
 */
/*
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head,tail;             //相加链表的头节点和指向尾部的节点
    head = tail = null;
    int number = 0;                 //进位数
    while(l1!=null || l2!= null){

        int number1 = l1==null?0:l1.val;
        int number2 = l2==null?0:l2.val;

        ListNode node = new ListNode( (number1+number2+number)%10 );
        number =  (number1+number2+number)/10;              //更新进位数
        if(head==null){
            head=node;
        }
        else{
            tail.next = node;
        }
        tail = node;
        if(l1!=null){
            l1 = l1.next;
        }
        if(l2!=null){
            l2 = l2.next;
        }

    }
    if(number!=0){
        tail.next = new ListNode(1);                //结束时进位数不为零，添加节点
    }
    return head;

}
*/