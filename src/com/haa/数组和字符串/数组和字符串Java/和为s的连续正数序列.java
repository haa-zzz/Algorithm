package com.haa.数组和字符串.数组和字符串Java;

import java.util.ArrayList;
import java.util.List;

public class 和为s的连续正数序列 {
    /*
    输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
    序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     */
    /*
    求和公式 （n+1)*n / 2
    还是双指针，每次求和，看结果是否满足
    开始时让两个指针指向1，2。
     */
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> arr = new ArrayList();
            int left = 1;
            int right = 2;
            while(left < right) {
                int sum = (left + right)*(right - left + 1) /2 ;
                if(sum == target) {
                    int[] res = new int[right - left + 1];
                    for (int i = left; i <= right; i++) {
                        res[i - left] = i;
                    }
                    arr.add(res);
                    left++;
                } else if(sum < target) {
                    right++;
                } else {
                    left++;
                }
            }
            return arr.toArray(new int[arr.size()][]);
        }
    }
}
