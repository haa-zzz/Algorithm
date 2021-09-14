package com.haa.algorithm.简单;

import java.util.ArrayDeque;
import java.util.Deque;

/*
给你一个由大小写英文字母组成的字符串 s 。
一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
0 <= i <= s.length - 2
s[i] 是小写字符，但 s[i + 1] 是相同的大写字符；反之亦然 。
请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 */
public class 整理字符串 {

    public String makeGood(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){

            char x = Character.isLowerCase(c) ? Character.toUpperCase(c):Character.toLowerCase(c);
            if(!deque.isEmpty() && x==deque.peek())
                deque.pop();
            
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
