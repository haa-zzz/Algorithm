package com.haa.二叉树;

import java.util.Comparator;
import java.util.TreeMap;

public class 先序遍历还原二叉树 {
    /*
    我们从二叉树的根节点 root开始进行深度优先搜索。

在遍历中的每个节点处，我们输出D条短划线（其中D是该节点的深度），然后输出该节点的值。
（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
如果节点只有一个子节点，那么保证该子节点为左子节点。
给出遍历输出S，还原树并返回其根节点root。


     */
    public static void main(String[] args){
        TreeMap<String,Integer> t = new TreeMap<String, Integer>(new Comparator<String>(){
            public int compare(String s1,String s2){
                int s = s1.compareTo(s2);
                return s==0? 1:s;
            }
        });
        TreeMap<String,Integer> t1= new TreeMap<String, Integer>((s1,s2)->{ int s = s1.compareTo(s2);
            return s==0? 1:s;});
    }
}
