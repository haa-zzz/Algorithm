package 面试.常用数据结构;

import java.awt.*;
import java.util.ArrayList;

public class 马踏棋盘问题 {
    /*
    马走棋盘算法：给定一个n*n的棋盘，并指定
    一个初始坐标（x，y），判断马从这个点开始
    能否每个点仅走一遍，通过每一个点
    （注：马按日字型走）
     */
    /*
    我们可以使用递归的思想来解决马踏棋盘问题，其操作步骤如下：

    （1）从起始点开始向下一个可走的位置走一步。
    （2）接着以该位置为起始，再向下一个可走的位置走一步。
    （3）这样不断递归调用，直到走完64格单元格，就找到一个行走方案。
    这里需要注意的是，如果在行走过程中，某个位置向8个方向都没有可走的点，则需要退回上一步，
    从上一个位置的另外一个可走位置继续递归调用，直至找到一个行走方案。
     */

    static class HorseChessboard {
        private boolean[][] visited;
        public boolean dfs(int n, int x, int y, int step){
            visited[x][y] = true; //标记该 位置已访问
            step += 1;
            if(step == n * n) {
                return true;
            }
            ArrayList<Point> ps = next(new Point(x, y), n);   //获取当前位置可以走的下一个位置集合
            for(Point point : ps) {
                if (!visited[point.x][point.y]){    //判断改点是否已经访问过
                    if(dfs(n, point.x, point.y,step + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
        public  ArrayList<Point> next(Point curPoint, int n){
            ArrayList<Point> ps = new ArrayList<>();
            Point p1 = new Point();
            if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) //5
                ps.add(new Point(p1));
            if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) //6
                ps.add(new Point(p1));
            if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y +1 ) < n) //7
                ps.add(new Point(p1));
            if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < n) // 0
                ps.add(new Point(p1));
            if ((p1.x = curPoint.x + 1) < n && (p1.y = curPoint.y + 2) < n) //1
                ps.add(new Point(p1));
            if ((p1.x = curPoint.x + 2) < n && (p1.y = curPoint.y + 1) < n) //2
                ps.add(new Point(p1));
            if ((p1.x = curPoint.x + 2) < n && (p1.y = curPoint.y -1 ) >= 0) //3
                ps.add(new Point(p1));
            if ((p1.x = curPoint.x+1) < n && (p1.y = curPoint.y-2) >= 0) //4
                ps.add(new Point(p1));
            return ps;
        }
    }
}
