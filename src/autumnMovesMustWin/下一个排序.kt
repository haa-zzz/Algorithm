package autumnMovesMustWin

/*
   实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
   如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
   必须 原地 修改，只允许使用额外常数空间。
    */
/**
分析：
    从后向前查找相邻元素(i,j)，分三种情况
        1.如果nums[i] < nums[j]，说明i位置就是下一个排列要改变的位置，此时(j,n)一定是降序排列，
            从n开始向前检索，找到第一个大于nums[i]的元素，并和nums[i]作交换，然后吧(i+1,n)的元素升序排列(即直接反转)，结束。
        2.如果nums[i] >= nums[j]，直接i--，
        3.i == 0 && nums[i] >= nums[j],说明此时整个数组降序排列，吧它改为升序排列。

    时间复杂度O(N)
    空间复杂度O(1)
 */
fun nextPermutation(nums: IntArray) {
    var n = nums.size - 1
    for (i in n - 1 downTo 0) {
        if (nums[i] < nums[i + 1]) {
            while (nums[i] >= nums[n]) n--
            swap(nums, i, n)
            reverse(nums, i + 1) //反转
            return
        }
    }
    reverse(nums, 0)
}

private fun reverse(nums: IntArray, start: Int) {
    var start = start
    var end = nums.size - 1
    while (start < end) {
        swap(nums, start, end)
        start++
        end--
    }
}

private fun swap(array: IntArray, a: Int, b: Int) {
    if (array[a] != array[b]) {
        array[a] = array[a] xor array[b]
        array[b] = array[a] xor array[b]
        array[a] = array[a] xor array[b]
    }
}