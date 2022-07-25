package com.haa.数组和字符串.数组和字符串Java;

public class 左旋转字符串 {
    /*
    字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
    比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     */
    /*
    方法：列表遍历拼接
        StringBuilder拼接
     */
    class Solution {
        public String reverseLeftWords(String s, int n) {
            StringBuilder res = new StringBuilder();
            for(int i = n; i < s.length(); i++)
                res.append(s.charAt(i));
            for(int i = 0; i < n; i++)
                res.append(s.charAt(i));
            return res.toString();
        }
    }
}
