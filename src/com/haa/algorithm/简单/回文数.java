package com.haa.algorithm.简单;

import java.util.Scanner;

public class 回文数 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(isPalindrome(in.nextInt()));
    }

    public static  boolean isPalindrome(int x) {
        /*
        if(x<0)
            return false;
        int rb = x;
        int rt = 0;
        while(x!=0){

            rt = rt*10+x%10;
            x/=10;
        }
        if(rt==rb)
            return true;
        return false;
        */
        //代码最少
        /*
        String newx =  new StringBuilder(String.valueOf(x)).reverse().toString();
        return newx.equals(String.valueOf(x));
         */
         //官方题解
        if(x<0 || (x%10==0&&x!=0))
            return false;
        int reversenumber  = 0;
        while(x > reversenumber){
            reversenumber = reversenumber*10+x%10;
            x/=10;
        }
        return x==reversenumber || x==reversenumber/10;

    }


}

