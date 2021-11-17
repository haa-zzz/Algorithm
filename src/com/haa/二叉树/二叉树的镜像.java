package com.haa.二叉树;

import bean.TreeNode;

public class 二叉树的镜像 {
    /*
    请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：
            4
         /     \
       2         7
      / \       / \
     1   3     6   9
镜像输出：

            4
          /  \
         7    2
        / \  / \
       9  6  3  1

     */
    /*
    方法：递归，对于当前节点，交换它的左右子树，然后递归的去对它的左右子树进行交换
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
