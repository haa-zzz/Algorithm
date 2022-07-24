package com.haa.数组和字符串.数组和字符串Java;

import java.util.Arrays;
import java.util.Comparator;

public class 把数组排成最小的数 {
    /*
    输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
     */
    /*
    排序-拼接
    关键在于自定义排序: 先转化为字符串可以让排序过程更简单
    第一种排序方式
    分3种情况
        1. a,b两个完全相等 a == b
        2. 两个有相同的前缀，且后缀都不为空。 如(4324  4327)  比较不同的部分,返回小的
        3. 两个有相同的前缀，且后缀一个为空。 如(5456, 54) (5400 54)   用长的后缀部分再和短的比较

     第二种方式
       算是对一的优化
       如果 a + b < b + a  则 a < b
       如果 a + b > b + a  则 a > b
     */
    class Solution {
        public String minNumber(int[] nums) {
            if(nums == null) return null;
            String[] arr = new String[nums.length];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = String.valueOf(nums[i]);
            }
            quickSort(arr,0, arr.length);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            return sb.toString();
        }
        private void quickSort(String[] arr, int left, int right) {
            while(left < right -1) {
                int pivotKey = quickChange(arr, left, right-1);
                quickSort(arr, left, pivotKey);
                left = pivotKey+1;
            }
        }
        private int quickChange(String[] arr, int low, int high) {
            String pivotKey = arr[low];
            while(low < high) {
                while(low < high && compare1(pivotKey, arr[high])) high--;
                arr[low] = arr[high];
                while(low < high && compare1(arr[low], pivotKey)) low++;
                arr[high] = arr[low];
            }
            arr[low] = pivotKey;
            return low;
        }
        //方式1
        private boolean compare(String a, String b) {
            if(a.equals(b)){
                return true;
            }
            int i = 0;
            int j = 0;
            while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            if(i < a.length() && j < b.length()) {
                return (a.charAt(i) - b.charAt(j)) < 0;
            } else if(i < a.length()) {
                return compare(a.substring(i), b);
            } else {
                return compare(a, b.substring(j));
            }
        }
        //方式2
        private boolean compare1(String a, String b) {
           String ab = a+b;
           String ba = b+a;
           if(ab.compareTo(ba) <= 0) return true;
           return false;
        }
    }
}
