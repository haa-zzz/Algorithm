package com.haa.algorithm.简单;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/backspace-string-compare
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 比较含空格的字符串 {
    public static void main(String[] args){
        String S = "ab#c";
        String T = "ad#c";
    }
    /*
    法一：
     */
    public boolean backspaceCompare(String S, String T) {
        String s1 = "";
        String t1 = "";
        for(int i = 0; i < S.length(); i++){
            if( S.charAt(i) !='#')
                s1+=S.charAt(i);
            else{
                if(s1.length()>0){
                    s1 = s1.substring(0,s1.length()-1);
                }
            }

        }
        for(int i = 0; i < T.length(); i++){
            if( T.charAt(i) !='#' )
                t1+=T.charAt(i);
            else{
                if(t1.length()>0){
                    t1 = t1.substring(0,t1.length()-1);
                }
            }
        }
        return s1.equals(t1);
    }
    /*
    法二：
     */
    public boolean backspaceCompare1(String S, String T) {


        return build(S).equals(build(T));
    }

    private String build(String s) {
        Stack<Character> ans = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);

    }

}
