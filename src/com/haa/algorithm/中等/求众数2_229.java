package com.haa.algorithm.中等;

import bean.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 求众数2_229 {

    /*
    给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
     */

    /*
    分析：这道题是  多数元素_169的升级版，相比较于多数元素_169它要找的是超过n/3次的元素，这样的结果可能不唯一，有1个或2个
        所以排序方法在这里行不通，可以继续使用哈希表和摩尔投票法来解题
     */
    /*
    方法1：hash表，用Hash表储存，键存数组元素，值存对应的个数，只要一个元素的个数大于length / 3，就添加进集合中
        注意：由于我们只要一个元素的个数大于length / 3，就添加进集合中，当这个数后序继续出现时，如果直接用ArrayList添加，就会
        出现重复，所以要先借助HashSet去重

        时间复杂度O(N)

     */
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> hashList = new HashSet<>();
        int length = nums.length;
        for(int i = 0; i < length; i++){
            int count = map.getOrDefault(nums[i],0)+1;
            if(count > length/3){
                hashList.add(nums[i]);            //先用hashset存储，防止存储重复
            }
            map.put(nums[i],count);
        }
        list.addAll(hashList);

        return list;
    }
    /*
    方法2. 摩尔投票法

        如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
        如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；
        如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。

         候选人major1初始化为nums[0],票数count1初始化为0,
         候选人major2初始化为nums[0],票数count2初始化为0,

            1.当遇到与major1相同的数，count1票数加1
            2.当遇到与major2相同的数，count2票数加1
            3.当票数count1为0时，更换候选人，并将票数count1重置为1.
            4.当票数count2为0时，更换候选人，并将票数count2重置为1.
            5.当不满足这些情况时，count1--,count2--


         时间复杂度O(N)
         空间复杂度O(1)
     */

    public List<Integer> majorityElement1(int[] nums) {

        //创建返回值
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;

        int major1 = nums[0],major2 = nums[0];
        int count1 = 0,count2 = 0;

        // 配对阶段
        for(int num : nums){
            if(major1 == num){
                count1++;
                continue;
            }
            if(major2 == num){
                count2++;
                continue;
            }
            if(count1==0){
                major1 = num;
                count1 = 1;
                continue;
            }
            if(count2 == 0){
                major2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        //计数阶段
        //找到了两个候选人后，需要确定票数是否满足大于N/3
        count1 = 0; count2 = 0;
        for(int num : nums){
            if(num == major1){
                count1++;
            }
            else if(num == major2){
                count2++;
            }
        }
        if(count1 > nums.length/3)
            res.add(major1);
        if(count2 > nums.length/3)
            res.add(major2);
        return res;
    }
}
