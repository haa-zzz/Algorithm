package com.haa.二叉树;

import bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树展开为链表_114 {
    /*
    给你二叉树的根结点 root ，请你将它展开为一个单链表：

     展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     展开后的单链表应该与二叉树 先序遍历 顺序相同。

     */
    /*
    方法1:借助集合通过先序遍历把每一个节点先存入集合中，然后遍历集合建立链表关系
    时间复杂度O(N)
    空间复杂度O(N)
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root,list);
        for(int i = 1; i < list.size(); i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }
    private void preorder(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while( !deque.isEmpty() ){
            TreeNode node = deque.pop();
            list.add(node);
            if(node.right != null){
                deque.push(node.right);
            }
            if(node.left != null ){
                deque.push(node.left);
            }
        }
    }
    /*
    方法2.
        直接插入，对于每一个节点，我们需要对它进行的操作是：
            1.将原来的右子树接到左子树的最右边节点
            2.将左子树插入到右子树的地方
            3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null

         时间复杂度O(N)
         空间复杂度O(1)
     */
    public void flatten1(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

}
