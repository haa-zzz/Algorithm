package com.haa.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 图像渲染 {
    /*
    有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。

    给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。

    为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。

    最后返回经过上色渲染后的图像。

    输入:
    image = [[1,1,1],[1,1,0],[1,0,1]]
    sr = 1, sc = 1, newColor = 2
    输出: [[2,2,2],[2,2,0],[2,0,1]]


     */
    /*
    分析:采用广度优先搜索或者深度优先搜索，从给定的坐标开始只进行一次搜索即可，和岛屿数量这道题类似，都要向四个方向扩展
    时间复杂度：O(n*m)，其中 n 和 m 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。
    空间复杂度：O(n*m)，其中 n 和 m 分别是二维数组的行数和列数。主要为队列的开销。
     */
    /*
    第一种：dfs，
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0){
            return image;
        }
        if(image[sr][sc]!=newColor){
            dfs(image,sr,sc,image[sr][sc],newColor);
        }
        return image;
    }
    private void dfs(int[][] image, int i, int j, int color,int newColor){

        int n = image.length;
        int m = image[0].length;
        if(i<0 || i>=n || j<0 || j>=m || image[i][j]!=color){      //终止条件
            return;
        }
        image[i][j] = newColor;                                 //标记
        dfs(image,i-1,j,color,newColor);                      //向四个方向深度搜索
        dfs(image,i+1,j,color,newColor);
        dfs(image,i,j-1,color,newColor);
        dfs(image,i,j+1,color,newColor);
    }
    /*
    第二种：bfs
     */
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0){
            return image;
        }
        if(image[sr][sc]!=newColor){
            bfs(image,sr,sc,image[sr][sc],newColor);
        }
        return image;
    }

    private void bfs(int[][] image, int i, int j, int color, int newColor) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[] { i, j });
        while(!list.isEmpty()){
            int[] cur = list.poll();
            i = cur[0];
            j = cur[1];
            if(0 <= i && i < image.length && 0 <= j && j < image[0].length && image[i][j] == color) {
                image[i][j] = newColor;
                list.add(new int[] { i + 1, j });
                list.add(new int[] { i - 1, j });
                list.add(new int[] { i, j + 1 });
                list.add(new int[] { i, j - 1 });
            }
        }
    }
}
