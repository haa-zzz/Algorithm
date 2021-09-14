package com.haa.algorithm.简单;


import java.util.Scanner;

public class 数字反转 {
    /*
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    java中各数据类型的取值范围：

     1、int。
        最小值：Integer.MIN_VALUE= -2147483648 （-2的31次方）
        最大值：Integer.MAX_VALUE= 2147483647  （2的31次方-1）
     2、short。
        最小值：Short.MIN_VALUE=-32768 （-2的15此方）
        最大值：Short.MAX_VALUE=32767 （2的15次方-1）
     3、long。
        最小值：Long.MIN_VALUE=-9223372036854775808 （-2的63次方）
        最大值：Long.MAX_VALUE=9223372036854775807 （2的63次方-1）
     4、float 。
        最小值：Float.MIN_VALUE=1.4E-45 （2的-149次方）
        最大值：Float.MAX_VALUE=3.4028235E38 （2的128次方-1）
     5、double。
        最小值：Double.MIN_VALUE=4.9E-324 （2的-1074次方）
        最大值：Double.MAX_VALUE=1.7976931348623157E308 （2的1024次方-1）
    注意:
        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

     */

    //关键在于要考虑溢出问题
    public static int reverse(int x) {
        int s = 0;

        while(x != 0){
            if( (s*10)/10!=s){
                return 0;
            }
            s = s*10 + x%10;
            x/=10;
        }

        return s;
    }

}
