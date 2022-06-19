package autumnMovesMustWin

/*
   给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
    找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
    返回容器可以储存的最大水量。
    力抠：11
    */

/**
   方法：双指针
    指针left,right 分别指向数组的最左边 和 最右边。每次移动height较小的指针，同时更新maxArea值
    正确性验证：
        对于 S[i,j]: 如果height[i] < height[j]: 那么是s[i,j-1], s[i, j-2], ... , s[i, i+1]一定都小于S[i,j]。(height不变，长变小)
    所以这样走一遍和暴力遍历走一遍的效果是一样的。
 */

fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var left = 0
    var right = height.size-1
    while(left < right) {
        maxArea = if(height[left] < height[right]) {
            Math.max(maxArea, (right-left) * height[left++])
        } else {
            Math.max(maxArea, (right-left) * height[right--])
        }
    }
    return maxArea
}

/**
 * java
 */
/*
public int maxArea(int[] height) {
    int i = 0, j = height.length - 1, res = 0;
    while(i < j){
        res = height[i] < height[j] ?
        Math.max(res, (j - i) * height[i++]):
        Math.max(res, (j - i) * height[j--]);
    }
    return res;
}*/
