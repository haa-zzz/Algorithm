package com.haa.深搜广搜.回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合_77 {
    /*
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    你可以按 任何顺序 返回答案。
     */
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList();
            dfs(n, k, 1, ans, new ArrayList<Integer>());
            return ans;
        }

        private void dfs(int n, int k, int start, List<List<Integer>> ans, ArrayList<Integer> path) {
            if (path.size() == k) {
                ans.add(new ArrayList(path));
                return;
            }
            for (int i = start; i <= n; i++) {
                path.add(i);
                dfs(n, k, i + 1, ans, path);
                path.remove(path.size()-1);

            }
        }
    }
}
