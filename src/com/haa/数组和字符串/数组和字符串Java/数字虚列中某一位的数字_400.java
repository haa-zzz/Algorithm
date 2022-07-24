package com.haa.数组和字符串.数组和字符串Java;

public class 数字虚列中某一位的数字_400 {
    /*
    数字以0123456789101112131415…的格式序列化到一个字符序列中。
    在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
    请写一个函数，求任意第n位对应的数字。
     */
    /*
    递推：       weight   数字数  数位总数
        1-9      1        9        9
        10-99    2        90       180
        100-999  3        900      2700
                              start*9*weight
      1. 确定 n 所在 数字 的 位数 ，记为 weight
      2. 确定 n 所在的 数字 ，记为 num ；
      3. 确定 n 是 num 中的哪一数位，并返回结果。

      时间复杂度 O(logn) ： 第一步最多循环 O(logn) 次；第三步中将 num 转化为字符串使用 O(logn) 时间；因此总体为 O(logn) 。
      空间复杂度 O(logn) ： 将数字num 转化为字符串 str(num) ，占用O(logn) 的额外空间。

     */
    class Solution {

        public int findNthDigit(int n) {
            if(n==0) return 0;     //排除n=0后，后面n从1开始。
            int weight = 1;
            int start = 1;
            long count = 9;        //count的值有可能会超出int的范围，所以变量类型取为long
            while(n > count){     //不能带=号，此时n从1开始，n=count时，属于上一个循环的最后一个数字
                n = (int) (n - count); //这里(int)不能省略
                weight++;
                start = start * 10;
                count = (long) start * 9 * weight;
                //这里的long不能省略，否则，会先按照int类型进行计算，然后赋值给long型的count，超过int大小限制时，会出现负数
            }

            int num = start + (n-1) / weight;
            int index = (n-1) % weight;  //index最大取weight-1,即此时num坐标从左到右为0,1,...,weight-1,共weight位
            while(index < (weight-1)){
                //最后的结果是num中的第index个数字，index从从0开始递增，考虑到踢出右侧末尾的数字比较简单，我们从右侧开始依次踢出数字
                num = num/10;
                weight--;
            }
            return num % 10; //此时num的右侧末尾数字即为结果
        }
    }
}
