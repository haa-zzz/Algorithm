package com.haa.algorithm.中等;

import bean.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 重排链表2 {
    /*
    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
    将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reorder-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    方法：用线性表存链表，通过下标访问链表
     */
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        List<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        int i = 0;
        int j = list.size()-1;
        while(i < j){

            list.get(i).next = list.get(j);
            i++;
            if(i==j)
                break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }


}
