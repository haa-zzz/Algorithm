package com.haa.数组和字符串.数组和字符串Java;

public class 除自身以外数组的乘积 {
    /*
    给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
    提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

    说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

    进阶：
    你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     */
    /*
    方法1.左右乘积列表
        对索引为i处值的计算：可通过索引左侧所有数字的乘积乘以索引右侧所有数字的乘积。
        具体的：可以开辟两个数组 left[i]存放i左侧所有数字的乘积，right[i]存放i右侧所数字的乘积
        product[i] = left[i] * right[i]

        时间复杂度O(N)
        空间复杂度O(N)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int[] product = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i = 1; i < n; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i = n-2; i >=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i = 0; i < n; i++){
            product[i] = left[i] * right[i];
        }
        return product;
    }
    /*
    优化上面的解法，使之成为O(1)的空间复杂度
    思路：我们可以动态构造left数组或right数组，同时用没动态构造的数组来保存最后的输出结果，使之成为O(1)空间
     */
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int right = 1;               //动态构造right数组

        left[0] = 1;
        for(int i = 1; i < n; i++){             //先初始化left数组存储左值
            left[i] = left[i-1] * nums[i-1];
        }

        for(int i = n-1; i >= 0 ; i--){        // 边动态构建right数组边存储结果
            left[i] = left[i] * right;
            right *= nums[i];
        }
        return left;
    }


}
