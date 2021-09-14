package com.haa.数组和字符串.数组和字符串Java;

public class 盛最多水的容器 {
    /*
    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
    垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    说明：你不能倾斜容器。
     */
    /*
    方法：双指针
        双指针代表的是可以作为容器边界的所有位置的范围。在一开始，双指针指向数组的左右边界，
        表示数组中所有的位置都可以作为容器的边界。我们每次将对应的数字较小的那个指针往另一个指针的方向移动一个位置，
        表示这个指针不可能再作为容器的边界了。
        时间复杂度O(N)
        空间复杂度O(1)
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
