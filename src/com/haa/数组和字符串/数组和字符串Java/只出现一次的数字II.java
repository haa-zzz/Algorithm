package com.haa.数组和字符串.数组和字符串Java;

public class 只出现一次的数字II {
    /*
    在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     */
    /*
    遍历统计:
    建立一个长度为 32 的数组，记录所有数字的各二进制位的 1 的出现次数。
    将 数组 各元素对 3 求余，则结果为 “只出现一次的数字” 的各二进制位。
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int[] arr = new int[32];
            for(int num : nums) {
                for(int j = 0; j < 32; j++) {
                    arr[j] += num & 1;  //统计num各个位1出现的次数
                    num >>>= 1;     //无符号右移
                }
            }
            int res = 0, m = 3;
            for(int i = 0; i < 32; i++) {
                res <<= 1;
                res |= arr[31 - i] % m;
            }
            return res;
        }
    }
}
