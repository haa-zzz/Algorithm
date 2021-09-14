package com.haa.algorithm.简单;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
        例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
你可以按任意顺序返回答案。
 */
/*
   方法：计数
 */
public class 查找常用字符 {

    public List<String> commonChars(String[] A) {

        List<String> list = new ArrayList<>();
        int[] arr = new int[26];
        Arrays.fill(arr,Integer.MAX_VALUE);
        for(String s:A){
            int[] search = new int[26];
            for(int i = 0; i < s.length(); i++){
                search[s.charAt(i)-'a'] ++;
            }
            for(int i = 0; i < 26; i++){
               arr[i] = Math.min(arr[i],search[i]);
            }
        }
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < arr[i]; ++j) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }
}
