package com.haa.数组和字符串.数组和字符串Java;

public class 数组中出现次数超过一半的数字 {
    /*
        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */

    /*
    方法1：排序取中值
     */
    /*
    方法2： 摩尔投票法
    因为众数个数 > 其他数个数
    可以采用投票的思想，让众数和其他数向抵消，最后还剩下的一定是众数
     */
    public int majorityElement(int[] nums) {
        int number = 0;  //代表众数
        int score = 0;  //统计得分
        for(int num: nums) {
            if(score == 0) {        //当得分为0，说明前面都抵消了。重新从当前位置开始
                number = num;
            }
            if(number == num) {
                score++;
            } else {
                score--;
            }
        }
        return number;
    }
}
