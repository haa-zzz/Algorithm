package com.haa.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class 逆波兰表达式求值 {
    /*
    根据 逆波兰表示法，求表达式的值。
有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
说明：
整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

     */
    /*
    分析：使用栈，遇到数字直接入栈，遇到符号分情况计算，把计算结果入栈，最后栈里的数字就是最后的结果
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    deque.push(deque.pop() + deque.pop());      //加号
                    break;
                case "-":
                    int a = deque.pop();
                    deque.push(deque.pop() - a);             //减号
                    break;
                case "*":
                    deque.push(deque.pop() * deque.pop());    //乘号
                    break;
                case "/":
                    int b = deque.pop();
                    deque.push(deque.pop() / b);             //除号
                    break;
                default:
                    deque.push(Integer.parseInt(tokens[i]));        //遇到数字直接入栈
                    break;
            }
        }
        return deque.pop();
    }
}
