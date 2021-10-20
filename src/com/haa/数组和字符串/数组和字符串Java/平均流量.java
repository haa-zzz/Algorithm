package com.haa.数组和字符串.数组和字符串Java;

import java.util.Scanner;

public class 平均流量 {
    public static void main(String[] args) {
        int n,c;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        c = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        solution(arr,c);
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
    public static void solution(int[] arr,int c){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
            if(sum > c*(i+1)){
                arr[i] -= (sum-c*(i+1));
                sum-= (sum-c*(i+1));
            }
        }
    }
}
