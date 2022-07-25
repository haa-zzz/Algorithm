package com.haa.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

/*
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。


 */
public class 包含min函数的栈 {
    /*
    注：此题如果用==将会无法通过 Integer的equals重写过，比较的是内部value的值， ==如果在[-128,127]会被cache缓存,超过这个范围则比较的是对象是否相同
     */
    static class MinStack {
        Deque<Integer> deque;
        Deque<Integer> getmin;
        public MinStack() {
            deque = new ArrayDeque<>();
            getmin = new ArrayDeque<>();
        }
        public void push(int x) {
            deque.push(x);
            if( getmin.isEmpty() || x <= getmin.peek()){
                getmin.push(x);
            }
        }
        public void pop() {
            if(!deque.isEmpty()){

                if( deque.peek().equals( getmin.peek() ) )
                    getmin.pop();
                deque.pop();
            }
        }

        public int top() {
            return deque.peek();
        }

        public int min() {
            System.out.println(getmin);
            return getmin.peek();

        }
    }
    public static void main(String[] args){

        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());

    }
}
