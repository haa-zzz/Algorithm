package com.haa.algorithm.简单;
import  java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class 二叉树的序列化和反序列化 {
    public static void main(String[] args){

        
    }
    /*
    序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
    同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
        你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

    提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

     */
    /*
        分析：序列化:把二叉树按一定的序列编码成字符串，可以用先序，中序，后序遍历
            反序列化：把刚才编码的字符串还原为二叉树，注意这里给的二叉树序列化集合是刚才序列化时的编码顺序
     */

    //先序遍历实现序列化，这里用传参的形式递归
    public static String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public static String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    //反序列化：刚才用的先序遍历，现在在还原时也要用先序遍历
    public static TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);                  //每加一个，集合删除一个，这样每次递归要加的节点值都是集合的第一个，便于操作
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public static TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
}
