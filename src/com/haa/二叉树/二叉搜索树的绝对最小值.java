package com.haa.二叉树;


import bean.TreeNode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/*
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
/*
    注：二叉搜索树中序遍历得到的值序列是递增有序的
 */
public class 二叉搜索树的绝对最小值 {
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {

        ans = Integer.MAX_VALUE;
        pre = -1;
        index(root);
        return ans;

    }
    public void index(TreeNode root){
        if(root==null)
            return;

        index(root.left);

        if(pre == -1){
            pre = root.val;
        }
        else{
            ans = Math.min(ans,root.val-pre);
            pre = root.val;
        }
        index(root.right);
    }

}
