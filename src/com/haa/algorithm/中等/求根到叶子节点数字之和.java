package com.haa.algorithm.中等;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 求根到叶子节点数字之和 {

    public static void main(String[] args){

    }
    /*
    深度优先搜索是很直观的做法。从根节点开始，遍历每个节点，如果遇到叶子节点，则将叶子节点对应的数字加到数字之和。
    如果当前节点不是叶子节点，则计算其子节点对应的数字，然后对子节点递归遍历。


     */

    public static int sumNumbers(TreeNode root) {

        return dfs(root,0);
    }


    private static int dfs(TreeNode root, int preSum){

        if(root==null){
            return 0;
        }
        int sum = preSum*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }
        else{
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }
}
