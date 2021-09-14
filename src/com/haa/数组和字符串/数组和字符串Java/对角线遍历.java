package com.haa.数组和字符串.数组和字符串Java;

public class 对角线遍历 {
    public static void main(String[] args){
        int[][] num = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(findDiagonalOrder(num));


    }
    /*
    给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     */
    /*
    分析：遍历,
        1.用一个标志flag记录是处于上升还是下降，
        2.如果flag==1表示处于上升，newX = x-1,newY = y+1 否则表示下降，newX = x+1,newY = y-1
        3.判断newX和newY是否是数组下标，如果是，直接赋值给x和y,否则，继续判断新的坐标位置

        时间复杂度O(N*M)
        空间复杂度O(1)
     */

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0,y = 0;
        int flag = 1;
        int[] result = new int[n*m];
        int index = 0;
        while(x < n && y < m){
            result[index++] = matrix[x][y];
           // System.out.println("X: "+ x + "   Y: "+ y + "  flag"+flag);

            int newX = x + (flag==1 ? -1 : 1);
            int newY = y + (flag==1 ? 1 : -1);
           // System.out.println("newX: "+ newX + "   newY: "+ newY);
            if(newX >= 0 && newX < n && newY >=0 && newY < m){
                x = newX;
                y = newY;
            } else{
                if(flag==1){
                    x += (y==m-1 ? 1:0);
                    y += (y==m-1 ? 0:1);
                }else{

                    y += (x==n-1 ? 1:0);
                    x += (x==n-1 ? 0:1);
                }
                flag = 1-flag;
            }

        }
        return result;

    }
    public int[] findDiagonalOrder2(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int N = matrix.length;
        int M = matrix[0].length;

        int row = 0, column = 0;

        int direction = 1;

        int[] result = new int[N*M];
        int r = 0;

        while (row < N && column < M) {

            result[r++] = matrix[row][column];

            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                if (direction == 1) {
                    row += (column == M - 1 ? 1 : 0) ;
                    column += (column < M - 1 ? 1 : 0);

                } else {
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;

            }
        }
        return result;
    }
    public int[] findDiagonalOrder1(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0,column = 0;
        int r = 0;
        int[] result = new int[n*m];
        int direction = 1;
        while(row < n && column < m){

            result[r++] = matrix[row][column];

            int new_row = row + (direction==1 ? -1:1);
            int new_column = column + (direction==1 ? 1:-1);

            if(new_row<0 || new_column<0 || new_row == n || new_column==m){
                if(direction==1){

                    row+=(column==m-1? 1:0);
                    column +=(column<m-1? 1:0);
                }
                else{
                    row+=(row<n-1? 1:0);
                    column+=(row==n-1?1:0);
                }
                direction = 1-direction;
            }
            else{
                row = new_row;
                column  =new_column;
            }
        }
        return result;

    }

}
