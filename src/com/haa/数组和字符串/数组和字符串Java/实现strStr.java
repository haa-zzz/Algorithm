package com.haa.数组和字符串.数组和字符串Java;

public class 实现strStr {
    /*
    实现 strStr() 函数。
    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
    示例 1:

    输入: haystack = "hello", needle = "ll"
    输出: 2
     */
    /*
    分析：kmp算法问题，kmp算法是基于dp算法的优化，主要就是用来解决字符串的模式匹配问题，kmp算法的核心在next数组的计算，
        其中next[i]表示优化后，匹配串和主串不相等时匹配串要移动的位置。


     */
    private int[] Get_next(String T){
        int[] next = new int[T.length()];
        int j = 0,k = -1;
        next[0] = -1;

        while(j < T.length()-1){

            if( k==-1 || T.charAt(j)==T.charAt(k)){
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
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 || needle.length() == 0){
            return -1;
        }
        int[] next = Get_next(haystack);
        int i = 0,j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(j==-1 || haystack.charAt(i)==needle.charAt(j)){
                ++i;
                ++j;
            }
            else{
                j = next[j];
            }
        }
        if(j == needle.length())
            return i-needle.length();
        else
            return 0;
    }
}
