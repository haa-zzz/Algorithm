package 面试;

import 面试.常用数据结构.LRU.LRUJava;

public class Main {
//    public static void main(String[] args) {
//        LRUJava<Integer> lruJava = new LRUJava<Integer>(5);
//
//
//        int[][] arr = new int[][]{{1,2,3}, {1,2,3}};
//        int[] a1 = new int[]{0};
//        String a = "111";
//        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,0,1,0,0,1}));
//    }

    private static void fun(){

    }

    public static void main(String[] args){
        int arr[] = {-2,11,-4,13,-5,-5,99,-2};
        int result = FindGreatestSumOfSubArray_2(arr);
        System.out.println("最大子段和为："+result);
    }

    public static int FindGreatestSumOfSubArray_2(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        // 新建动态规划数组
        int[] dp = new int[array.length+1];
        // 由于下方遍历从1开始，先写入第一个数进dp[0]
        dp[0] = array[0];

        // 设置最大值：由于最开始的是array[0]，后面如果是负数肯定更小，如果是整数肯定变大
        int maxSum = array[0];

        for (int i = 1; i < dp.length - 1; i++) {

            dp[i] = Math.max(array[i], array[i]+dp[i-1]);

            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }

}
