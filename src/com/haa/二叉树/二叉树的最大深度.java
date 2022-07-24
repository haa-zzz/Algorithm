package com.haa.二叉树;



import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 */
public class 二叉树的最大深度 {
    /*
    给定一个二叉树，找出其最大深度。
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    说明: 叶子节点是指没有子节点的节点。
     */

    //递归法：如果我们知道了左子树和右子树的最大深度 l和 r，那么该二叉树的最大深度即为max(l,r)+1

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }


    //bfs 广度优先搜索，利用层次遍历来找

    public int maxDepth1(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                size--;
            }
            ans++;
        }
        return  ans;
    }

    //自己的解法，其实可以原地递归
    /*
    private int max = 0;
    public int maxDepth(TreeNode root) {
        int count = 0;
        if(root == null)
            return 0;
        dfs(root,1);
        return max;
    }
    private void dfs(TreeNode root,int count){
        if(root.left==null && root.right == null){
            max = Math.max(max,count);
            return;
        }
        if(root.left!=null)
            dfs(root.left,count+1);
        if(root.right!=null)
            dfs(root.right,count+1);
    }

     */

}
