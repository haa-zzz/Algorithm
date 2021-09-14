package com.haa.二叉树;

import bean.TreeNode;

public class 翻转二叉树 {
    /*
    翻转一棵二叉树。
     */

    /*
    方法：递归，
    我们从根节点开始，递归地对树进行遍历，并从叶子结点先开始翻转。
    如果当前遍历到的节点root 的左右两棵子树都已经翻转，那么我们只需要交换两棵子树的位置，
    即可完成以root为根节点的整棵子树的翻转
    时间复杂度O(N)
    空间复杂度O(N)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
