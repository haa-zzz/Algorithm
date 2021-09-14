package com.haa.algorithm.简单;

import java.util.Arrays;
import java.util.Scanner;

public class 任务调度器 {
    /*
    给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在
    1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
    然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
    你需要计算完成所有任务所需要的最短时间。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/task-scheduler
     */
    /*
    题解:刚开始时理解错了用Map集合去做但是发现重复排序很麻烦
        这道题应该是每次找同一任务次数最多的，从这个开始执行，然后执行第二多的，直到执行到n+1，也就是执行到冷却时间结束，此时一轮结束
        步骤1：吧Char[]中数据信息储存在int[]中，由于A-Z可以定义一个26大小的int[],0-25刚好对应A-Z
        步骤2：排序
        步骤3：
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        int time = leastInterval(s.toCharArray(),n);
        System.out.println(time);
    }
    public static int leastInterval(char[] tasks, int n){
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;


    }
    //方法2：设计
    /*
     public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        //步骤1
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        //步骤2
        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        //步骤3
        while (i >= 0 && counts[i] == maxCount) {
            retCount++;
            i--;
        }
        //步骤4
        return Math.max(retCount, tasks.length);
    }

    作者：pphdsny
    链接：https://leetcode-cn.com/problems/task-scheduler/solution/621-ren-wu-diao-du-qi-java-jie-ti-zhu-shi-ying-gai/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

}
