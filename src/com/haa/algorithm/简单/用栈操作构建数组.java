package com.haa.algorithm.简单;

import java.util.ArrayList;
import java.util.List;

/*
给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。

请使用下述操作来构建目标数组 target ：

Push：从 list 中读取一个新元素， 并将其推入数组中。
Pop：删除数组中的最后一个元素。
如果目标数组构建完成，就停止读取更多元素。
题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。

请返回构建目标数组所用的操作序列。

题目数据保证答案是唯一的。

 */
public class 用栈操作构建数组 {

    public List<String> buildArray(int[] target, int n) {

        List<String> list = new ArrayList<>();
        int dex = 1;
        for(int i = 0; i < target.length ; i++){
            while(target[i]>dex){
                list.add("Push");
                list.add("Pop");
                dex++;
            }
            if(target[i]==dex){
                list.add("Push");
                dex++;
            }

        }
        return list;

    }
}
