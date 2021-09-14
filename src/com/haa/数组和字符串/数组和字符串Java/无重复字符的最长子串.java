package com.haa.数组和字符串.数组和字符串Java;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    /*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    /*
    分析：滑动窗口问题
        其实就是动态规划的空间优化

        在开始时想的是 动态规划+HashMap实现，dp[i]表示以i结尾的字串所构成的无重复最长字串，类似于最大子序列那道题。
        用hashMap存储(字符，下标),如果集合中没有 dp[i] = dp[i-1]+1  如果集合中存在，想办法找到存在的下标j, dp[i] = i - j+1
        但是在(想办法找到存在的下标j),这个感觉不好处理(忘记了map集合如果key存在时是更新value,还以为是直接返回false)。
        后来又用动态规划试了一下,发现要想在O(n)时间复杂度解题，还是要用left保存左值，此时dp就有点鸡肋，可有可无。
     */
    /*
    动态规划版
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n < 1)
            return n;
        int maxSubString = 0;
        int left = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int[] dp = new int[n];
        //初始化
        dp[0] = 1;
        maxSubString = 1;
        map.put(s.charAt(0),0);

        for(int i = 1;  i < n; i++){

            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);        //关键点1:left需要比较取大者
                dp[i] = i-left+1;
            }else{
                dp[i] = dp[i-1]+1;      //(dp[i-1]+1) == i-left+1,dp可有可无
            }
            //将指定的值与此映射中的指定键相关联。 如果地图先前包含了该键的映射，则替换旧值。
            map.put(s.charAt(i),i);                 //关键点2：如果集合中有重复的，put来更新索引位置
            maxSubString = Math.max(maxSubString,dp[i]);
        }
        return maxSubString;
    }
    /*
    滑动窗口版本：其实就是上面的空间优化
    时间复杂度O(N)
    空间复杂度O()
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        if(n < 1)
            return n;
        int maxSubString = 0;
        int left = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;  i < n; i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            //将指定的值与此映射中的指定键相关联。 如果地图先前包含了该键的映射，则替换旧值。
            map.put(s.charAt(i),i);
            maxSubString = Math.max(maxSubString,i-left+1);
        }
        return maxSubString;
    }

}
