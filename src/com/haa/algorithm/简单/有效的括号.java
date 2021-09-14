package com.haa.algorithm.简单;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class 有效的括号 {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

     */
    /*
        方法:栈
     */
    public boolean isValid(String s) {

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }



        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                if (deque.isEmpty() || deque.poll() != map.get(ch)) {
                    return false;
                }
            } else
                deque.push(ch);
        }
        return deque.isEmpty();
    }
}
