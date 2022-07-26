package com.haa.排序;

public class 数组中的第K大的元素 {
    /*
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     */
        /*
        方法1: 可以采用快排的思想，因为快排时每一趟排序都会定一个枢轴，枢轴左边的都小于枢轴，枢轴右边的都大于枢轴，所以这个枢轴位置
        是已经排好序的，
            如果length-k == pivot,那就直接返回就好了
            如果length-k < pivot,那就对左边进行排序
            否则就对右边进行排序
         */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, 0, nums.length, nums.length - k);
        }

        int quickSort(int[] nums, int left, int right, int index) {
            int pivot = partition(nums, left, right - 1);
            if (pivot == index) {
                return nums[index];
            } else if (pivot < index) {
                return quickSort(nums, pivot + 1, right, index);
            } else
                return quickSort(nums, left, pivot, index);
        }
        int partition(int[] nums, int low, int high) {
            int pivotKey = nums[low];
            while (low < high) {
                while (low < high && nums[high] >= pivotKey) {
                    high--;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] <= pivotKey) {
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = pivotKey;
            return low;
        }
    }
    /*
    方法2：堆排，维护一个大顶堆
     */
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            return headSort(nums, 0, nums.length, nums.length - k);
        }
        private int headSort(int[] nums, int left, int right, int indexK) {
            int n = nums.length;
            for(int i = (n-2) /2; i >= 0 ; i--) {
                downAdjust(nums, i, n-1);
            }
            for(int j = nums.length-1; j >= indexK; j--){
                int temp = nums[0];
                nums[0] = nums[j];
                nums[j] = temp;
                downAdjust(nums, 0, j-1);
            }
            return 0;
        }
        private void downAdjust(int[] nums, int parent, int n) {
            int child = parent * 2 + 1;
            int temp = nums[parent];
            while(child <= n) {
                if(child + 1 <= n && nums[child+1] > nums[child]) child = child + 1;
                if (nums[child] <= temp) break;
                nums[parent] = nums[child];
                parent = child;
                child = parent * 2 + 1;
            }
            nums[parent] = temp;
        }
    }

}
