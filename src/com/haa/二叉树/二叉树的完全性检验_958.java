package com.haa.二叉树;

import bean.TreeNode;

import java.util.LinkedList;

public class 二叉树的完全性检验_958 {
    /*
    层次优先遍历
    任何一节点，有右无左 false
    遇到了第一个左右子节点不全，后续皆叶节点。
     */
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            boolean flag = false;//是否遇到左右两个孩子不双全的节点
            TreeNode left ;
            TreeNode right ;
            queue.add(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                left = root.left;
                right = root.right;
                //已经遇到了孩子不双全的，下一层还有节点 false         有右无左 false
                if ((flag && (left != null || right != null)) || (left == null && right != null)) {
                    return false;
                }
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
                if (left == null || right == null) {
                    flag = true;
                }
            }
            return true;
        }
    }
}
