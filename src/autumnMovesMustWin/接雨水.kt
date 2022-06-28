package autumnMovesMustWin

fun trap(height: IntArray): Int {
    val n = height.size
    if(n < 3) {
        return 0
    }
    val dpLeft = IntArray(n)
    val dpRight = IntArray(n)
    dpLeft[0] = height[0]
    dpRight[n-1] = height[n-1]
    for(i in 1 until n) {
        dpLeft[i] = Math.max(dpLeft[i-1], height[i])
    }
    for(i in n-2 downTo 0) {
        dpRight[i] = Math.max(dpRight[i+1], height[i])
    }
    var sum = 0
    for(i in 1 until n-1) {
        val area = Math.min(dpLeft[i-1], dpRight[i+1]) - height[i]
        if(area > 0) {
            sum+=area
        }
    }
    return sum
}
/*
    方法2.双指针优化实现O(1)空间
        在上面的做法中，因为要分别从前向后和从后向前遍历来计算dp数组，所以无法在此基础上实现空间优化。
        为此可以换一种思路，使用双指针，left 和 right 并维护 leftMax 和 rightMax
        注意leftMax记录的是[0,left-1]中的最大值，rightMax记录的是[right+1,n-1]中的最大值

        如果leftMax < rightMax, 此时leftMax就是left位置对应的最大高度，height[left]就可以计算了
        否则leftMax >= rightMax,此时rightMax就是right位置对应的最大高度，height[right]就可以计算了
        这样直到left>right
     */
fun trapByMethod2(height: IntArray): Int {
    val n = height.size
    if (n < 3) {
        return 0
    }
    var nums = 0
    var left = 1
    var right = n - 2
    var leftMax = height[0]
    var rightMax = height[n-1]
    while (left <= right) {
        if(leftMax < rightMax) {
            if(leftMax - height[left] > 0) {
                nums += leftMax - height[left]
            }
            leftMax = Math.max(leftMax, height[left])
            left++
        } else {
            if(rightMax - height[right] > 0) {
                nums += rightMax - height[right]
            }
            rightMax = Math.max(rightMax, height[right])
            right--

        }
    }
    return nums
}