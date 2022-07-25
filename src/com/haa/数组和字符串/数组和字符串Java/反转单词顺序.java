package com.haa.数组和字符串.数组和字符串Java;

public class 反转单词顺序 {
    /*
    输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
    例如输入字符串"I am a student. "，则输出"student. a am I"。
     */
    class Solution {
        public String reverseWords(String s) {
            s = s.trim(); // 删除首尾空格
            int j = s.length(), i = j-1;  //双指针，i用于遍历，j指向单词的结尾
            StringBuilder res = new StringBuilder();
            while(i >= 0) {
                while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索单词
                res.append(s.substring(i + 1, j) + " "); // 添加单词
                while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
                j = i+1;  //j 指向下个单词的尾
            }
            return res.toString().trim(); // 转化为字符串并返回
        }
    }
}
