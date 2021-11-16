package com.haa.二叉树;

import bean.TreeNode;

import java.util.HashMap;

public class 从先序与中序遍历序列构造二叉树 {

    /*
    根据一棵树的前序遍历与中序遍历构造二叉树。

    注意:
    你可以假设树中没有重复的元素。
     */
    /*
    方法：递归
        先序遍历第一个元素是根节点，通过该节点和中序遍历可以确定出左右孩子节点，从而构建二叉树，之后递归的去构建左右的子树
        注意：先序遍历是根-左-右，在递归时要先构建左支后构建右支
        为了更好的在中序遍历中确定根节点的位置，需要用到hashMap存储中序遍历的数组和下标
        时间复杂度O(n)
        空间复杂度O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,0,preorder.length,0, map);
    }
    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,  int i_start,
                                     HashMap<Integer, Integer> map){
        // preorder 为空，直接返回 null
        if(p_start == p_end){
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = map.get(root_val);

        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1,
                 i_start, map);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1,
                p_end, i_root_index + 1, map);
        return root;
    }
}
