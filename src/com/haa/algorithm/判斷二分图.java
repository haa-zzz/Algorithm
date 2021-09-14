package com.haa.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class 判斷二分图 {

    /*
    给定一个无向图graph，当这个图为二分图时返回true。

    如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。

    graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/is-graph-bipartite
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
/*
    任取一个节点去染成红色，吧与他相邻的节点染成绿色，再与绿色相邻的染成红色，遍历每个节点，直到所有的点都染色
    如果染色成功，是二分图，负责不是
 */
//广搜，深搜，并查集
    //深搜
    /*
    private static final int NUCOLOR = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private static int[] color;         //color数组，color[i] = c,i是任一个节点，c是他的颜色
    private static boolean vaild;       //记录能否成功染色，一旦为False则说明不能

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        vaild = true;
        color = new int[n];
        for(int i = 0; i < n; i++){
            if(color[i]==NUCOLOR)
                dfs(i,RED,graph);
        }
        return vaild;

    }
    public static void dfs(int node,int c,int[][]graph){
        color[node] = c;
        int nc = c==RED ? GREEN : RED;
        for(int neighbor:graph[node]){
            if(color[neighbor]==NUCOLOR) {
                dfs(neighbor, nc, graph);
                if(vaild==false)
                    return;
            }
            else if(color[neighbor]!=nc){
                vaild = false;
                return;
            }
        }
    }

     */
    //广搜：（入队出队）
    private static final int NUCOLOR = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private static int[] color;         //color数组，color[i] = c,i是任一个节点，c是他的颜色
    private static boolean vaild;       //记录能否成功染色，一旦为False则说明不能
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        vaild = true;
        for(int i = 0; i < n; i++){
            if(color[i]==NUCOLOR){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    int cn = color[node]==RED ? GREEN:RED;
                    for(int neighbor:graph[node]){
                        if(color[neighbor]==NUCOLOR){
                            queue.offer(neighbor);
                            color[neighbor] = cn;
                        }
                        else if(color[neighbor]!=cn){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }



}
