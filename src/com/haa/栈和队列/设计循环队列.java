package com.haa.栈和队列;

public class 设计循环队列 {
    /*
    设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
        它也被称为“环形缓冲器”。
    循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，
        即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
     */
    /*
        分析：循环队列中有两个指针head，tail，一个指向队头，一个指向队尾，在添加时队尾指针后移，在删除时队头指针后移，
            注意判断队满的条件：((tail + 1) % size) == head;
     */
    class MyCircularQueue {

        private int[] data;
        private int head;
        private int tail;
        private int size;

       // MyCircularQueue(k): 构造器，设置队列长度为 k 。
        public MyCircularQueue(int k) {
            data = new int[k];
            head = -1;
            tail = -1;
            size = k;
        }

       //  向循环队列插入一个元素。如果成功插入则返回真。
        public boolean enQueue(int value) {
            //队满不能插入
            if (isFull() == true) {
                return false;
            }
            //队空时要把head指针指向第一个
            if (isEmpty() == true) {
                head = 0;
            }
            //tail指针后移
            tail = (tail + 1) % size;
            data[tail] = value;
            return true;
        }

       //从循环队列中删除一个元素。如果成功删除则返回真。
        public boolean deQueue() {
            //队空无法删除
            if (isEmpty() == true) {
                return false;
            }
            //特判只有一个元素的情况
            if (head == tail) {
                head = -1;
                tail = -1;
                return true;
            }
            head = (head + 1) % size;
            return true;
        }

      // Front: 从队首获取元素。如果队列为空，返回 -1 。
        public int Front() {
            if (isEmpty() == true) {
                return -1;
            }
            return data[head];
        }

       // Rear: 获取队尾元素。如果队列为空，返回 -1 。
        public int Rear() {
            if (isEmpty() == true) {
                return -1;
            }
            return data[tail];
        }

       //检查循环队列是否为空。
        public boolean isEmpty() {
            return head == -1;
        }

      //检查循环队列是否已满。
        public boolean isFull() {
            return ((tail + 1) % size) == head;
        }
    }

}
