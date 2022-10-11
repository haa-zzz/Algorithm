package 面试.常用数据结构;

import java.util.*;
public class BTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(numIslands(grid));
    }
    public static int numIslands(int[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int lands_num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    lands_num++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return lands_num;
    }
    private static void dfs(int[][] grid, int i, int j,int n, int m) {
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0){      //终止条件
            return;
        }
        grid[i][j] = 0;          //把当前位置标记为0
        dfs(grid, i - 1, j, n, m);        //向四个方向深度搜索
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i, j - 1, n, m);
        dfs(grid, i, j + 1, n, m);
    }
}
