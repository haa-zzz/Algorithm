package com.haa.深搜广搜.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和_39 {
    /*
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的数字可以无限制重复被选取。

    说明：

    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。
     */
    /*
    分析：回溯问题，
        1.分析递归过程
            对于candidates = [2, 3, 6, 7]，target = 7。
            如果选择了2，在找到组合总和为 7 - 2 = 5 的所有组合，再在之前加上 2 ，就是 7 的所有组合；
            同理考虑 3，如果找到了组合总和为 7 - 3 = 4 的所有组合，再在之前加上 3 ，就是 7 的所有组合，依次这样找下去。
        2.找结束条件
            当target <= 0 时结束
                当target == 0 时把这条路径加入集合
        3.找选择列表
            用一个参数i来表示当前选择列表的起始位置，如果上一层路径添加了candidates[i]，那么下一层应该从i开始，
            这样做保证了一个路径中可以有重复元素，也保证了不存在重复的路径。


        复杂度分析：
            时间复杂度O(S)       其中 S 为所有可行解的长度之和
            空间复杂度O(target)  空间栈的深度最坏情况需要递归O(target)层

     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<Integer>(), list);
        return list;
    }
    private void backtrack(int[] candidates, int target, int i, List<Integer> path, List<List<Integer>> lists){
        if(target < 0){
            return;
        }
        if(target == 0){
            lists.add( new ArrayList(path) );
        }
        for(int j = i; j < candidates.length; j++){
            path.add(candidates[j]);
            backtrack(candidates,target - candidates[j], j , path , lists );
            path.remove(path.size()-1);
        }
    }
    /*
    4.考虑减枝
        如果当前target减去一个数小于等于0,那么减去一个大于这个数的数一定小于零，这种情况可以考虑减枝
        可以先对数组进行排序
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack1(candidates, target, 0, new ArrayList<Integer>(), list);
        return list;
    }
    private void backtrack1(int[] candidates, int target, int i, List<Integer> path, List<List<Integer>> lists){

        if(target == 0){
            lists.add( new ArrayList(path) );
        }
        for(int j = i; j < candidates.length; j++){

            if (target - candidates[i] < 0) {       //剪纸
                break;
            }
            path.add(candidates[j]);
            backtrack1(candidates,target - candidates[j], j , path , lists );
            path.remove(path.size()-1);
        }
    }
}
