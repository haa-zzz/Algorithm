package com.haa.algorithm.简单;

import java.util.Scanner;

public class 解码方法 {
    /*
    一条包含字母 A-Z 的消息通过以下方式进行了编码：

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    给定一个只包含数字的非空字符串，请计算解码方法的总数。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/decode-ways
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
        刚开始想到的是上楼梯的解法即递归f(n) = f(n-1)+f(n-2)但是由于有零存在增加了很多判断，并且本身的时间复杂度就搞直接超时了
        通过题解知道了可以用动态规划
        令dp[x]表示[0,x]的解码方式则dp[s.length()-1]就是所求结果
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(numDecodings(in.next()));

    }
    /*
    public static int numDecodings(String s) {
        int len = s.length();
        if(len==1){
            int x = Integer.parseInt(s);
            if(x!=0)
                return 1;
            else
                return 0;
        }
        if(len==2){
            int x = Integer.parseInt(s);
            if(x<10 || ( x%10==0 &&x!=10 &&x!=20) )
                return 0;
            if(x<=26 && x!=10 &&x!=20)
                return 2;
            else
                return 1;
        }
        int x = Integer.parseInt( s.substring(0,2) );
        if(x<10)
            return 0;
        else if(x>26 )
            return numDecodings(s.substring(1,len));
        else if(x==10 || x==20)
            return numDecodings(s.substring(2,len));
        else
            return numDecodings(s.substring(1,len))+numDecodings(s.substring(2,len));
    }
    */
    public static int numDecodings(String s) {
        int len = s.length();
       // char[] arr = s.toCharArray();
        if(s.charAt(0) == '0')
            return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++){
            if(s.charAt(i)!='0')
                dp[i] = dp[i-1];
            int two = ( (s.charAt(i-1)-'0')*10+(s.charAt(i)-'0'));
            if(two>=10 && two <=26 ){
                if(i==1)
                    dp[i]++;
                else
                    dp[i] += dp[i-2];
            }
        }
        return dp[len-1];
    }

}
