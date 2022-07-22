package 面试.常用数据结构;

import java.util.HashSet;

public class 智能创作1面 {

    /*
    数组只有0，1，反转任意区间，使得，反转过后1的个数最多（变相的最大子序和）
     */

    /**
     * 解题思路：
     * 在原数组的arr基础上构造brr，使得：
     * 若 arr[i] = 0， 则brr[i] = 1
     * 若arr[i] = 1, 则brr[i] = -1
     * 然后求最大子序和就可以了
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1,1,0,0,1,0,1};
        minSubSum(arr);
        System.out.println(arr);
    }
    private static void minSubSum(int[] arr) {
        int n = arr.length;
        if(n < 1) {
            return;
        }
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                b[i] = 1;
            } else {
                b[i] = -1;
            }
        }
        int left = 0;
        int right = 0;
        int ans = b[0];
        int pre = b[0];
        for(int i = 1; i < n; i++){
            if(b[i] > b[i] + pre) {
                left = i;
            }
            pre = Math.max(b[i], pre + b[i]);
            if(pre > ans) {
                right = i;
                ans = pre;
            }
        }
        System.out.println(left +"  " + right);
    }


}
