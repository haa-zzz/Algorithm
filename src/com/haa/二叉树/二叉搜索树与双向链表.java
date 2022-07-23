package com.haa.二叉树;

public class 二叉搜索树与双向链表 {
    /*
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */
    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /*
    方法：中序遍历刚好可以实现递增序列，用中序遍历访问树的各节点 cur ；并在访问每个节点时构建 cur 和前驱节点 pre 的引用指向；
            中序遍历完成后，最后构建头节点和尾节点的引用指向即可。

            时间复杂度 O(N) ： N 为二叉树的节点数，中序遍历需要访问所有节点。
            空间复杂度 O(N) ： 最差情况下，即树退化为链表时，递归深度达到 NN，系统使用 O(N)O(N) 栈空间。
     */
    class Solution {
        Node pre, head;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }
        void dfs(Node cur) {
            if(cur == null) return;
            dfs(cur.left);      //遍历左子树
            if(pre != null)     //访问根节点，确定指向关系
                pre.right = cur;
            else
                head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);     //遍历右子树
        }
    }
}
