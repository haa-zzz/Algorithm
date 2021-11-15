package com.haa.深搜广搜;

public class 单词搜索_79 {

    /*
     * 等同于 矩阵中的路径_offer 12
    给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母不允许被重复使用。
     */
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean flag = dfs(board,visited,i,j,word,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if(board[i][j] != word.charAt(index)){
            return false;
        }else if(index == word.length()-1){
            return true;
        }
        visited[i][j] = true;
        int[][] directions = { {0,1},{0,-1},{1,0},{-1,0}};
        boolean result = false;
        for(int[] dir : directions){
            int newI = i+dir[0], newJ = j+dir[1];
            if(newI >= 0 && newJ >= 0 && newI < board.length && newJ < board[0].length){
                if(!visited[newI][newJ]){
                    boolean flag = dfs(board,visited,newI,newJ,word,index+1);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
