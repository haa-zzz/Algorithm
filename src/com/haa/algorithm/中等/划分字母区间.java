package com.haa.algorithm.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 划分字母区间 {
    /*
    字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String S = in.next();
        System.out.println(partitionLabels(S));
    }
    /*
    自己的做法：双指针，最坏时间复杂度O(N*N(N+1)/2)
    一个指针重头到尾遍历，另一个指针寻找可能是要求片段的最小下标
     */
    public static List<Integer> partitionLabels(String S) {
        int i = 0,j = S.length()-1;
        int MAXList = 0;
        int last = 0;
        List<Integer> list = new ArrayList<>();
        while(i < S.length()){
            while( j>last && S.charAt(j)!=S.charAt(i))
                j--;
            last = j;
            if(i == last){
                System.out.println(MAXList+"    "+last);
                list.add(last-MAXList+1);
                MAXList = last+1;
            }
            i++;
            j = S.length()-1;

        }
        return list;
    }
    /*
    官方做法：
        先用数组储存每个字母出现的最晚下标，然后用双指针
     */
    public static List<Integer> partitionLabels1(String S) {
        int[] word = new int[26];
        for(int i = 0;i < S.length(); i++){
            word[S.charAt(i)-'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int start = 0,end = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(word[S.charAt(i)-'a'],end);
            if(i == end){
                list.add(end-start+1);
                start = i+1;
            }

        }
        return list;
    }

}
