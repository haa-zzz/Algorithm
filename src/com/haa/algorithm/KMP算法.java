package com.haa.algorithm;

public class KMP算法 {

    public static void main(String[] args){
        String S = "mississippi";
        String T = "issip";
        System.out.println(Index_KMP(S,0,T));


    }

    private static int[] Get_Next(String T){

        int[] next = new int[T.length()];
        int j = 0,k = -1;

        next[0] = -1;

        while(j < T.length()-1){

            if( k==-1|| T.charAt(j)==T.charAt(k)){
                ++j;
                ++k;
                if(T.charAt(j)==T.charAt(k))
                    next[j] = next[k];
                else
                next[j] = k;
            }
            else
                k = next[k];
        }
        return next;
    }

    public static int Index_KMP(String S,int pos,String T){

        int[] next = Get_Next(T);

        int i = pos,j = 0;
        while(i < S.length() && j < T.length()){
            if( j==-1 || S.charAt(i)==T.charAt(j) ){
                ++i;
                ++j;
            }
            else{
                j = next[j];
            }
        }
        if(j == T.length())
            return i-T.length();
        else
            return 0;
    }
    public static int bf(String S,int pos ,String T) {

        int i = pos; // 主串的位置
        int j = 0; // 模式串的位置
        while (i < S.length() && j < T.length()) {

            if (S.charAt(i) == T.charAt(j)) { // 当两个字符相同，就比较下一个
                i++;
                j++;
            } else {
                i = i - j + 1; // 一旦不匹配，i后退
                j = 0; // j归0
            }
        }
        if (j == T.length()) {
            return i - j;
        }
        else {
            return -1;
        }


    }

}
