package com.haa.algorithm;

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
            if(Character.isLetter(c))
                deque.push(c);
        }
        String rt = "";
        for(int i = 0; i < S.length(); i++){
            if(Character.isLetter(S.charAt(i)))
                rt+=(char)deque.pop();
            else
                rt+=S.charAt(i);

        }
        return rt;
    }
    /*
    public String reverseOnlyLetters(String S) {
        StringBuilder stringBuilder = new StringBuilder();          //Character.isLetter()判断是不是字母
        int j = S.length()-1;
        for(int i = 0; i < S.length(); i++){
            if(Character.isLetter(S.charAt(i))){
                while(!Character.isLetter(S.charAt(j)))
                    j--;
                stringBuilder.append(S.charAt(j--));
            }
            else{
                stringBuilder.append(S.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

     */
}
