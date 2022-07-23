package com.haa.二叉树;

import bean.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 序列化二叉树 {
    /*
      请实现两个函数，分别用来序列化和反序列化二叉树。
    你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
    你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     */
    public class Codec {
        //层次遍历来序列化，需要记录null节点
        public String serialize(TreeNode root) {
            if(root == null) return "[]";
            StringBuilder res = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node != null) {
                    res.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
                else res.append("null,");       //除了记录真实节点外，还要记录null节点
            }
            res.deleteCharAt(res.length() - 1);
            res.append("]");
            return res.toString();
        }

        //反序列化
        public TreeNode deserialize(String data) {
            if(data.equals("[]"))
                return null;
            //把序列化的结果分割成子项
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(!vals[i].equals("null")) {       //添加左节点
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.left);
                }
                i++;
                if(!vals[i].equals("null")) {   //添加右节点
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return root;
        }
    }
}
