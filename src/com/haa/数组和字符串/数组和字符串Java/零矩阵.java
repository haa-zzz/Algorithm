package com.haa.数组和字符串.数组和字符串Java;

public class 零矩阵 {
    /*
    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     */
    /*
    分析：用两个数组，一个存这一行是否为0，另一个存列是否为0，最后两次遍历
    时间复杂度O(M*N)
    空间复杂度O(M*N)
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] line = new boolean[n];
        boolean[] column = new boolean[m];
        //找出要清零的行列
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(matrix[i][j] == 0){
                    line[i] = true;
                    column[j] = true;
                }
            }
        }
        //对行清零
        for(int i = 0; i < n; i++){
            if(line[i]){
                for(int j = 0; j < m; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        //对列清零
        for(int i = 0; i < m; i++){
            if(column[i]){
                for(int j = 0; j < n; j++){
                    matrix[j][i] = 0;
                }
            }
        }

    }
}
