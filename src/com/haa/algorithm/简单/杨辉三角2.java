package com.haa.algorithm.简单;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角2 {

    public static void main(String[] args){
        List<Integer> list = getRow(5);
        System.out.println(list);
    }
    /*
    给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
    在杨辉三角中，每个数是它左上方和右上方的数的和。
     */
    /*
    方法：类似于动态规划，每一层都可有前一层推出，推出从1到K层，最后返回即可
    注意：1.左上方的数在进入新一层会被更新掉，所以需要用oldNumber来保存，
        然后根据每个数是它左上方和右上方的数的和这个特性，更新数据
        2.每进入新一层，需要添加一个数，就是最后的那个1

        时间复杂度O(N^N)
        空间复杂度O(1)
     */
    public static List<Integer> getRow(int rowIndex) {
           List<Integer> list = new ArrayList<>();
           if(rowIndex==0)
               return list;
           list.add(1);
           int oldNumber;
           int newNumber = 1;
           for(int i = 1; i < rowIndex; i++){

               for(int j = 1; j <= i ; j++){
                   if(j == i ){
                       list.add(1);
                   }
                   else{
                       oldNumber = newNumber;
                       newNumber = list.get(j);
                       list.set(j,oldNumber+list.get(j));
                   }
               }
           }
           return list;
    }
}
