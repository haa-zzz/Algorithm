package com.haa.二叉树;

import bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
    从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */

/**
 * 广搜
 */
public class 从上到下打印二叉树 {

    public int[] levelOrder(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if(root==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            lists.add(node.val);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] res = new int[lists.size()];
        for(int i = 0; i < lists.size(); i++)
            res[i] = lists.get(i);
        return res;
    }

}
