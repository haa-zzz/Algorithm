package com.haa.二叉树;

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

    力抠：剑指 Offer 33. 二叉搜索树的后序遍历序列
 */

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历： 遍历顺序为 “左、右、根“
 * 二叉搜索树定义： 左子树中所有节点的值 << 根节点的值；右子树中所有节点的值 >> 根节点的值；其左、右子树也分别为二叉搜索树。
 */

public class 二叉搜索树的后序遍历序列 {
    class Solution {
        /*
         *方法1： 递归-从子树递归到根节点。若所有的子树都满足，那么就是二叉搜索树
         * 时间复杂度 O(N^2)
         * 空间复杂度 O(N)
         */
        public boolean verifyPostorder(int[] postorder) {
            return fun(postorder, 0, postorder.length - 1);
        }
        boolean fun(int[] postorder, int left, int root) {        //root表示最后的下标，也就是当前的根节点
            if (left >= root) return true;        //此时从root出发没有子树
            int p = left;
            while (postorder[p] < postorder[root]) p++;    //这些都是左子树，都比根小
            int m = p;
            while (postorder[p] > postorder[root]) p++;     //从这里开始是右子树，都比根大
            //如果p == root，说明从roo出发这一趟是符合的，然后在递归去看左右子树是否符合
            return p == root && fun(postorder, left, m - 1) && fun(postorder, m, root - 1);
        }


    }
}
