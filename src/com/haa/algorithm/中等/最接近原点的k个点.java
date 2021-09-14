package com.haa.algorithm.中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 最接近原点的k个点 {
    /*
    我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

     */
    public int[][] kClosest(int[][] points, int K) {

        int n = points.length;
        int[][] arr  = new int[n][2];

        for(int i = 0; i < n; i++) {
            arr[i][0] = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[][] rt = new int[K][2];
        for(int i = 0; i < K ;i++){
            rt[i][0] = points[arr[i][1]][0];
            rt[i][1] = points[arr[i][1]][1];
        }

        return rt;


    }
    /*
    官方排序
     */
    public int[][] kClosest2(int[][] points, int K) {

        Arrays.sort(points, ((o1, o2) -> o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]-o2[1]*o2[1]));
        return Arrays.copyOfRange(points,0,K);
    }
    /*
    优先排序
     */
    
}
