package com.haa.algorithm.简单;

import java.util.ArrayList;

public class 拥有最多糖的孩子 {
    public static void main(String[] args){
        int[] can = new int[]{2,7,8};
        int e = 3;
        ArrayList<Boolean>  list = kidsWithCandies(can,e);

    }
    public static ArrayList<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> l = new ArrayList<>();
        for(int i = 0; i < candies.length; i++)
        {

            for(int j = 0; j < candies.length ; j++){
                if(j==i)
                    continue;
                if(candies[i]+extraCandies < candies[j]){
                    l.add(false);
                    break;
                }
            }
            if(l.size()<i+1)
                l.add(true);
        }
        return l;

    }
}

