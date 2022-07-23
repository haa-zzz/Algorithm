package com.haa.数组和字符串.数组和字符串Java;

import java.util.PriorityQueue;
import java.util.Queue;

/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    力抠：295
 */
public class 数据流中的中位数 {
    /*
        使用优先队列：
        建立一个小顶堆A 和 大顶堆B, 各保存一半元素，且规定:
        A 保存 较大 的一半，长度为 N/2(N为偶数) 或 (N+1)/2 (N为奇数) 5678
        B 保存 较小 的一半，长度为 N/2(N为偶数) 或 (N+1)/2 (N为奇数) 4321

        设元素总数为N = m+n,其中m和n分别为 A和B 中元素的个数
        add时：
        当 m = n（即 N 为 偶数）：向 A 添加一个元素。实现方法：将新元素 num 插入至 B ，再将 B 堆顶元素插入至 A ；
        当 m != n (N 为奇数)： 向 B 添加一个元素. 实现方法：将新元素 num 插入至 A ，再将 A 堆顶元素插入至 B ；

     */
    class MedianFinder {
        Queue<Integer> minQueue, maxQueue;
        public MedianFinder() {
            minQueue = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            maxQueue = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
        }
        public void addNum(int num) {
            if(minQueue.size() != maxQueue.size()) {    //当前是 奇数个时，插到maxQueue中。
                minQueue.add(num);
                maxQueue.add(minQueue.poll());
            } else {                            //当前是 偶数个时，插到minQueue中。
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            }
        }
        public double findMedian() {
            return minQueue.size() != maxQueue.size() ? minQueue.peek() : (minQueue.peek() + maxQueue.peek()) / 2.0;
        }
    }
}
