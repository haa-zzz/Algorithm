package com.haa.二叉树;

import bean.TreeNode;

public class 平衡二叉树 {
    /*
    输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     */
    /*
       变相的求深度，算出左右节点的最大深度，看差值是否小于等于1
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            int deep = deep(root);
            return deep != -1;
        }
        int deep(TreeNode root) {
            if(root == null){ return 0; }
            int left = deep(root.left);
            if(left == -1) {       //剪纸，当为-1时，说明已经不是平衡二叉树了，直接返回就好了
                return -1;
            }
            int right = deep(root.right);
            if(right == -1) {   //剪纸，当为-1时，说明已经不是平衡二叉树了，直接返回就好了
                return -1;
            }
            return  Math.abs(left - right) <= 1? Math.max(left, right) + 1: -1;
        }
    }
}
