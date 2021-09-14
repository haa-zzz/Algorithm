package com.haa.algorithm.简单;

public class 有序数组的平方 {
    /*
    给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

    示例 1：

    输入：[-4,-1,0,3,10]
    输出：[0,1,9,16,100]

     */
    /*
    方法：双指针
     */
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

}
