package com.haa.algorithm.中等;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最大数 {
    /*
    给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
    注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     */

    /*
    方法1.字典顺序排序
        对于nums中的两个值a,b;他们的排序关系是什么呢，最后的结果无非两种情况ab或ba,谁大就谁在前。而对于这种情况谁更大可以用字典顺序来检查，谁的字典顺序大谁就在前。
        另外：如果nums里面全是0,我们需要特判来处理。
        时间复杂度O( N*log(N) ): 主要用在排序
        空间复杂度O (N) ：开辟的数组arr
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];

        for(int i = 0; i < n; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b) );      //如果return a.compareTo(b) 是按 字典顺序升序

        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
        }
        String res = sb.toString();
        if(res.charAt(0)=='0'){
            res = "0";
        }
        return res;
    }
    /*
    方法2.直接在数组中排序

         我们可以比较输入数组的每个元素的最高位，最高位相同的时候比较次高位，以此类推，完成排序，然后把它们拼接起来。
         对于特殊的如（54，5,546）
              排序后应该是    5,54,546

     */
    public String largestNumber1(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            int sa = 10,sb = 10;
            while(sa <= a){
                sa *= 10;
            }
            while(sb <= b){
                sb*=10;
            }
            int pa = a * sb + b;        //ab
            int pb = b * sa + a;        //ba
            return pb-pa;
        } );
        if(arr[0]==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb.append(num);
        }

        return sb.toString();
    }

}
