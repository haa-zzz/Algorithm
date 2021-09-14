package com.haa.algorithm.简单;

import java.util.Scanner;
/*
    请判断一个链表是否为回文链表。
 */

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
}
public class 回文链表 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        ListNode head =  null;
        ListNode end = head = null;
        System.out.println("输入-1结束");
        int x = in.nextInt();
        while(x!=-1){
            ListNode ln = new ListNode(x);
            if(head==null)
                head = ln;
            else
                end.next = ln;
            end = ln;
            x = in.nextInt();
        }
        end.next = null;
        output(head);
        System.out.println(isPalindrome(head));

    }
    public static void output(ListNode node){
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode frontPointer = null;
    private static boolean recursivelyCheck(ListNode currentNode){
        if(currentNode != null){
            if(!recursivelyCheck(currentNode.next))         //一直递归到最后一个数
                return false;
            if(currentNode.val!=frontPointer.val)
                return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }
    public static boolean isPalindrome(ListNode head) {
        /*
        //方法一：用集合遍历判断,把链表中的数都存ArrayList集合中，遍历得
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

         */


        //方法二：递归法

        /*
        frontPointer = head;
        //output(frontPointer);
        return recursivelyCheck(head);

         */
        //方法三：快慢链表
        //快链表一次走2，用来判断是奇数个还是偶数个
        //慢链表走一次
        //反转链表
        //前后遍历
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;              //反转链表
            prepre = pre;
        }
        if(fast != null) {                  //如果是奇数个slow指向下一个
            slow = slow.next;
        }
        while(pre != null && slow != null) {        //前后遍历判断是否相等
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;

    }




}
