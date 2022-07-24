package com.haa.数组和字符串.数组和字符串Java;

import java.util.ArrayDeque;

public class 仅仅反转字母 {
    public static void main(String[] args){

    }
    /*
    栈：先进后出，可在这道题中用来存放字母
     */
    public String reverseOnlyLetters(String S) {

        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(char c: S.toCharArray()){
            if(Character.isLetter(c))           //判断是不是字母
                deque.push(c);
        }
        StringBuilder rt = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(Character.isLetter(S.charAt(i)))
                rt.append((char) deque.pop());
            else
                rt.append(S.charAt(i));
        }
        return rt.toString();
    }

}
