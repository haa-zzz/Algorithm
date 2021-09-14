package com.haa.栈和队列;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 钥匙和房间 {
    /*
    有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
    在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，
    其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
    最初，除 0 号房间外的其余所有房间都被锁住。
    你可以自由地在房间之间来回走动。
    如果能进入每个房间返回 true，否则返回 false。
     */
    /*
    方法1.从0号位置还是深度优先搜索，为了判断当前位置是否搜索过，我们还要定义一个boolean全局数组，用于判断是否搜索过
    时间复杂度O(N+M)
    空间复杂度：O(n)，
     */
    private boolean[] vis;
    int num;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms,0);
        return num==n;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        //访问当前位置
        vis[i] = true;
        num++;
        //从当前节点开始深度优先搜索
        for(int it : rooms.get(i)){
            if(!vis[it]){
                dfs(rooms,it);
            }
        }
    }
    /*
    方法2.广度优先搜索,和深度优先搜索的思路差不多，
    时间复杂度O(N+M)
    空间复杂度：O(n)，
     */
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        vis[0] = true;
        queue.offer(0);
        while(!queue.isEmpty()){
            int x = queue.poll();
            num++;
            for(int it : rooms.get(x) ){

                if(!vis[it]){
                    vis[it] = true;
                    queue.offer(it);
                }

            }

        }
        return num==n;
    }


}
