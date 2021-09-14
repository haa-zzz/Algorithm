package com.haa.algorithm.简单;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class 最小时间差 {
    public static void main(String[] args){
        TreeSet<String> t = new TreeSet<>();
        t.add("00:00");
        t.add("00:12");
        t.add("23:12");
        t.add("13:00");
        System.out.println(t);
    }
    /*
           通过，执行用时：18 ms, 在所有 Java 提交中击败了23.58%的用户
           内存消耗：41.2 MB, 在所有 Java 提交中击败了25.00%的用户

           优化：先把每个时间拿出来放在time[]中，再排序
     */
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints,(o1, o2)->(o1.compareTo(o2)));
        int n = timePoints.size();
        String t1 = timePoints.get(0);
        String t2 = timePoints.get(n-1);
        int t1h = Integer.parseInt( t1.substring(0,2) )*60 +
                Integer.parseInt(t1.substring(3,5) );
        int t2h = Integer.parseInt( t2.substring(0,2) )*60 +
                Integer.parseInt(t2.substring(3,5) );
        int min = t1h+24*60-t2h;
        for(int i = 1; i < n; i++){
            String s1 = timePoints.get(i-1);
            String s2 = timePoints.get(i);
            int h1= Integer.parseInt( s1.substring(0,2) )*60 +
                    Integer.parseInt(s1.substring(3,5) );
            int h2 = Integer.parseInt( s2.substring(0,2) )*60 +
                    Integer.parseInt(s2.substring(3,5) );
            min = Math.min( h2-h1 , min);

        }
        return min;

    }
}
