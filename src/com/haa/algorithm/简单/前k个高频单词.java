package com.haa.algorithm.简单;

import java.util.*;

/*
    给一非空的单词列表，返回前 k 个出现次数最多的单词。

    返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class 前k个高频单词 {
    public static void main(String[] args){

    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());
        Collections.sort(list,(o1,o2)->
            map.get(o1).equals(map.get(o2))? o1.compareTo(o2):map.get(o2)-map.get(o1));
        return list.subList(0,k);
    }

}
