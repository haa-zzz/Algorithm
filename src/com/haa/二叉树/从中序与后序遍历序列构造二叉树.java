package com.haa.二叉树;

import bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {
    /*
    根据一棵树的中序遍历与后序遍历构造二叉树。
     */
    /*
        方法.递归：
            后序遍历的最后一个节点为根节点，中序遍历的中间一个节点为根节点，可以找到这个根节点通过中序遍历把一个数组分为左右孩子两个数组，
            这样递归的去构建二叉树
            注意：后序遍历先访问左孩子在访问右孩子最后访问根节点，所以如果右孩子存在，后序遍历最后一个元素前一个元素是右孩子，
                在递归时要先递归右子树，在递归左子树 ..这种。
         */

    //由于是要递归去完成，把这些用全局变量记录更加方便
    int post_idx;               //记录当前根节点的位置
    int[] postorder;            //后序遍历记录数组
    int[] inorder;              //中序遍历记录数组
    Map<Integer,Integer> map = new HashMap<>();
        //map中键存储中序遍历每个节点，值存储对应的下标，用于快速找到递归时当前根节点的下标去划分左右孩子
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length-1;
        int idx = 0;
        for(Integer i:inorder){
            map.put(i,idx++);
        }
        return helper(0,inorder.length-1);

    }
    private TreeNode helper(int in_left, int in_right) {
        if(in_left>in_right){
            return null;
        }
        int root_val = postorder[post_idx];             //根据后序遍历得到当前的根节点值
        TreeNode root = new TreeNode(root_val);         //构建二叉树
        int index = map.get(root_val);                  //拿到根节点的下标
        post_idx--;
        root.right = helper(index + 1, in_right);   //先构建右子树
        root.left = helper(in_left, index - 1);
        return root;
    }

}
