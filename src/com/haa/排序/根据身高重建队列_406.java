package com.haa.排序;

import java.util.Arrays;
import java.util.LinkedList;

public class 根据身高重建队列_406 {
    /*
    假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，
        前面 正好 有 ki 个身高大于或等于 hi 的人。

    请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj]
        是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     */

    /*
    分析：
    题意理解：
        开始时这个队列是按 (每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。) 这样的顺序来排列的。
        比如 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        现在把他们打乱顺序给你，比如 [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        要求返回重新排好序的队列。
    分析：
        解题思路：先排序再插入
     1.排序规则：按照先H高度降序，K个数升序排序
     2.遍历排序后的数组，根据K插入到K的位置上
     核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     时间复杂度O(N ^ 2)
     空间复杂度O( log N)     排序所需要的栈空间
     */
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,(a, b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            if (people[i][1]>=i){
                res[i] = people[i];
            }else {
                int target = people[i][1];
                for (int j = i; j > target; j--) {
                    res[j] = res[j-1];
                }
                res[target] = people[i];
            }
        }
        return res;
    }
}
