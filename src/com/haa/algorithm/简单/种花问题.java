package com.haa.algorithm.简单;

public class 种花问题 {
    /*
    假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
    给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
    能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/can-place-flowers
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    方法一：
        可以种花的3个条件：
        1.自己为0
        2.i+1为0或者i在末尾
        3.i-1为0或者i在开头
        只需判断做遍历即可
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0)
                    && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                n--;
                if(n <= 0) return true;
                flowerbed[i] = 1;
            }
        }

        return n <= 0;
    }
    /*
    方法二:跳格子，一次遍历两个数，当前位置是0时，如果下一个位置是0或者是末尾位置说明可在这个位置插入，否则做+1操作
        保证当前位置一定是可能的插入位置
    */
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }



}
