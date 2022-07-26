package com.haa.二叉树;

import bean.TreeNode;

public class 二叉树的最近公共祖先 {
    /*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且
        x 的深度尽可能大（一个节点也可以是它自己的祖先）。

       说明:

        所有节点的值都是唯一的。
        p、q 为不同节点且均存在于给定的二叉树中。
     */

    /*
    分析：递归法
    最近公共祖先的定义： 设节点 root 为节点 p,q 的某公共祖先，若其左子节点 root.left
            和右子节点 root.right 都不是 p,q 的公共祖先，则称 root 是 “最近的公共祖先” 。
    根据如上定义，如果root是p,q的最近的公共祖先，则应该满足以下条件之一：
        1.p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）;
        2.p = root ，且 q 在 root 的左或右子树中;
        3,q = root ，且 p 在 root 的左或右子树中;
    解题时通过后序遍历的方法，在遇到节点p或者q时返回
    终止条件:
        当遇到节点p或者q时返回root,当越过叶子节点没有找到节点p或者q时返回null
      这就是一个后序遍历的模型，只不过是每个父节点都会接收子节点的状态（是否含有p、q）并把这个状态往上传递，直到该结点满足祖先节点的条件。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root){           //终止条件
            return root;
        }
        TreeNode lNOde = lowestCommonAncestor(root.left, p, q);   //后序遍历
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);
        if(lNOde == null){
            return rNode;
        }
        if(rNode == null){
            return lNOde;
        }
        return root;
    }

}
