package com.haa.二叉树;

import bean.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉搜索树节点最小距离 {
    /*
        给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     */
    /*
    方法：二叉树的中序遍历：二叉搜索树经过中序遍历后是有序的，可通过中序遍历每次来找相邻两节点的差值来维护最小差值。
     */
    /*
    方法1.dfs
        时间复杂度O(N)
        空间复杂度O(N)
     */
    private int pre;
    private int ans;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre == -1){
            pre = root.val;         //记录最左边的叶子节点的值
        }else{
            ans = Math.min(ans,root.val - pre);
            pre = root.val;
        }
        dfs(root.right);

    }
    /*
    方法2.遍历
        栈实现
        时间复杂度O(N)
        空间复杂度O(N)
     */

    public int minDiffInBST1(TreeNode root) {

        Deque<TreeNode> dpque = new ArrayDeque<>();
        int pre = -1;
        int ans = Integer.MAX_VALUE;
        TreeNode treeNode = root;
        while(treeNode != null || !dpque.isEmpty()){

            while(treeNode!=null){
                dpque.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!dpque.isEmpty()){
                treeNode = dpque.pop();
                if(pre == -1){
                    pre = treeNode.val;
                }
                else {
                    ans = Math.min(ans,treeNode.val-pre );
                    pre = treeNode.val;
                }
                treeNode = treeNode.right;
            }
        }
        return ans;
    }

}
