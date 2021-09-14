package com.haa.algorithm.中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    /*
    给出一个区间的集合，请合并所有重叠的区间。
    intervals[i][0] <= intervals[i][1]
     */
    /*
    方法:排序加合并，把区间按第一个元素从小到大排序，排序后进行合并，具体的，记left为当前最小的起点，right为终点，
        如果当前终点大于下一个数组的起点的时候，比较当前终点和下一个终点的大小，取为right
        时间复杂度   O(N *log N) 主要是排序的开销
        空间复杂度   O(log n)
     */
    public int[][] merge(int[][] intervals) {

        if(intervals.length==0 || intervals== null){
            return new int[0][2];
        }

        Arrays.sort(intervals, (s1, s2) -> s1[0] - s2[0]);

        List<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while(i < n){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < n-1 && intervals[i+1][0] <= right){
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            list.add(new int[]{left,right});
            i++;
        }
        return list.toArray(new int[0][]);


    }
    public int[][] merge1(int[][] intervals) {

        int n = intervals.length;
        int index = -1;
        Arrays.sort(intervals, (data1, data2) -> data1[0] - data2[0]);
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i==0 || intervals[i][0] > intervals[i-1][1]){
                index++;
            }
            else{
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i][1],intervals[i-1][1]);
                if(!list.isEmpty()){
                    list.remove(index);
                }
            }
            list.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        return list.toArray(new int[list.size()][]);

    }

}
