package com.haa.二叉树;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 合并二叉树 {
    /*
    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
    你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
    否则不为 NULL 的节点将直接作为新二叉树的节点。
     */
    /*
    方法一.dfs即递归
        从根节点开始同时遍历两个二叉树，并将对应的节点进行合并。
        分为三种情况
            1.root1 和 root2 都为null，那么合并后为 null
            2.root1或者root2为null，合并后为 两个中的为空节点
            3.都不为null，相加

         时间复杂度O(N)
         空间复杂度O(N)
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode root = new TreeNode( root1.val + root2.val );
        root.left = mergeTrees(root1.left,root2.left);
        root.right = mergeTrees(root1.right,root2.right);
        return root;
    }
    /*
    方法2.bfs，即迭代，具体的使用三个队列，分别存储合并后的二叉树的节点以及两个原始二叉树的节点。
    采用迭代从上往下同时遍历两颗二叉树，主要分三种情况：
        1.两原始二叉树对应的节点都不为空，和并后的节点为这两个节点之和，并且要把他们入队，继续设置后序节点
        2.两原始二叉树对应的节点有一个为空，合并后的节点就是不为空的原始节点，此节点到此结束，不需要入队
        3.都为空，不做处理。

     */
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode merge =new TreeNode(root1.val+root2.val) ;
        queue.offer(merge);
        queue1.offer(root1);
        queue2.offer(root2);
        while(!queue1.isEmpty() && !queue2.isEmpty() ){
            TreeNode root = queue.poll(); TreeNode leftRoot = queue1.poll(); TreeNode rightRoot = queue2.poll();
            TreeNode left1 = leftRoot.left; TreeNode left2 = rightRoot.left;
            TreeNode right1 = leftRoot.right; TreeNode right2 = rightRoot.right;
            if(left1 != null && left2 !=null){
                TreeNode left  = new TreeNode(left1.val+left2.val);
                root.left = left;
                queue.offer(left);
                queue1.offer(left1);
                queue2.offer(left2);
            }else if(left1 != null){
                root.left = left1;
            }else if(left2!=null){
                root.left = left2;
            }

            if(right1 != null && right2 !=null){
                TreeNode right  = new TreeNode(right1.val+right2.val);
                root.right = right;
                queue.offer(right);
                queue1.offer(right1);
                queue2.offer(right2);
            }else if(right1 != null){
                root.right = right1;
            }else if(right2 != null){
                root.right = right2;
            }
        }
        return merge;
    }
}
