package com.haa.二叉树;



import bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的后序遍历 {
    /*
        后序遍历（LRD）是二叉树遍历的一种,首先遍历左子树，然后遍历右子树，最后访问根结点。
     */
    /*
        法一,递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        poster(root,list);
        return list;
    }

    private void poster(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        poster(root.left,list);
        poster(root.right,list);
        list.add(root.val);

    }
    /*
    法二.迭代
        在后序遍历时需要判断当前节点是否可以访问
            1.当前节点的左右子树为空
            2.当前节点的左右子树都已经访问
     */
    public List<Integer> postorderTraversal1(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode treeNode = root;
        TreeNode cur = null;
        while(treeNode!=null || !deque.isEmpty()){
            while(treeNode!=null){
                deque.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!deque.isEmpty()){
                treeNode = deque.peek();
                if(treeNode.right==null || treeNode.right==cur){
                    deque.poll();
                    list.add(treeNode.val);
                    cur = treeNode;
                    treeNode = null;
                }
                else{
                    treeNode = treeNode.right;
                }
            }

        }
        return list;
    }
}
