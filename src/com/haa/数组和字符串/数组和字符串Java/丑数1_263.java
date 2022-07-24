package com.haa.数组和字符串.数组和字符串Java;

public class 丑数1_263 {
    /*
    丑数 就是只包含质因数 2、3 和 5 的正整数。
    给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。

    时间复杂度：O(logn)。时间复杂度取决于对 n 除以 2,3,5 的次数，由于每次至少将 n 除以 2，因此除法运算的次数不会超过 O(logn)。
    空间复杂度：O(1)
     */
    class Solution {
        public boolean isUgly(int n) {
            if(n <=0 ) {
                return false;
            }
            int[] nums = new int[]{2,3,5};
            for(int num: nums) {
                while(n % num == 0) {
                    n /= num;
                }
            }
            return n == 1;
        }
    }
}
