package com.haa.二叉树;

import bean.TreeNode;

import java.util.*;

public class 二叉树的先序遍历 {
    /*
    给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     */

    /*
        前序遍历：若二叉树为空，则空操作返回，否则先访问根结点，然后前序遍历左子树，再前序遍历右子树。
        简记为：中 → 左 → 右
     */
    /*
    方法一.递归实现
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preprder(list, root);
        return list;
    }

    void preprder(List list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);                 //访问根节点
        preprder(list, root.left);          //递归访问左子树
        preprder(list, root.right);         //递归访问右子树
    }

    /*
    方法二.遍历  利用栈的后进先出原则,按先序遍历的原则增删元素
    遍历1.遍历时一次向栈中添加当前节点的左右节点，注意先访问左子树，所以要先添加右子树

     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        deque.push(root);                               //先添加根节点
        while (!deque.isEmpty()) {                        //遍历
            TreeNode treeNode = deque.poll();
            list.add(treeNode.val);
            if (treeNode.right != null) {
                deque.push(treeNode.right);
            }
            if (treeNode.left != null)
                deque.push(treeNode.left);
        }
        return list;
    }

    /*
        遍历2；一次访问添加所有的左子树
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode p = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || p != null) {
            while (p != null) {
                list.add(p.val);
                deque.push(p);
                p = p.left;
            }
            if (!deque.isEmpty()) {
                p = deque.pop();
                p = p.right;
            }
        }
        return list;
    }
}
