package 面试.常用数据结构.排序算法;

import java.util.Scanner;

public class DTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String str = in.next();
        int[] lenStr = new int[m];
        for(int i = 0; i < m; i++) {
            lenStr[i] = in.nextInt();
        }
        String[] a = new String[m];
        for(int i = 0; i < m; i++) {
            a[i] = in.next();
        }
        System.out.println(fun2(str, lenStr, a));
    }
    static int number = 0;
    public static int fun2(String str, int[] lenStr, String[] a) {
        boolean[] visit = new boolean[lenStr.length];
         dfs(0, lenStr, str, 0, a, visit);
         return number;
    }
    private static void dfs(int count,int[] lenStr, String str, int index, String[] a, boolean[] visit) {
        if(count == lenStr.length  && index == str.length()) {
           number++;
        }
        for(int i = 0; i < lenStr.length; i++) {
            if(!visit[i]) {
                int end = lenStr[i] + index;
                if(end <= str.length()) {
                    String sub = str.substring(index, end);
                    if(sub.equals(a[i])) {
                        visit[i] = true;
                        dfs(count+1, lenStr, str, end, a, visit);
                        visit[i] = false;
                    }
                }
            }
        }
    }
}
