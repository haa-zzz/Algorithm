package 面试;

import java.util.*;

public class Main {

    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int[] arr = new int[n];
       for(int i = 0; i < n; i++) {
           arr[i] = in.nextInt();
       }
        System.out.println(fun1(arr));
    }


    private static int fun1(int[] arr) {
        int n = arr.length;
        if(n == 0) {
            return 0;
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]) {
                dp1[i] = dp1[i-1] + 1;
            }
        }
        for(int i = n-2; i >= 0; i--) {
            if(arr[i] > arr[i+1]) {
                dp2[i] = dp2[i+1] + 1;
            }
        }
        for(int i = 0; i < n; i++) {
            int number = dp1[i] + dp2[i] + 1;
            if(ans < number) {
                ans = number;
            }
        }
        return ans;
    }
}
