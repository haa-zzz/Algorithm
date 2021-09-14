package com.haa.链表.链表Java;

import bean.ListNode;

import java.util.ArrayList;

public class 回文链表 {

    /*
    请判断一个链表是否为回文链表。
     */

    /**
    方法1：双指针+链表反转：快指针走到末尾，慢指针刚好到中间。其中慢指针将前半部分反转。然后比较。
        时间复杂度O(n),空间复杂度O(1)
     */
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null){              //特判
            return true;
        }

        ListNode fast,slow;                            //快慢指针
        ListNode pre,cur;                              //反转前后指针

        pre = null;
        fast = slow = cur = head;

        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;                  //注意,因为反转后指向关系发生改变，所以快慢指针的后移要先于反转

            cur.next = pre;                         //反转，改变链表指向
            pre = cur;                              //一趟结束，两指针后移
            cur = slow;
        }
        if(fast!=null){                             //如果是奇数个节点，从下一个节点开始比较
            slow = slow.next;
        }
        while(slow!=null){
            if(pre.val!= slow.val){                 //比较是否是回文链表
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
    /**
    方法2：把链表中的节点值拿出来放在集合里判断，
        时间复杂度O(n) 空间复杂度O(n)
     */
    public static boolean isPalindrome1(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size()-1;
        while(left < right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }


}
