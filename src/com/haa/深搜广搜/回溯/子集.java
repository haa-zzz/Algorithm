package com.haa.深搜广搜.回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    /*
    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */
    /*
    方法:回溯
        回溯算法是在一棵树上的 深度优先遍历（因为要找所有的解，所以需要遍历）；
        1.做递归树：对于向123这样的求子集，我们可以做出它的递归树
                                123
                                 |
                        []      [1]        [2]    [3]
                              |     |       |
                            [1,2] [1,3]   [2,3]
                            |
                         [1,2,3]
            对于上面的递归树，如果是[1]这条路径，它的选择列表只有“2,3”,如果是[2]，它的选择列表只有“3”,所以我们要用一个参数
             i来表示当前选择列表的起始位置，也就是标识每一层的状态(这个参数也被称为状态变量)
        2.找结束条件
           对于这道题来说，所有路径都应该加入结果集,
        3.找选择列表
            子集问题的选择列表，是上一条选择路径之后的数
        4.判断是否需要剪枝
            从递归树中看到，路径没有重复的，也没有不符合条件的，所以不需要剪枝

        复杂度分析
        时间复杂度O(2^n)
        空间复杂度O(n)
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();

            backtrack(0, nums, res, new ArrayList<Integer>());

            return res;

        }
        private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
            res.add(new ArrayList<>(tmp));
            for (int j = i; j < nums.length; j++) {
                tmp.add(nums[j]);       //做出选择
                backtrack(j + 1, nums, res, tmp);       //递归进下一层，注意j+1，标识下一个选择列表的开始位置
                tmp.remove(tmp.size() - 1);     //撤销选择
            }
        }
    }
}
