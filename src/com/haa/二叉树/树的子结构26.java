package com.haa.二叉树;

import bean.TreeNode;

public class 树的子结构26 {
    /*
    输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */
    /*
        若树 B 是树 A 的子结构，则子结构的根节点可能为树 A 的任意一个节点。所有，在判断时首先先序遍历树A中的每个节点n，再判断树A中以n为根节点
        的子树是否包含树B.
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && ( (recur(A,B)) || isSubStructure(A.left,B) || isSubStructure(A.right,B) );
    }
    //判断以A节点开始的是否和B树有一样的结构
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}


