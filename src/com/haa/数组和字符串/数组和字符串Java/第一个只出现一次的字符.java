package com.haa.数组和字符串.数组和字符串Java;

import java.util.HashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
    /*
    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     */
    /*
    方法1: hash表存储，两次遍历，一次存，一次取
     */
    class Solution {
        public char firstUniqChar(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for(char c: s.toCharArray()) {
                if(map.get(c) == 1) return c;
            }
            return ' ';

        }
    }
    /*
       方法2: hash去存放下标，第二次不去遍历数组，而是遍历hash表，这样遍历次数更少
     */
    class Solution1 {
        public char firstUniqChar(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                if(map.containsKey(arr[i])) {
                    map.put(arr[i], -1);
                } else {
                  map.put(arr[i], i);
                }
            }
            int first = arr.length;
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                int pos = entry.getValue();
                if(pos != -1 && pos < first) {
                    first = pos;
                }
            }
            return (first == arr.length) ? ' ' : arr[first];

        }
    }
}
