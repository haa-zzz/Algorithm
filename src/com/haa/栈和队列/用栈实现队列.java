package com.haa.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class 用栈实现队列 {
    /*
    请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
    实现 MyQueue 类：
    void push(int x) 将元素 x 推到队列的末尾
    int pop() 从队列的开头移除并返回元素
    int peek() 返回队列开头的元素
    boolean empty() 如果队列为空，返回 true ；否则，返回 false
     */
    /*
        方法一:
        deque1 始终储存输出顺序为队列的
        反析：两次出栈压栈刚好和原栈顺序相同，用deque1存储顺序的队列，每次在添加时,先把deque1中的元素依次出栈存储在deque2中，
            在将deque2中的出栈储存到的deque1中，
     */
    class MyQueue {
        Deque<Integer> deque1 ;
        Deque<Integer> deque2 ;
        public MyQueue() {
            deque1 = new ArrayDeque<>();
            deque2 = new ArrayDeque<>();
        }
        public void push(int x) {
            while(!deque1.isEmpty()){
                deque2.push(deque1.pop());      //辅助栈
            }
            deque2.push(x);
            while(!deque2.isEmpty()){
                deque1.push(deque2.pop());
            }
        }
        public int pop() { return deque1.pop(); }
        public int peek() { return deque1.peek(); }
        public boolean empty() { return deque1.isEmpty(); }
    }

    /*
    方法二:和方法1原理大致相同，不同在于处理的是出栈，在出栈时，先把deque1中的元素依次入栈到deque2中
     */
    class MyQueue1 {
        Deque<Integer> deque1 ;
        Deque<Integer> deque2 ;
        public MyQueue1() {
            deque1 = new ArrayDeque<>();
            deque2 = new ArrayDeque<>();
        }
        public void push(int x) {
            deque1.push(x);
        }
        public int pop() {
            if(deque2.isEmpty()){
                while (!deque1.isEmpty()){
                    deque2.push(deque1.pop());
                }
            }
            return deque2.pop();
        }
        public int peek() {
            if(deque2.isEmpty()){
                while (!deque1.isEmpty()){
                    deque2.push(deque1.pop());
                }
            }
            return deque2.peek();
        }
        public boolean empty() {
            return deque1.isEmpty() || deque2.isEmpty();
        }
    }

}
