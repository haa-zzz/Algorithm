package com.haa.algorithm.简单;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public static void main(String[] args){
        List<List<Integer>> list = generate(10);
        for(List<Integer> l:list) System.out.println(l + "\n");
    }
    /*
    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    在杨辉三角中，每个数是它左上方和右上方的数的和。
     */
    /*
    分析：遍历，利用每个数是它左上方和右上方的数的和这个特性，逐行添加，
        注意：对于第一个和最后一个，要自行添加
        时间复杂度O(N^N)
        空间复杂度O(1)
     */
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0)
            return list;

        for(int i  = 1; i <= numRows; i++){
            List<Integer> list1 = new ArrayList<>();
            if(i==1){
                list1.add(1);
                list.add(list1);
                continue;
            }
            list1.add(1);
            for(int j = 2; j < i; j++){
                list1.add(list.get(i-2).get(j-2)+list.get(i-2).get(j-1));
            }
            list1.add(1);
            list.add(list1);
        }
        return list;
    }
}
