package com.haa.二叉树;

import java.util.Comparator;
import java.util.TreeMap;

public class 先序遍历还原二叉树 {
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
