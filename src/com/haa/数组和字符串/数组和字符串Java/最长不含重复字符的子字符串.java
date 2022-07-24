package com.haa.数组和字符串.数组和字符串Java;

import java.util.HashMap;

public class 最长不含重复字符的子字符串 {
    /*
    请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    力抠: 3
     */
    /*
    滑动窗口+hash表
    用hash表记录每一个节点，当迭代到一个新的节点时，
    先看hash表中是否有这个节点，如果有的话就要尝试取更新窗口区间
     */
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        int n = s.length();
        if(n  <= 0) return 0;
        int left = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0;  i < n; i++) {
            if(map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;

    }
}
