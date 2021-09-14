package com.haa.二叉树;



import bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class 二叉树的中序遍历 {
    /*
    给定一个二叉树，返回中序遍历
    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [1,3,2]
    分析：中序遍历：中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。

 */
    /*
        法1:递归

     */
    public List<Integer> inorderTraversal(TreeNode treeNode){

        List<Integer> list = new ArrayList<>();

        inorder(treeNode,list);
        return list;
    }

    private void inorder(TreeNode treeNode, List<Integer> list) {

        if(treeNode == null ){
            return ;
        }
        inorder(treeNode.left,list);
        list.add(treeNode.val);
        inorder(treeNode.right,list);

    }
    /*
    法2.迭代
     */
    public List<Integer> inorderTraversal1(TreeNode root){

        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode treeNode = root;

        while(treeNode!=null || !deque.isEmpty()){
            while(treeNode!=null){
                deque.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!deque.isEmpty()){
                treeNode = deque.poll();
                list.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        return list;
    }
}
