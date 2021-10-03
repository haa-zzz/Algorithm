package com.haa.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {
    /*
    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    此外，你可以假设该网格的四条边均被水包围。
    示例：
    输入：grid = [
          ["1","1","1","1","0"],
          ["1","1","0","1","0"],
          ["1","1","0","0","0"],
          ["0","0","0","0","0"]
         ]
    输出：1
     */
    /*
    方法1.DFS,把给定的二维网格看做一个无向图,为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 1，则以其为起始节点开始进行深度优先搜索。
        在深度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0。最后深度优先搜索的次数就是答案

     */

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int lands_num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    lands_num++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return lands_num;
    }

    private void dfs(char[][] grid, int i, int j,int n, int m) {

        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]=='0'){      //终止条件
            return;
        }
        grid[i][j] = '0';           //把当前位置标记为0
        dfs(grid, i - 1, j, n, m);        //向四个方向深度搜索
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i, j - 1, n, m);
        dfs(grid, i, j + 1, n, m);
    }
    /*
    方法2：BFS,广度优先搜索,把给定的二维网格看做一个无向图,为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 1，则以其为起始节点开始进行广度优先搜索，
        在广度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0。最后广度优先搜索的次数就是答案
     */
    public int numIslands1(char[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int lands_num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    lands_num++;
                    bfs(grid,i,j);
                }
            }
        }
        return lands_num;
    }
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[] { i, j });
        while(!list.isEmpty()){
            int[] cur = list.poll();
            i = cur[0];
            j = cur[1];
            if(0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[] { i + 1, j });
                list.add(new int[] { i - 1, j });
                list.add(new int[] { i, j + 1 });
                list.add(new int[] { i, j - 1 });
            }
        }
    }
}
