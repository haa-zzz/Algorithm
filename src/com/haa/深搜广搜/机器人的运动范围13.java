package com.haa.深搜广搜;

public class 机器人的运动范围13 {

    /*
    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
    它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
    请问该机器人能够到达多少个格子？
     */
    /*
    分析：深度优先搜索。从（0，0）节点开始搜索，如果这个节点的下标不在范围内或者已经访问过或者位数之和大于k了，就直接返回
    否则，访问当前节点，并对它的左、右、上、下四个位置搜索
    时间复杂度O(m*n) 遍历一遍数组
    空间复杂度O(m*n) 栈帧的调用深度最深可能是m*n
     */
    int count = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        dfs(0,0,m,n,k,0,visit);
        return count;
    }
    void dfs(int i, int j,int m, int n,int k,int num, boolean[][] visit){
        if(i < 0 || j < 0  || i >= m || j >= n || visit[i][j] || num > k){  //结束条件判断
            return;
        }
        count++;
        visit[i][j] = true;
        //向四个方向开始搜索
        dfs(i - 1, j, m, n, k, num-getCount(i)+getCount(i-1), visit);
        dfs(i + 1, j, m , n, k, num-getCount(i)+getCount(i+1), visit);
        dfs(i , j+1, m , n, k, num-getCount(j)+getCount(j+1), visit);
        dfs(i , j-1, m, n, k, num-getCount(j)+getCount(j-1), visit);
    }
    int getCount(int i){        //获取i对应的位数和
        int sum = 0;
        while(i != 0){
            sum+= i % 10;
            i/=10;
        }
        return sum;
    }
}
