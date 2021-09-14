package com.haa.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 回文对 {
    /*
    给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     */
    /*
    分析：
         枚举前缀和后缀
        s1+s2 能够成回文串，记其长度分别为len1,len2;
        分三种情况：
            1.len1 = len2 此时s1是s2的反转
            2.len1 > len2 ，此时把s1拆成t1+t2,则t1是s2的反转,t2是回文串
            3.len1 < len2 , 此时把s2拆成t1+t2,则t2是s1的反转,t1是回文串
            这样，对于每一个字符串，我们令其为 s1 和 s2 中较长的那一个，然后找到可能和它构成回文串的字符串即可。
     */
    private List<String> list = new ArrayList<>();
    private HashMap<String,Integer> hm = new HashMap<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for(String word:words){
            list.add(new StringBuilder(word).reverse().toString());
        }
        for(int i = 0; i < n ; i++){
            hm.put(list.get(i),i);
        }
        List<List<Integer>> rt = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String word = words[i];
            int m = word.length();
            if(m==0)
                continue;
            for(int j = 0; j <= m; j++){
                if(isPalindrome(word,j,m-1)){                   //情况2
                    int leftId = findword(word,0,j-1);
                    if(leftId != -1 && leftId != i){
                        rt.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {       //情况3
                    int rightId = findword(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        rt.add(Arrays.asList(rightId, i));
                    }
                }

            }
        }
        return rt;
    }
    private boolean isPalindrome(String s,int left,int right){
        int len = right-left+1;
        for(int i = 0; i < len/2; i++){
            if(s.charAt(i+left)!=s.charAt(right-i))
                return false;
        }
        return true;
    }
    private int findword(String s,int left,int right){
        return hm.getOrDefault(s.substring(left,right+1),-1);
    }
}
