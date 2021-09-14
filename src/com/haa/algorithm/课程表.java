package com.haa.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 课程表 {
    /*
    你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
    给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     */
    /*
    本题可约化为： 课程安排图是否是 有向无环图(DAG)。即课程间规定了前置条件，但不能构成任何环路，否则课程前置条件将不成立。
    方法：广度优先搜索
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>>  adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp : prerequisites){
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre)){
                if(--indegrees[cur]==0)
                    queue.add(cur);
            }
        }
        return numCourses==0;

    }
}
