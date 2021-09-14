package com.haa.链表.链表Java;

import bean.ListNode;

import java.util.PriorityQueue;

public class 合并K个有序链表 {
    /*
    给你一个链表数组，每个链表都已经按升序排列。
    请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    /*
    方法1：在 合并两个有序链表_21 的思想上，考虑每次顺序合并两个有序链表。
    时间复杂度:假设每个链表的最长长度为n,那么时间复杂度为O(K^2 * n)
    空间复杂度O(1)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0){
            return null;
        }
        ListNode mergeTwo = lists[0];
        for(int i = 1; i < n; i++){
            mergeTwo = mergeTwoLists( mergeTwo,lists[i] );
        }
        return mergeTwo;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);            //定义合并链表并设置哨兵节点，方便操作
        ListNode headNode = node;
        while(l1!=null && l2!=null){                   //遍历

            if(l1.val < l2.val){
                headNode.next = l1;
                l1 = l1.next;
            }else{
                headNode.next = l2;
                l2 = l2.next;
            }
            headNode = headNode.next;
        }
        headNode.next = l1==null?l2:l1;                 //添加未被遍历到的节点
        return node.next;
    }
    /*
    方法2：分治合并
    在上面的基础上，用分治的方法进行合并。和归并排序有点想。将K个链表两两配对，这一趟合并完后，剩余K/2个待合并的链表，然后是K/4, K/8 .....
    时间复杂度O(Kn * log K)
    空间复杂度O(log k)
     */
    public ListNode mergeKLists1(ListNode[] lists) {
       return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right){
            return lists[left];
        }
        if(left > right){
            return null;
        }
        int mid = left + (right-left)/2;
        return mergeTwoLists( merge(lists,left,mid), merge(lists,mid+1,right));
    }
    /*
    方法3.使用优先队列合并
    按链表头的val从小到大的顺序维护一个优先队列。每次从队列里poll出最小的链表，把此链表的头添加到排序好的链表表尾，
    然会把此链表的下一个节点作为头添加进优先队列。直到链表为空
    时间复杂度O(kn * log k)
    空间复杂度O(k)
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        if(n == 1) return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>(n,(a, b)-> a.val - b.val );
        for(ListNode list : lists){
            if(list != null){
                queue.offer(list);
            }
        }
        ListNode node = new ListNode(0);
        ListNode headNode = node;
        while(!queue.isEmpty()){
            ListNode pre = queue.poll();
            headNode.next = pre;
            if(pre.next!=null){
                queue.offer(pre.next);
            }
            headNode = headNode.next;
        }
        return node.next;
    }

}
