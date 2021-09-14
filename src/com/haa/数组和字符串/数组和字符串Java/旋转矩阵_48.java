package com.haa.数组和字符串.数组和字符串Java;

public class 旋转矩阵_48 {
    /*
    给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
    不占用额外内存空间能否做到？
     */
    /*
    通过观察可发现如下规律：旋转后
        matrix[i][j] = matrix[n-1-j][i]
        思路：
            旋转90度，我们可每次交换4个值，他们刚好围成一圈
            比如4*4的矩阵，可同时交换（0,0）（0,3），（3,3），（3，0）

        遍历范围的确定：
            基于上面的旋转思路，我们可发现可由一个点直接确定四个点的值，我们在遍历时只需遍历左上方，那么全部的位置就可访问到
            如果n为偶数，刚好遍历左上方
            如果n为奇数，那么最后一层一定只有一个数，他旋转还是他本身，所以i可以不变，但是j要加1，那3来说，j不加1，访问不到（0,1）
         故i的范围为n/2，j的范围为（n+1）/2

         时间复杂度O(N^2)
         空间复杂度O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < (n+1)/2; j++){
                int number = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = number;
            }
        }
    }
}
