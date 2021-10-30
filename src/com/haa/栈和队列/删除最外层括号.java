package com.haa.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

/*
有效括号字符串为空("")、"(" + A + ")"或A + B，其中A 和B都是有效的括号字符串，+代表字符串的连接。
    例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
如果有效字符串S非空，且不存在将其拆分为S = A+B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。
给出一个非空有效字符串S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
对S进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S。

 */
public class 删除最外层括号 {
    /*
    法一:使用栈，碰到 "(" 就入栈，碰到 ")" 就把栈顶的一个 "(" 消掉，每次栈空的时候，都说明找到了一个原语，
    记录下每个原语的起始位置和结束位置，取原字符串在原语的起始位置+1到原语的结束位置的子串便得到原语删除了最外层括号的字符串，
    拼接，即可解出答案。
    时间复杂度O(N)
    空间复杂度O(N)
     */
    public String removeOuterParentheses(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int deix = 0;
        for(int i = 0; i < S.length(); i++){
            char a = S.charAt(i);
            if(a=='('){
                stack.push(a);
            }
            else{
                stack.pop();                //找到一个原语
                if(stack.isEmpty()){
                    sb.append(S.substring(deix+1,i));       //拼接
                    deix = i+1;
                }
            }
        }
        return sb.toString();

    }
    /*
    法二:用一个数字记录是否找到原语，当遇到左括号，level+1，遇到右括号，level-1，当找到一个原语时level刚好为0
     时间复杂度O(N)
     空间复杂度O(1)
     */
    public String removeOuterParentheses1(String S) {
        StringBuilder sb  = new StringBuilder();
        int level = 0;
        for(char c: S.toCharArray()){
            if(c==')')
                level--;
            if(level>=1)            //此时说明在一个原语内，做添加
                sb.append(c);
            if(c=='(')
                level++;
        }
        return sb.toString();
    }
}
