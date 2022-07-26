package com.haa.二叉树;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II {
    /*
    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
   叶子节点 是指没有子节点的节点。
     */
    /*
    dfs 回溯
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            dfs(root, targetSum, ans, new ArrayList());
            return ans;
        }
        void dfs(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path) {
            path.add(root.val);
            targetSum -= root.val;
            if(root.left == null && root.right == null && targetSum == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            if(root.left!=null){
                dfs(root.left, targetSum, ans,path);
                path.remove(path.size()-1);
            }
            if(root.right!=null){
                dfs(root.right,targetSum,ans,path);
                path.remove(path.size()-1);
            }


        }

    }
}
