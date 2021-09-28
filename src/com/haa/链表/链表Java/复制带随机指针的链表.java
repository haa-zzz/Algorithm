package com.haa.链表.链表Java;

import java.util.HashMap;

public class 复制带随机指针的链表 {
    /*
    给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。

    构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
    新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
    复制链表中的指针都不应指向原链表中的节点 。
     */
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /*
    题目分析：这道题要求我们原封不动的复制给定的链表并返回我们复制的链表，
        如果是一般的链表，我们只需进行一趟遍历申请空间来加节点就好了，
        难点在于还有一个random指针，复制时还要指定这个指针的指向,如何在复制时找到这个指向关系
     */
    /*
   方法一：使用hashMap来完成复制，要进行两次遍历，第一次时复制每个节点对应的val,第二次进行节点间的串接
        时间复杂度 O(n)
        空间复杂度 O(n)
    */
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        HashMap<Node,Node> hashMap = new HashMap<>();
        Node p = head;

        while(p!=null){
            hashMap.put(p,new Node(p.val));         //第一次，给每个节点申请空间
            p = p.next;
        }
        p = head;
        while (p!=null){                           //第二次，进行串接
            hashMap.get(p).next = hashMap.get(p.next);
            hashMap.get(p).random = hashMap.get(p.random);
            p = p.next;
        }
        return hashMap.get(head);
    }
     /*
        方法二：常数空间，不借助 HashMap 也完成克隆，借助HashMap我们可以很容易的找到要复制链表的next和random。
            不借助HashMap,为了能够找到要复制链表的next和random，我们把复制的节点放在原节点之后，
            这样如果当前节点的random的为p,复制节点的random就是p.next
                先复制：a - a' - b - b' - c - c' - d - d' - null
                后分离： a' - b' - c' - d' - null

         时间复杂度 O(N)
         空间复杂度 O(1)
    */
     public Node copyRandomList1(Node head) {
         if (head == null) return null;
         //克隆源节点
         Node p = head;
         while (p != null) {
             Node temp = p.next;
             p.next = new Node(p.val);
             p.next.next = temp;
             p = temp;
         }
         //给克隆节点的 random 赋值
         p = head;
         while (p != null) {
             if (p.random != null) p.next.random = p.random.next;
             p = p.next.next;
         }
         //拆分
         p = head;
         Node cloneHead = p.next;
         Node cloneP = cloneHead;
         while (cloneP.next != null) {
             //原链表(为了不改变原链表)
             p.next = p.next.next;
             p=p.next;
             //克隆链表
             cloneP.next = cloneP.next.next;
             cloneP = cloneP.next;
         }
         //最后给原链表收尾
         p.next = null;
         return cloneHead;
     }

}
