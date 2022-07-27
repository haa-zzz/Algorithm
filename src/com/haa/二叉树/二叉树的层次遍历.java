package com.haa.二叉树;

import bean.TreeNode;

import java.util.*;

public class 二叉树的层次遍历 {
    /*
    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
     */
    /*
    方法：bfs，使用栈来一次存储访问一层
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for(int i = 0; i < n;  i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }

            }
            lists.add(list);

        }
        return lists;
    }
}
