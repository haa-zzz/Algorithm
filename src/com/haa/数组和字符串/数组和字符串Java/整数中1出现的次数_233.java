package com.haa.数组和字符串.数组和字符串Java;

public class 整数中1出现的次数_233 {
    /*
    输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
    例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     */
    /*
    分析 一位一位判断, 比如先判断个位1出现的次数，再判断十位，再判断百位......
    做法：把数字分为三部分 高位high - 当前位in - 低位low.
    比如对于 40918：

    计算十位1： (当前位1 高位409 低位8) 范围是 00010 - 40918 即 4098  + 1 = 4099
    计算百位1： (当前位9 高位40 低位 18) 范围是 00100 - 40199 即 4099 + 1 = 4100
    计算千位1:  (当前位0 高位4 低位918) 范围就是 01000-31999 即(3999 + 1)  = 4000
    ......

    其实有个规律： 当前位是0： 个数为 high * weight(当前位位权)
                 当前位是1： 个数为 high * weight + low + 1
                 当前位>1: h个数为 (high+1)* weight

     时间复杂度 O(logn) ： 循环内的计算操作使用 O(1) 时间；循环次数为数字 n 的位数，即 log10-n，因此循环使用 O(logn) 时间。
    空间复杂度 O(1) ： 几个变量使用常数大小的额外空间
     */
    class Solution {
        public int countDigitOne(int n) {
            int weight = 1, res = 0;    //初始时：in为
            int high = n / 10;
            int cur = n % 10;
            int low = 0;
            while(high != 0 || cur != 0) {
                if(cur == 0) res += high * weight;
                else if(cur == 1) res += high * weight + low + 1;
                else res += (high + 1) * weight;
                low += cur * weight;
                cur = high % 10;
                high /= 10;
                weight *= 10;
            }
            return res;
        }
    }
}
