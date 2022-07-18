package 面试;

import java.util.LinkedList;

public class 生产者消费者模型1 {

}
class Solution {

    public void fun() {
        int MAX_VALUE = 5;          //缓存区大小
        LinkedList queue = new LinkedList<Integer>();       //产品缓存区

        new Thread(() -> {      //生产者线程
           while (true) {
               synchronized (queue) {
                   if(queue.size() > MAX_VALUE) {   //缓存区满的话，释放锁资源，等待消费者消费后被唤醒
                       try {
                           queue.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   queue.offer(1);      //生产一个产品
                   queue.notify();          //唤醒消费者线程，可以来消费了
               }
           }
        }).start();

        new Thread(() -> {          //消费者线程
            while (true) {
                synchronized (queue) {
                    if(queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                }
            }

        }).start();
    }


}