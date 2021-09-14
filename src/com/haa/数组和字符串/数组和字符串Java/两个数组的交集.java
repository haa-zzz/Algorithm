package com.haa.数组和字符串.数组和字符串Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两个数组的交集 {
    public static void main(String[] args){

    }
    /*
        方法一：哈希表
     */
    /*
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
            return intersect(nums2,nums1);
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for (int num:nums1) {
            int count = hm.getOrDefault(num,0)+1;
            hm.put(num,count);
        }
        int[] arr = new int[nums1.length];
        int index = 0;
        for(int num:nums2){
            int count = hm.getOrDefault(num,0);
            if(count>0){
                count--;
                arr[index++] = num;
                if(count>0){
                    hm.put(num,count);
                }else
                    hm.remove(num);
            }
        }
        return Arrays.copyOfRange(arr,0,index);
    }
    */

    /*
    方法二，排序
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0,j = 0; i < nums1.length&& j < nums2.length;){
            if(nums1[i]<nums2[j])
                i++;
            else if(nums1[i]>nums2[j])
                j++;
            else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
     }

}
