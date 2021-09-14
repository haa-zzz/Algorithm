package com.haa.深搜广搜.回溯;

import java.util.ArrayList;
import java.util.List;

public class 全排列_46 {
    /*
    给定一个 没有重复 数字的序列，返回其所有可能的全排列
     */
    /*
    方法:回溯
        1.分析递归过程：
             以数组[1,2,3]为例
                                       []
         选择：       [1]               [2]                [3]
         选择列表：  【2,3】            【1,3】            【1,2】
         选择：   [1,2]  [1,3]       [2,1] [2,3]        [3,1] [3,2]
         选择列表： 【3】    【2】      【3】  【1】        【2】 【1】
         选择    [1,2,3]  [1,3,2]   [2,1,3] [2,3,1]   [3,1,2] [3,2,1]

        2.找结束条件
           当选择列表中元素的个数等于数组的长度时，结束。
        3.找选择列表
            上一条路径中还没选的数
        4.判断是否需要剪枝
            从递归树中看到，路径没有重复的，也没有不符合条件的，所以不需要剪枝

        复杂度分析
        时间复杂度O( n * n!)
        空间复杂度O(n)
     */

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if(n==0){
            return null;
        }
        List<List<Integer>>  lists = new ArrayList<>();
        boolean[] isPush = new boolean[n];
        mute( lists, 0, n, nums,isPush,new ArrayList<Integer>());
        return lists;
    }
    private void mute(List<List<Integer>> lists, int i, int n, int[] nums, boolean[] isPush, ArrayList<Integer> list) {
        if(i == n ){      //已经选了n个数了
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0; j < n; j++){
            if(!isPush[j]){
                list.add(nums[j]);
                isPush[j] = true;
                mute(lists,i+1,n,nums,isPush,list);     //递归
                isPush[j] = false;              //回溯
                list.remove(list.size()-1 );
            }
        }
    }
}
