package com.haa.二叉树;

import bean.TreeNode;

import java.util.*;

/*
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
第三行再按照从左到右的顺序打印，其他行以此类推。

力抠：剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class Z字型打印_103 {

    /**
     * 方法一：层序遍历 + 双端队列
     *
     * 利用双端队列的两端皆可添加元素的特性，设打印列表（双端队列） queue ，并规定：
     * 奇数层 则添加至 queue 尾部 ，
     * 偶数层 则添加至 queue 头部 。
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null) {
            return ans;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList();
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(ans.size() % 2 == 0) {        // 偶数层 -> 队列头部
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }
        return ans;

    }
}
