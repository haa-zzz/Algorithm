package com.haa.algorithm.简单;

public class 回位链表 {

    /*
        请判断一个链表是否为回文链表。
         */
    /*
    方法：利用递归的原则吧链表反转与原链表比较
     */
    private static ListNode frontPointer;
    public static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private static boolean recursivelyCheck(ListNode head) {
        if(head!=null){
            if(!recursivelyCheck(head.next)){           //如果函数体返回false说明不是回位链表，直接返回false
                return false;
            }
            if(head.val!=frontPointer.val)
                return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
