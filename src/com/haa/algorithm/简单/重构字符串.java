package com.haa.algorithm.简单;

import java.util.Arrays;

public class 重构字符串 {
    /*
    给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

    若可行，输出任意可行的结果。若不可行，返回空字符串。
     */
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
    /*
        方法一：

            一：用一个数组可以同时获取字母出现的次数和字母
            1，map[c - 'a'] += 100;int coumt = m / 100;那么coumt就是每个字母出现的次数
            2， for (int i = 0; i < 26; i++) {
                    map[i] += i;
                }
                char c = (char) ('a' + m % 100);
                c就是此时的字母
            二：间隔插入
     */
    public static String reorganizeString(String S) {
        int[] map = new int[26];
        for (char c : S.toCharArray()) {
            map[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            map[i] += i;
        }
        Arrays.sort(map);
        int len = S.length();
        if ((2*(map[25]/100) - len) >=2 )
        return "";
        char[] rt = new char[len];
        int t = 1;
        for (int m : map) {
            int coumt = m / 100;
            if (m == 0)
                continue;
            char c = (char) ('a' + m % 100);
            for (int i = 0; i < coumt; i++) {
                if (t >= len)
                    t = 0;
                rt[t] = c;
                t += 2;
            }
        }
        return String.valueOf(rt);
    }
}
