package com.haa.algorithm;

public class 等差数列划分 {
    public static void main(String[] args){
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
    /*
    public static int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n<3)
            return 0;
        int[] arr = new int[n-1];
        for(int i = 1; i < n; i++){
            arr[i-1] = A[i]-A[i-1];
        }
        int d = arr[0];
        int nums = 0,count = 0;
        for(int i =1; i < n-1; i++){
            if(arr[i]==d)
                count++;

            if(arr[i]!=d || i==n-2 ){
                if(count>=1){

                    nums+=fun(count+2);
                }
                count = 0;
                d = arr[i];
            }

        }
        return nums;
    }
    public static int fun(int n){

        int num = 0;
        for(int i = 2; i <= n-1; i++){
            num+=n-i;
        }
        return num;

    }

     */
    public static int numberOfArithmeticSlices(int[] A) {
        int dp = 0;
        int sum = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp = dp+1;
                sum+=dp;
            }
            else
                dp = 0;
        }
        return sum;
    }


}
