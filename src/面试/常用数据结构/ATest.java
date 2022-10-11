package 面试.常用数据结构;

import java.util.*;

public class ATest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[][] nums = new long[t][4];
        for(int i = 0; i < t; i++) {
            for(int j = 0; j < 4; j++) {
                nums[i][j] = in.nextLong();
            }
        }
        for(int i = 0; i < t; i++) {
            fun(nums[i][0], nums[i][1],nums[i][2],nums[i][3]);
        }
    }
    private static void fun(long n, long x, long y, long k) {

        long flog1 = k/x;
        long flog2 = (k-n+1)/y;
        if(flog1 < flog2) {
            System.out.println("Win");
            return;
        } else if(flog1 > flog2) {
            System.out.println("Lose");
            return;
        } else {
            System.out.println("Tie");
            return;
        }
    }
}