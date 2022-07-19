package com.haa.深搜广搜;

import java.util.*;

public class 单词拆分_139 {

    /*
   给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。

   说明：

   拆分时可以重复使用字典中的单词。
   你可以假设字典中没有重复的单词。
    */
    /*
    方法1.dfs
        思路: 对给定的字符串从左到右查找，与每一个单词列表的单词相匹配，如果可以匹配到最后一个单词，说明可以划分，返回true
        但是这时递归栈很深，会出现超出时间限制的情况，此时需要剪枝。
        剪枝策略:
            在递归时，如果以当前位置被访问过，那么当前的递归就是多余的(因为前面已经判断过从当前位置
                    开始进行单词划分是不可行的，行的话直接返回true了，不会进行到这一步)
            所以可以用一个boolean数组标记是否从当前位置查找过，如果查找过就不用再去递归查找
        时间复杂度O(N ^ 2)
        空间复杂度O(N)   : 递归栈的最大深度（n为s的长度）
     */
    // DFS
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        return dfs(s, 0, wordDict, visited);
    }
    private boolean dfs(String s, int start, List<String> wordDict, boolean[] visited) {
        for (String word : wordDict) {
            int nextStart = start + word.length();
            if (nextStart > s.length() || visited[nextStart]) {
                continue;
            }

            if (s.indexOf(word, start) == start) {
                if (nextStart == s.length() || dfs(s, nextStart, wordDict, visited)) {
                    return true;
                }
                visited[nextStart] = true;
            }
        }
        return false;
    }
    /*
   方法2. bfs
       和刚才dfs的思路一样，使用bfs的方式来实现
    */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int n = s.length();
        boolean[] visited = new boolean[n + 1];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int start = queue.poll();
                for (String word : wordDict) {
                    int nextStart = start + word.length();
                    if (nextStart > n || visited[nextStart]) {
                        continue;
                    }

                    if (s.indexOf(word, start) == start) {
                        if (nextStart == n) {
                            return true;
                        }

                        queue.add(nextStart);
                        visited[nextStart] = true;
                    }
                }
            }
        }

        return false;
    }

}

class Solution {
    public String validIPAddress(String ip) {
        if (ip.contains(".") && check4(ip)) return "IPv4";
        if (ip.contains(":") && check6(ip)) return "IPv6";
        return "Neither";
    }
    boolean check4(String ip) {
        int n = ip.length(), cnt = 0;
        char[] cs = ip.toCharArray();
        for (int i = 0; i < n && cnt <= 3; ) {
            // 找到连续数字段，以 x 存储
            int j = i, x = 0;
            while (j < n && cs[j] >= '0' && cs[j] <= '9' && x <= 255) x = x * 10 + (cs[j++] - '0');
            // 非 item 字符之间没有 item
            if (i == j) return false;
            // 含前导零 或 数值大于 255
            if ((j - i > 1 && cs[i] == '0') || (x > 255)) return false;
            i = j + 1;
            if (j == n) continue;
            // 存在除 . 以外的其他非数字字符
            if (cs[j] != '.') return false;
            cnt++;
        }
        // 恰好存在 3 个不位于两端的 .
        return cnt == 3 && cs[n - 1] != '.';
    }
    boolean check6(String ip) {
        int n = ip.length(), cnt = 0;
        char[] cs = ip.toCharArray();
        for (int i = 0; i < n && cnt <= 7; ) {
            int j = i;
            while (j < n && ((cs[j] >= 'a' && cs[j] <= 'f') || (cs[j] >= 'A' && cs[j] <= 'F') || (cs[j] >= '0' && cs[j] <= '9'))) j++;
            // 非 item 字符之间没有 item 或 长度超过 4
            if (i == j || j - i > 4) return false;
            i = j + 1;
            if (j == n) continue;
            // 存在除 : 以外的其他非数字字符
            if (cs[j] != ':') return false;
            cnt++;
        }
        // 恰好存在 7 个不位于两端的 :
        return cnt == 7 && cs[0] != ':' && cs[n - 1] != ':';
    }
}
