package com.haa.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个位置。
 */
public class 跳跃游戏 {
    public static void main(String[] args){
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;  i < n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(canJump(arr));
    }
    //自己写的：
    /*
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] arr = new boolean[n];
        arr[0] = true;
        for(int i = 0; i < n-1; i++){
            if(arr[i]==true){
                int count = nums[i]+i;
                if(count>=n-1)
                    return true;
                else {
                    Arrays.fill(arr,i+1,count+1,true);
                }
                if(arr[n-1]==true)
                    break;
            }
        }
        return arr[n-1];


    }

     */
    //贪心算法
    public static boolean canJump(int[] nums) {
        int cover = 0;
        for(int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if(cover >= (nums.length-1)) {
                return true;
            }
        }

        return false;
    }
}
