package com.haa.栈和队列;

/*
    使用队列实现栈的下列操作：
    push(x) -- 元素 x 入栈
    pop() -- 移除栈顶元素
    top() -- 获取栈顶元素
    empty() -- 返回栈是否为空
    注意:
    你只能使用队列的基本操作-- 也就是push to back, peek/pop from front, size, 和is empty这些操作是合法的。
    你所使用的语言也许不支持队列。你可以使用 list 或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
    你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈 {
    /*
    方法一:两个队列，queue2做一个备份的功能，每次在添加时，先向queue1中添加，再把queue2中的数据出栈放置到queue1中，
        这样queue1中就是实现好的栈，最后还要把queue1的数据复制到queue2中，queue1置空，
     */

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public 用队列实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(int x) {
        queue1.add(x);
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    public int pop() {
        return queue2.poll();
    }
    public int top() {
        return queue2.peek(); }
    public boolean empty() {
        return queue2.isEmpty();
    }

    /*
    方法二:一个队列
    分析：使用一个队列也可完成上面类似的操作，道理都一样，这个是用自身替代克隆栈
     */
    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();

        }
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for(int i = 0; i < n; i++){
                queue.offer(queue.poll());
            }
        }
        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();

        }
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
