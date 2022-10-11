package 面试.常用数据结构;

import java.util.*;

public class CTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(fun1(in.next()));
    }
    private static int fun1(String str) {
        int len = str.length();
        char[][] dp = new char[len][len+1];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j <= len; j++){
                dp[i][j] = '0';
            }
        }
        int sum = 0;
        for(int i = 0; i < len; i++) {
            dp[i][1] = str.charAt(i);
            sum++;
        }
        for(int i = 0; i < len; i++) {
            for(int j = 3; i+j <= len; j+=2) {
                if(dp[i][j-2] != '0' && dp[i][j-2] == str.charAt(i+j-2)) {
                    dp[i][j] = str.charAt(i+j-1);
                    sum++;
                } else if(dp[i][j-2] != '0' && dp[i][j-2] == str.charAt(i+j-1)) {
                    dp[i][j] = str.charAt(i+j-2);
                    sum++;
                } else {
                    if(i < j && j <= len) {
                        dp[i][j] = isfun(str.substring(i,j));
                    }
                }
            }
        }
        return sum;
    }
    private static char isfun(String a) {
        char[] arr = a.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : arr) {
            if(list.contains(c)) {
                list.remove(c);
            } else {
                list.add(c);
            }
        }
        if(list.size() == 1) {
            return list.get(0);
        }
        return '0';
    }
}
