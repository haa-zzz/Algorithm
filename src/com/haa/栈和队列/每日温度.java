package com.haa.栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class 每日温度 {
    /*
    请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，
    请在该位置用 0 来代替。

    例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
    提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     */
    /*
    方法一.暴力,用双层遍历暴力解题，第一层遍历遍历整个数组，第二层遍历遍历当前数后边的数记录要想观测到更高的气温，至少需要等待的天数。
       时间复杂度：O(n^2)
     */
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] arr  = new int[len];
        for(int j = 0; j < len-1; j++){
            int k = 1;
            int i;
            for( i = j+1; i < len; i++){
                if(T[j] >= T[i])
                    k++;
                else{
                    arr[j] = k;             //找到了比当前更高的温度，记录至少需要等待的天数
                    break;
                }
            }
            if(i == len)                //没找到，记录0
                arr[j] = 0;
        }
        return arr;

    }
    /*
    方法2：栈,用一个栈存储数组元素的下标，在添加的过程中如果当前的元素(i是对应下标)大于栈顶元素，则吧ans数组在栈顶元素对应的index位置变为
    i-index，并把栈顶元素出栈，否则，依次向后添加，
     */
    public int[] dailyTemperatures1(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < length; i++){
            int num = T[i];
            while(!deque.isEmpty() && deque.peek() < num){
                int index = deque.pop();
                ans[index] = i-index;
            }
            deque.push(i);
        }
        return ans;
    }
}
