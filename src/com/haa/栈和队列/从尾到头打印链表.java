package com.haa.栈和队列;

/*
    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

import bean.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 从尾到头打印链表 {
    /*
    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */
    /*
    方法：使用栈存储节点，使用栈的特性来处理节点
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()];
        int i = 0;
        while( !stack.isEmpty() ){
            nums[i++] = stack.poll();
        }
        return nums;
    }

}
