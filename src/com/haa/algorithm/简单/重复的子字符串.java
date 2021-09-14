package com.haa.algorithm.简单;

import java.util.Scanner;

public class 重复的子字符串 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(repeatedSubstringPattern(in.next()));
    }
    /*
    给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     */
    /*

    方法：
    1.将原字符串给出拷贝一遍组成新字符串；
    2.掐头去尾留中间；
    3.如果还包含原字符串，则满足题意。


    1.假设字符串有n个子串构成（n>=1）;//假设子串就是它本身，那么n=1;
    2.str.substring(1,str.length() - 1 ) 意思为 去掉str的首字符和尾字符 即去掉第一个s的首字符 和第二个s的尾字符
    3.一个子串至少有一个字符组成，去掉首尾字符，相当于首尾两个子串不完整，还剩下2n-2个子串，（首尾有几个元素不构成
    子串）
    4.如果此时还包含s，即包含n个子串，则2n-2>=n，即n >=2 ,说明s由一个子串重复两次以上构成
    5.如果此时不包含s，即2n-2<n，即n<2 ,由1知n>=1,因此n=1，说明s由一个子串构成，即不满足条件
     */



    public static boolean repeatedSubstringPattern(String s) {

        int len = s.length();
        if(len == 0)
            return false;

        for(int j = len/2; (j >= 1)  ; j--){
            if(len%j!=0)
                continue;
            String eq = "";
            for(int k = 0; k<len; k+=j){
                eq+=s.substring(0,j);
            }

            if(s.equals(eq))
                return true;
        }
        return false;
    }
    /*
    public static boolean repeatedSubstringPattern(String s) {

        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

     */
}
