package com.haa.algorithm.简单;

import java.util.Scanner;

public class 实现strStr {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = new String("mississippi");

        String b = new String("issip");
        int c = a.indexOf(b);
        int d = strStr(a,b);
        System.out.println(c+"  "+d);

    }
    public static int[] get_next(String T){
        int[] next = new int[T.length()];
        int j = 0,k = -1;

        next[0] = -1;

        while(j < T.length()-1){

            if( k==-1|| T.charAt(j)==T.charAt(k)){
                ++j;
                ++k;
                if(T.charAt(j)==T.charAt(k))	//特判
                    next[j] = next[k];
                else
                    next[j] = k;
            }
            else
                k = next[k];
        }
        return next;
    }
    public static int strStr(String haystack, String needle) {
        int[] next = get_next(needle);
        int i = 0,j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i)==needle.charAt(j)) {
                ++i;
                ++j;
            }
            else
                j = next[j];
        }
        if( j==needle.length()){
            return i-needle.length();
        }
        else
            return -1;
    }


}
