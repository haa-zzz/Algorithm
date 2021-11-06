package com.haa.数组和字符串.数组和字符串Java;

import java.util.Scanner;

public class 获得最多的奖金 {
    /*
    小明在越南旅游，参加了当地的娱乐活动。小明运气很好，拿到了大奖， 到了最后的拿奖金环节。小明发现桌子上放着一列红包，每个红包上写着奖金数额。
    现在主持人给要求小明在这一列红包之间“切”2刀，将这一列红包“切”成3组，并且第一组的奖金之和等于最后一组奖金和（允许任意一组的红包集合是空）。
    终第一组红包的奖金之和就是小明能拿到的总奖金。小明想知道最多能拿到的奖金是多少，你能帮他算算吗。

    举例解释：桌子上放了红包  1, 2, 3, 4, 7, 10。小明在“4,7”之间、“7,10” 之间各切一刀，将红包分成3组 [1, 2, 3, 4]   [7]   [10]，
    其中第一组奖金之和=第三组奖金之和=10，所以小明可以拿到10越南盾。
     */
    /*
    方法：双指针，一个指针i用于向后遍历, 维护sum_left.去尝试计算 0-i 作为奖金的可能。用指针j 从后向前遍历，维护sum_right.因为都是正整数，所以
    每一次 如果 sum_left > sum _right 的话就让j--，直到i==j
          如果 sum_left == sum_right 的话 就去更新奖金
          否则 把i++ ,进行下一次尝试

      时间复杂度O(N)    :只需要遍历一次数组
      空间复杂度O(1)

     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(fun(arr));
    }
    public static long fun(int[] arr){
        int n = arr.length;
        long sum_left = 0, sum_right = 0;
        int j = n - 1,i = 0;
        long sum = 0;   //不用long的话，测试用例有一个过不了
        while (j > 0 && i < n) {
            sum_left += arr[i];
            while (j > i && sum_left > sum_right) {
                sum_right += arr[j];
                j--;
            }
            if (sum_left == sum_right) {
                sum = sum_left;

            }
            i++;
        }
        return sum;
    }
}
