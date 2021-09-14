package com.haa.algorithm;

public class 判断子序列 {
    /*
    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

    你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
    （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/is-subsequence
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    自己的解法
     */
    /*
    public boolean isSubsequence(String s, String t) {
        int h1 = s.length();
        int h2 = t.length();
        if(h1>h2)
            return false;
        if(h1 == 0)
            return true;
        int i = 0;
        for(int j = 0; j < h2; j++){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            if(i==h1)
                return true;
        }
        return false;

    }

     */
    /*
    官方题解：双指针,基本一样,比自己的更简洁明了
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0,j = 0;
        while(i < n && j < m){
            if(s.charAt(i)==t.charAt(j))
                i++;
            j++;
        }
        return i == n;
    }
}
