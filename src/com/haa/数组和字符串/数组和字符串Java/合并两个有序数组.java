package com.haa.数组和字符串.数组和字符串Java;

public class 合并两个有序数组 {
    /*
    给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
    初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
    这样它就有足够的空间保存来自 nums2 的元素。
     */
    /*
    方法.插入排序，遍历数组2，每一次从数组1的结尾处开始往前找数组2对应元素的插入位置，如果当前元素大于数组1中的元素，
        把改元素后移，否则执行插入操作
        时间复杂度O(N*M)
        空间复杂度O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i = 0; i < n; i++){
            int j = m+i-1;
            while(j!=-1 && nums1[j] > nums2[i]){
                nums1[j+1] = nums1[j];
                j--;
            }
            nums1[j+1] = nums2[i];
        }

    }
}
