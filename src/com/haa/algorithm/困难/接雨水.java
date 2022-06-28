package com.haa.algorithm.困难;

public class 接雨水 {
    /*
    给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    示例 1：
    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    输出：6
    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     */
    /*
    分析：对于下标i,下雨后水能到达的最大高度等于下表i两边的最大高度的最小值，下标i处能接的雨水量等于下标i处对应的最大高度减去height[i]
    此时问题的关键在算i位置对应的最大高度
     */
    /*
    方法1.动态规划来求每一个i对应的最大高度
            定义两个dp数组，dpLeft[]和dpRight[]分别来求i位置左边对应的最大高度和右边对应的最大高度
            初始化：dpLeft[0] = height[0], dpRight[0] = height[n-1];
            转移方程：dpLeft[i] = Max(dpLeft[i-1],height[i])
                    dpRight[i] = Max(dpRight[i+1],height[i])

         时间复杂度O(N)
         空间复杂度O(N)
     */
    public int trap(int[] height) {
        int n = height.length;
        int nums = 0;
        if(n <= 2){
            return 0;
        }
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];

        dpLeft[0] = height[0];
        dpRight[n-1] = height[n-1];
        for(int i = 1; i < n; i++){
            dpLeft[i] = Math.max(dpLeft[i-1],height[i]);
        }
        for(int i = n-2; i >= 0; i--){
            dpRight[i] = Math.max(dpRight[i+1],height[i]);
        }
        for(int i = 1; i < n-1; i++){
            int num = Math.min(dpLeft[i],dpRight[i]) - height[i] ;
            nums += num;
        }
        return nums;
    }
    /*
    方法2.双指针优化实现O(1)空间
        在上面的做法中，因为要分别从前向后和从后向前遍历来计算dp数组，所以无法在此基础上实现空间优化。
        为此可以换一种思路，使用双指针，left 和 right 并维护 leftMax 和 rightMax
        注意leftMax记录的是[0,left]中的最大值，rightMax记录的是[left,n-1]中的最大值
        如果height[left-1] < height[right+1]说明 leftMax < rightMax, 此时leftMax就是left位置对应的最大高度，height[left]就可以计算了
        否则：height[left] >= height[right] 说明 leftMax >= rightMax,此时rightMax就是right位置对应的最大高度，height[right]就可以计算了
     */
    public int trap1(int[] height) {
        int n = height.length;
        int nums = 0;
        if(n <= 2){
            return 0;
        }
        int left = 0, right = n-1;
        int leftMax = 0, rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(height[left] < height[right]){
                nums += leftMax - height[left];
                left++;
            }else{
                nums += rightMax - height[right];
                right--;
            }
        }
        return nums;
    }

}
