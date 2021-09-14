package com.haa.二叉树;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 对称二叉树 {
    /*
    给定一个二叉树，检查它是否是镜像对称的。
     */
    /*
    方法一.递归，设置两个指针同步移动来遍历，一个指针指向对应的左树，另一个指向对应的右树，检查是否相等
     */
    public boolean isSymmetric(TreeNode root) {

        return check(root,root);
    }

    private boolean check(TreeNode p, TreeNode q) {

        if (p == null && q == null) {               //终止条件，两个都是空树，此时是对称的
            return true;
        }
        if (p == null || q == null) {               //一个为空，另一个不为空，此时是不对称的
            return false;
        }
        return p.val == q.val && check(p.left, q .right) && check(p.right, q.left);         //判断是否相等

    }
    /*
    方法2.迭代实现，借助队列每次入队左右对应的两个节点，并同时判断对应的节点是否相同
     */
    public boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }

    private boolean check1(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);                     //注意，开始时要把根节点入队两次，方便判断
        while(!queue.isEmpty()){
            left = queue.poll();
            right = queue.poll();
            if(left==null && right==null){     //此时不能直接返回true，队列里面可能还有元素要判断
                continue;
            }
            if((left==null || right==null)|| left.val!=right.val ){
                return false;
            }
            queue.offer(left.right);
            queue.offer(right.left);
            queue.offer(left.left);
            queue.offer(right.right);
        }
        return true;
    }
}
