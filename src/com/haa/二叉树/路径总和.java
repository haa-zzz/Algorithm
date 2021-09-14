package com.haa.二叉树;

import bean.TreeNode;

public class 路径总和 {

    /*
    给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在
        根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     */
    /*
    方法。递归
        终止条件：递归到叶子节点时终止，如果 节点值相加等于目标和 targetSum返回true
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {                    //特判
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
                    targetSum - root.val);
    }

}
