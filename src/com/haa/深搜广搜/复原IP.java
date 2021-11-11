package com.haa.深搜广搜;


import java.util.ArrayList;
import java.util.List;

public class 复原IP {
    /*
    给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
    有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
    例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     */

    /*
    方法：深搜+回溯
    深搜的方法，每次先找第一个整数，从第一个整数开始向下深搜，如果符合条件，添加这个IP,注意深搜的最后需要回溯。
     */
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s){
        dfs(new StringBuilder(s),0,0);
        return res;
    }
    //用于判断这个字符串是不是符合条件的一个整数
    boolean isValid(String s){
        //必须要满足 s不为空 && 个数小于4 && 数值小于255 && 在只有一位的时候这一位不为0
        return !s.isEmpty() && s.length()<4 && (s.length() <= 1 || s.charAt(0) != '0' && Integer.parseInt(s) < 255);
    }
    private void dfs(StringBuilder sb, int startIndex, int nodeCount) {
        //现在整数的个数已经有三个了，如果说最后一个也满足的话，那么就说明是一个正确格式的IP,直接把它添加到集合中去，否则直接return回溯寻找下一个
        if(nodeCount == 3){
            if(isValid(sb.substring(startIndex)))
                res.add(sb.toString());
            return;
        }
        //整数 要么是 1位，要莫是2位，要莫是3位，所以只需要遍历找到到第一个整数，在递归的去找后面的整数就好了。
        for(int i = startIndex; i < sb.length() && i < startIndex+3; i++ ){
            String subIp = sb.substring(startIndex,i+1);    //寻找从 startIndex 到 i+1 出发是否可以组成一组合适的IP地址
            if(isValid(subIp)){     //如果[startIndex , i+1)是满足要求的一个整数，那么就在它后面添加'.',并递归找下一个满足要求的整数
                sb.insert(i+1,".");
                dfs(sb,i+2,nodeCount+1);    //递归找下一个整数
                sb.deleteCharAt(i+1);  //回溯过程，删除我们添加的“.”
            }
        }
    }

}
