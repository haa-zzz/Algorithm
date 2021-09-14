package com.haa.algorithm.简单;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 公平的糖果交换 {
    /*
    爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。

    因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

    返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

    如果有多个答案，你可以返回其中任何一个。保证答案存在。
     */
    /*
    分析:如果x,y是要交换的数，那么sum_a-x+y==sum_b-y+x
        即   x-y = (sum_a-sum_b)/2
    基于此：可有两种解题方法

     */
    /*
    1.双指针，先对数组排序，后采用双指针法解题
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum_a = Arrays.stream(A).sum();
        int sum_b = Arrays.stream(B).sum();
        int delta = (sum_a-sum_b)/2;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;          //开始的两指针都指向0
        int j = 0;
        while(i < A.length && j < B.length){

            if( A[i] - B[j]  < delta){     //如果小于，i++,即把除数增大
                i++;
            }
            else if(A[i] - B[j]  > delta){      //如果大于，j--,把被除数增大
                j++;
            }
            else{                               //相等，就返回
                return new int[]{A[i],B[j]};
            }

        }
        return null;
    }
    /*
    2.哈希表+遍历
    把A数组用哈希表存储，因为即使去除重复交换的数也不受影响，所以可用哈希表存储，遍历B数组寻找哈希表中是否存在(sum_a-sum_b)/2+y
     */
    public int[] fairCandySwap1(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {          //如果存在，返回
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
