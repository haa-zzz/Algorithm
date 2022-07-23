package com.haa.二叉树;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    /*
    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    叶子节点 是指没有子节点的节点。
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(root, target,  ans, new ArrayList());
            return ans;
        }
        void dfs(TreeNode root, int target,  List<List<Integer>> ans, List<Integer> path) {
            if(root == null) {
                return;
            }
            path.add(root.val);
            target = target - root.val;

            if(root.left == null && root.right == null) {
                if(target == 0) {
                    ans.add(new ArrayList(path));
                }
                return;
            }
            if(root.left != null) {
                dfs(root.left, target,  ans, path);
                path.remove(path.size()-1);
            }
            if(root.right != null) {
                dfs(root.right, target,  ans, path);
                path.remove(path.size()-1);
            }
        }
    }
}
