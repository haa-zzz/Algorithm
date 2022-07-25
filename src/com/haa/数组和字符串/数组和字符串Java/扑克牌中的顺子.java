package com.haa.数组和字符串.数组和字符串Java;

import java.util.HashSet;
import java.util.Set;

public class 扑克牌中的顺子 {
    /*
    从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
    A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     */
    /*
    集合 Set + 遍历
    遍历五张牌，遇到大小王（即 0 ）直接跳过。
    判别重复： 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为 O(1) ；
    获取最大 / 最小的牌： 借助辅助变量 mama 和 mimi ，遍历统计即可。
    max−min<5
     */
    class Solution {
        public boolean isStraight(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int max = 0, min = 14;
            for(int num : nums) {
                if(num == 0) continue; // 跳过大小王
                max = Math.max(max, num); // 最大牌
                min = Math.min(min, num); // 最小牌
                if(set.contains(num)) return false; // 若有重复，提前返回 false
                set.add(num); // 添加此牌至 Set
            }
            return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
        }
    }
}
