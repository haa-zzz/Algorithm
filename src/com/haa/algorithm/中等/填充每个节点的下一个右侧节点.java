package com.haa.algorithm.中等;

import java.util.LinkedList;
import java.util.Queue;


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class 填充每个节点的下一个右侧节点 {
    /*
    给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }
    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
    初始状态下，所有 next 指针都被设置为 NULL。


     */
    /*
    方法一:广度优先搜索-层次遍历
        我们可用基于广度优先搜索的方法，对二叉树进行层次遍历，在当前层我们要做的工作有两个，1.设置next值，2.让下一层的进入队列
     */
    public Node connect(Node root) {
        if(root==null)
            return root;
        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){         //外层的 while 循环迭代的是层数

            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(i<size-1){
                    node.next = queue.peek();
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

        }

        return root;

    }
    /*
    方法二：使用已建立的next 指针
        对于每一个节点：

        第一种情况两个子节点属于同一个父节点，因此直接通过父节点建立两个子节点的 next 指针即可。
                node.left.next = node.right
        第二种情况是连接不同父节点之间子节点的情况。更具体地说，连接的是第一个父节点的右孩子和第二父节点的左孩子。由于已经在父节点这一层建立
         了 next 指针，因此可以直接通过第一个父节点的 next 指针找到第二个父节点，然后在它们的孩子之间建立连接。
                node.right.next = node.next.left

     */
    public Node connect1(Node root) {
        if(root==null)
            return root;
        //从根节点开始
        Node node = root;

        while (node.left!=null){
            //遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = node;
            while (head!=null){
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;   //指针向后移动
            }
            node = node.left;
        }
        return root;
    }
}
