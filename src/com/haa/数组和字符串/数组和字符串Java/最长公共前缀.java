package com.haa.数组和字符串.数组和字符串Java;

public class 最长公共前缀 {
    /*
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。
     */
    public static void main(String[] args){
        String[] strings = new String[]{"dac","dacecar","dacr"};
        System.out.println(longestCommonPrefix(strings));
    }
    /*
    方法一：纵向遍历，一次遍历所以的字符串的第index个字符，如何都相等，就添加
    时间复杂度O（M*N）
    空间辅复杂度O(1)
     */
    public static  String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        int index = 0;
        while(index < strs[0].length()){

            char c = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++){
                if(index==strs[i].length() || c!=strs[i].charAt(index)){
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
    /*
        方法2.横向遍历,内层遍历一次只遍历一个字符串，让该字符串和ans比较，并更新ans的值

        时间复杂度O(N*M)
        空间复杂度O(1)
     */
    public String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for(int i = 0; i < strs.length; i++){
            int j = 0;
            while(j < strs[i].length() && j < ans.length()){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            ans = ans.substring(0,j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }


}
