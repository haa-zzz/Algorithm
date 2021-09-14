package com.haa.algorithm.简单;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 独一无二的出现次数 {
    /*
    思路:拿到每个数字的出现次数，用哈希表不能存储重复的原则判断是否是独一无二的
     */
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int number:arr){
            map.put(number,map.getOrDefault(number,0)+1);
        }
        Set<Integer> set  = new HashSet<>();
        for(int ket:map.keySet()){
            if(!set.add(map.get(ket))){
                return false;
            }
        }
        return true;

    }
}
