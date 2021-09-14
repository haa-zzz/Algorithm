package com.haa.数组和字符串.数组和字符串Java;

import java.util.*;

public class 字母异位词分组 {
    /*
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
    示例:
        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出:
        [
            ["ate","eat","tea"],
            ["nat","tan"],
            ["bat"]
        ]
    说明：
     所有输入均为小写字母。
     不考虑答案输出的顺序。
     */
    /*
    方法1.排序+hash表存储
     以字符串为key，字母异位字符串集位value构建hash表，因为异位字符串按字典顺序排序后的字符串是相同的，
     所以遍历每一个字符串，先对字符串排序，如果排序后的字符串对应的key在hash表中存在，就拿到对应的value,不存在，就新建一个对应的集合。把原字符串加入到集合中。
     最后更新hash表

     时间复杂度O(n K log K),n是字符串数组的长度，k是单个字符串对应的最大长度
     空间复杂度 O(nK )
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map< String,List<String> > map = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);            //排序
            String key = new String(ch);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(s);
            map.put(key,list);          //更新hash表
        }
        return new ArrayList<List<String>>(map.values());
    }

}
