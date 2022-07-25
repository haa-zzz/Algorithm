package com.haa.栈和队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 队列的最大值 {
    /*
    请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
    若队列为空，pop_front 和 max_value需要返回 -1
     */
    /*
    方法:用一个双端队列来维护最大值，如果新来的元素大于队列尾部的元素，让他们出栈。 最后把新来的元素添加到队列的尾部。
        那么队列的头部就是当前队列最大的元素。
        因为队列是头部先出队的，如果你先入队的是较小的值，那么较小的值会被新插入的较大值替代。而如果你已经出队列到较大值的时候，
        说明此时较小值都已经出队列完了。所以就不会出现最大值缺失的问题。
        比如  5 7 9 2 6 3 1   队列里保存的就是 9 6 3 1 只要9没有出队，最大值就是9，9出队了，最大值就是6了
     */
    class MaxQueue {
        Queue<Integer> dataQueue;
        Deque<Integer> deque;   //双端队列
        public MaxQueue() {
            dataQueue = new LinkedList<>();
            deque = new LinkedList<>();
        }
        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }
        public void push_back(int value) {
            dataQueue.offer(value);
            while(!deque.isEmpty() && deque.peekLast() < value) //新来的元素大于队列元素，队尾元素直接出队。
                deque.pollLast();
            deque.offerLast(value);     //把新来的追加到队尾
        }
        public int pop_front() {
            if(dataQueue.isEmpty()) return -1;
            if(dataQueue.peek().equals(deque.peekFirst()))  //如果相同，元素出队列
                deque.pollFirst();
            return dataQueue.poll();
        }
    }
}
