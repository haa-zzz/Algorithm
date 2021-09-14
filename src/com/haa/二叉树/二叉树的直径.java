package com.haa.二叉树;

import bean.TreeNode;

public class 二叉树的直径 {
    /*
    给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     */
    /*
    方法.递归(深度优先搜索)

        对于一个节点，如果该节点的左子树向下遍历经过最多的节点数为L,右子树向下遍历经过最多的节点数为R，那么以该节点为起点的路径经过节点数的
        最大值为L+R+1
        记节点node为起点的路径经过节点数的最大值为dNode,那么二叉树的直径就是所有节点dNode的最大值减一。

        算法流程：定义一个递归函数计算dNode,函数返回该节点为根的子树的深度，
            先递归调用左儿子和右儿子求得它们为根的子树的深度 L 和 R,则该节点为根的子树的深度即为max(L,R)+1，
            该节点的dNode值为L+R+1,
            递归搜索每个节点并设一个全局变量 ans 记录 dNode的最大值，最后返回 ans-1 即为树的直径。

     */
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {

        ans = 1;
        depth(root);
        return ans-1;
    }
    private int depth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int L = depth(root.left);   // 左子树为根的子树的最大深度
        int R = depth(root.right);  // 右子树为根的子树的最大深度
        ans = Math.max(ans,L+R+1);  //更新ans值
        return Math.max(L,R)+1;     //返回该节点为根的子树的深度
    }


}
