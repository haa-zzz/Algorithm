package com.haa.数组和字符串.数组和字符串Java;

public class 反转字符串中的单词3 {
    /*
    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    提示：
    在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */
    /*
    方法1：
    直接用StringBuilder拼接+反转，感觉比反转字符串中的单词的简单，不用考虑头尾的空格
    时间复杂度O(N)
    空间复杂度O(N)
     */
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        StringBuilder child = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)==' '){
                sb.append(child.reverse());
                child = new StringBuilder();
                sb.append(' ');
            }else{
                child.append(s.charAt(i));
            }
        }
        sb.append(child.reverse());
        return sb.toString();

    }

}
