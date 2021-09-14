package com.haa.链表.链表Java;
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
    public Node() {}

};
public class 扁平化多级双向链表 {
    /*
    多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，
    生成多级数据结构，如下面的示例所示。
    给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。

            1  -  2  -  3  -  4  -  5   - null
                  |
                  5  -  6  -  7  -  null
                        |
                        8  -  9  -  null

           结果  1 2 5 6 8 9 7 3 4 5
     */

    /*
    方法一：横向遍历，遇到有孩子的，直接把孩子列表中所有的节点全部插入到当前节点和它的next节点之间，并把遍历的指针后移
            比如在例子中：2走完后链表应变为    1  -  2  - 5  -  6  -  7  -  3  -  4  -  5   - null
                                                           |
                                                           8  -  9  - null
     */

    public Node flatten(Node head) {
        Node p = head;
        while (p != null) {
            if (p.child != null) {         //如果有孩子节点，准备做插入操作

                Node next = p.next;        //先保存当前节点的next域，防止丢失
                Node child = p.child;

                p.next = child;            //插入
                p.child = null;            //插入后当前节点的child域置空，否则返回时就不是单级链表

                child.prev = p;            //双向链表除了要连接后继，还要连接前驱
                while (child.next != null)
                    child = child.next;
                child.next = next;          //让子列表的最后一个节点与当前节点的next指针连接

                if (next != null)
                    next.prev = child;
            }

            p = p.next;                     //指针后移，判断下一个节点
        }
        return head;
    }

    /*
    方法二：递归的深度优先搜索，
        如果把列表旋转90度，现在的多级双向链表可以看做是一个二叉树，每一个节点的next域可看做右孩子，child域可看做左孩子，与二叉树不同的是，现在的左右孩子可以指向双亲节点
            那么先序遍历的结果刚好是单级双链表

     */
    public Node flatten1(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);            //用pseudoHead来存储遍历后的单链表
        flattenDFS(pseudoHead, head);                     //先序遍历
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    public Node flattenDFS(Node prev, Node curr) {

        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }



}
