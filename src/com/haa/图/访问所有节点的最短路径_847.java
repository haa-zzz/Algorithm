package com.haa.图;

import java.util.*;

public class 访问所有节点的最短路径_847 {
    /*
    存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
    给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
    返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
    示例 1：

        输入：graph = [[1,2,3],[0],[0],[0]]
        输出：4
        解释：一种可能的路径为 [1,0,2,0,3]
     */
    /*
    bfs
    本题的难点在与对状态的维护，在常规的广度优先搜索中，我们会在队列中存储节点的编号。
    对于本题而言，最短路径的前提是「访问了所有节点」，因此除了记录节点的编号以外，我们还需要记录每一个节点的经过情况。
    所以我们的visited[i][j]中，j是一个二进制数，哪一位为1就说明这一位访问过， 最后如果是全1，就表明访问了所有节点。
    visited[i][j]就表示从i出发，j的二进制中是1的都是访问过的节点的这样一种状态。
     */
    class Solution {
        public int shortestPathLength(int[][] graph) {
            int n = graph.length;
            boolean[][] visited = new boolean[n][1 << n];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {       //可以从任何一个节点出发
                //queue中除了存节点外，还要存从这个节点出发的状态
                queue.offer(new int[]{i, 1 << i});    //i这个节点访问过，把对应的二进制数置为1
                visited[i][1 << i] = true;
            }
            // 记录BFS的层数，当访问满了所有节点，返回这个层数即可
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                // 一层一层遍历
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] element = queue.poll();
                    int curr = element[0];  //从curr出发
                    int currState = element[1]; //对应的状态
                    for (int next : graph[curr]) {       //从curr能到达的节点
                        int nextState = currState | (1 << next);   //下一个节点的状态，把下一个节点加入到路径状态中
                        if (nextState == ((1 << n) - 1)) {  //全是1，就表示所有的节点都访问到了，直接返回就可以了
                            return level;
                        }
                        if (!visited[next][nextState]) {    // 下一个节点下一个状态未访问过，下探
                            queue.offer(new int[]{next, nextState});
                            visited[next][nextState] = true;
                        }
                    }
                }
            }
            return 0;
        }
    }
}
