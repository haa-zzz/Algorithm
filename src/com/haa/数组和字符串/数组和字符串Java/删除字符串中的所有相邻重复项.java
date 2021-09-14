package com.haa.数组和字符串.数组和字符串Java;
/*
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String S) {

        Deque<Character> deque = new ArrayDeque<>();
        for(char c : S.toCharArray() ){

            if(!deque.isEmpty() && deque.peek()==c){
                deque.pop();
            }
            else
                deque.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }
}
