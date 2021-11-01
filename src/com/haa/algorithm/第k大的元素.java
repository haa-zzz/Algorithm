package com.haa.algorithm;

import java.util.*;

/*
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

你的KthLargest类需要一个同时接收整数k 和整数数组nums的构造器，它包含数据流中的初始元素。每次调用KthLargest.add，返回当前数据流中第K大的元素。


/*
    自己的做法是放到ArrayList数组中，排序输出
    优化：使用堆效率更高

 */
public class 第k大的元素 {


}
class KthLargest {
    int t = 0;
    Queue<Integer> queue ;

    public KthLargest(int k, int[] nums) {
       t = k;
       for(int num:nums){
           add(num);
       }
    }

    public int add(int val) {
        if(queue.size()<t)
            queue.offer(val);                        //当size()==t时，queue.peek()就是第t大的数
        else if(queue.peek()<val){                  //求第k大的，始终只维护k个数,如果添加的数比第k大的数的大，
                                                    // 那么他就是第k+1大的数了，这个数出队列，新数进队列
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
/*
class KthLargest {
    int t = 0;
    List<Integer> list= new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        t = k;
        for(int num:nums ){
            list.add(num);
        }
    }

    public int add(int val) {
        list.add(val);
        Collections.sort(list,((o1, o2) -> o2-o1));
        return list.get(t-1);
    }
}
 */