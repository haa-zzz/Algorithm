package com.haa.数组和字符串.数组和字符串Java;

public class 缺失的第一个正数 {
    /*
    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
    请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     */
    /*
    原地hash,因为找的是第一个缺失的正数，那么这个数一定是 1-n+1 中的某一个。我们进行一次遍历，把当前的数x放到下标为x-1的地方.
    然后我们再遍历一次数组，第 1 个遇到的它的值和下标不匹配的那个数，就是我们要找的缺失的第一个正数。
    时间复杂度O(n)
    空间复杂度O(1)
     */
    public class Solution {
        //比如 3  4 -1 1
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换。 nums[i] - 1  & i 判断
                while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            // [1, -1, 3, 4]
            for (int i = 0; i < len; i++) {
                if (nums[i] != i + 1) {     //如果不匹配，就说明找到了，直接返回
                    return i + 1;
                }
            }
            // 都正确则返回数组长度 + 1
            return len + 1;
        }
        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}
