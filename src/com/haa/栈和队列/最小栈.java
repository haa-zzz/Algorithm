package com.haa.栈和队列;

import java.util.Stack;

public class 最小栈 {
    /*
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    push(x) —— 将元素 x 推入栈中。
    pop() —— 删除栈顶的元素。
    top() —— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。
     */
    /*
    方法：辅助栈:用一个辅助栈存储最小值，每次在入栈时先和辅助栈栈顶元素比较，如果小于就如辅助栈，
     */
    class MinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;        //辅助栈，记录最小值
        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            minStack  = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if(minStack.isEmpty() || x <= minStack.peek())      //入栈时先和辅助栈栈顶元素比较，如果小于就如辅助栈，
                minStack.push(x);
        }
        public void pop() {
            /*
            注意这里要用equals比较，不能用==

            “所有整形包装类对象之间值的比较，全部使用equals方法比较。说明：对于Integer var= ？在-128到127范围内的赋值，
            Integer对象在IntegerCache.cache产生，会复用已有对象，这个区间的Integer值可以直接使用==进行判断，但是这个区间之外的所有数据都会在堆上产生，
            并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断。”
            原文链接：https://blog.csdn.net/weixin_44400193/article/details/109673263
             */
            if( dataStack.pop() .equals(  minStack.peek() )){
                minStack.pop();             //判断当前出栈的是否为最小值
            }
        }

        public int top() {
            return dataStack.peek();
        }
        public int getMin() {
            return minStack.peek();
        }
    }
}
