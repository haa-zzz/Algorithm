package com.haa.数组和字符串.数组和字符串Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 字符串的排列 {
    /*
    输入一个字符串，打印出该字符串中字符的所有排列。
    你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
    力抠：剑指 Offer 38. 字符串的排列
     */

     /*
        方法1： 回溯（Set 去重）
        使用 HashSet 实现去重十分简单，就是不用考虑去重问题。
        直接决策目标字符串哪一位取哪个字符即可，同时使用布尔数组记录哪些字符已使用。

        时间复杂度：O(n * n!)
        空间复杂度：O(n)
      */
    class Solution {
        public String[] permutation(String s) {
            HashSet<String> ans = new HashSet();
            boolean[] visit = new boolean[s.length()];
            dfs(s.toCharArray(), 0, new StringBuilder(), ans, visit);
            String[] array = new String[ans.size()];
            int idx = 0;
            for (String str : ans)
                array[idx++] = str;
            return array;
        }
        private void dfs(char[] chars, int i, StringBuilder path, HashSet<String> ans, boolean[] visit) {
            if(i == chars.length) {
                ans.add(path.toString());
                return;
            }
            for(int j = 0; j < chars.length; j++) {
                if(!visit[j]) {
                    visit[j] = true;
                    path.append(chars[j]);
                    dfs(chars, i+1, path, ans, visit);
                    visit[j] = false;
                    path.deleteCharAt(path.length()-1);
                }
            }

        }
    }
    /*
    方法2：回溯-排序去重
     */
    class Solution1 {
        public String[] permutation(String s) {
            boolean[] visit = new boolean[s.length()];
            List<String> ans = new ArrayList<>();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            dfs(chars, 0, new StringBuilder(), ans, visit);

            String[] array = new String[ans.size()];
            int idx = 0;
            for (String str : ans)
                array[idx++] = str;
            return array;
        }
        private void dfs(char[] chars, int i, StringBuilder path, List<String> ans, boolean[] visit) {
            if(i == chars.length) {
                ans.add(path.toString());
                return;
            }
            for(int j = 0; j < chars.length; j++) {
                if(j > 0 && !visit[j - 1] && chars[j] == chars[j - 1]) continue;    //去重，跳过
                if(!visit[j]) {
                    visit[j] = true;
                    path.append(chars[j]);
                    dfs(chars, i+1, path, ans, visit);
                    visit[j] = false;
                    path.deleteCharAt(path.length()-1);
                }
            }

        }
    }




}
