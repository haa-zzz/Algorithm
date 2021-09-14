package com.haa.algorithm;

import java.util.*;

public class 多数元素_169 {
    /*
    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    示例 1：
      输入：[3,2,3]
      输出：3

    示例 2：
        输入：[2,2,1,1,1,2,2]
        输出：2
     */
    /*
    方法1：排序,吧数组按从小到大或者从大到小的顺序排好之后，
       length/2索引位置的元素就是要找的数
       时间复杂度O(n*log(n))，主要是排序的时间复杂度
       空间复杂度O(1)
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    /*
    方法2.哈希表,用Hash表储存，键存数组元素，值存对应的个数，只要一个元素的个数大于length / 2，直接返回结束
    时间复杂度O(N)
    空间复杂度O(N)
     */
    public int majorityElement1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int num : nums){
            int count = map.getOrDefault(num, 0) + 1;
            //如果某个数字出现的个数已经超过数组的一半，直接返回
            if (count > length / 2)
                return num;
            map.put(num,count);
        }
        return -1;
    }
    /*
        摩尔投票法，解决的问题是如何在任意多的候选人中，选出票数超过一半的那个人。注意，是超出一半票数的那个人。
    方法3.摩尔投票法
       候选人major初始化为nums[0],票数count初始化为1
        当遇到与major相同的数，票数加1，否则票数减1
        当票数count为0时，更换候选人，并将票数count重置为1.

         时间复杂度O(N)
         空间复杂度O(1)     */

    public int majorityElement2(int[] num) {

        int major = num[0];
        int count = 0;
        for(int i : num){
            if(i == major){
                count++;
                continue;
            }
            if(count == 0){
                major = i;
                count = 1;
                continue;
            }
            count--;
        }

        return major;

    }

}
