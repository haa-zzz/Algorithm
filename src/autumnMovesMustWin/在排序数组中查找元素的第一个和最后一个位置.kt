package autumnMovesMustWin
/*
   给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
   如果数组中不存在目标值 target，返回 [-1, -1]。
   进阶：
   你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
   力抠：34
*/
/*
    方法：二分查找
        最直观的方法就是二分查找找到target后左右遍历找区间的端点
        缺点:在极端情况下时间复杂度为O(N)，比如数组里的元素全是target
     */
fun searchRange(nums: IntArray, target: Int): IntArray {
    val n = nums.size
    var left = 0
    var right = n - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] < target -> {
                left = mid + 1
            }
            nums[mid] > target -> {
                right = mid - 1
            }
            else -> {
                var pre = mid
                var cur = mid
                while (pre >= 1 && nums[pre - 1] == target) pre--
                while (cur < n - 1 && nums[cur + 1] == target) cur++
                return intArrayOf(pre, cur)
            }
        }
    }
    return intArrayOf(-1, -1)
}
/**
  改进：
      使用两次二分查找一次查找左端点，一次查找右端点。使时间复杂度降为O（logN）
      细节：
          1.
              如果判断条件为nums[mid] <= target，寻找的应该是最后一个出现的索引
              如果判断条件为nums[mid] >= target，寻找的应该是第一个出现的索引
          2.  如果target不存在于数组中需要特判
          3.  再查找右值时，mid的取值为 left + 1 + ((right-left) >> 1) ，，注意加1
   */
fun searchRangeByMethodTwo(nums: IntArray, target: Int): IntArray {
    val n = nums.size
    val ans = intArrayOf(-1, -1)
    if (n == 0) return ans
    var left = 0
    var right = n - 1
    while (left < right) {                //第一次二分查找查找左值
        val mid = left + (right - left shr 1)
        if (nums[mid] >= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    //此时left == right,如果存在target,都指向数组中第一个出现target的索引
    if (nums[left] != target) {           //特判：如果target不存在于数组中
        return ans
    }
    ans[0] = left
    left = 0
    right = n - 1
    while (left < right) {                //第二次二分查找查找右值
        //注意细节，这里mid的取值要+1再除2：比如如果对于 nums[8,8],target = 8如果不处理会出现死循环
        val mid = left + 1 + (right - left shr 1)
        if (nums[mid] <= target) {
            left = mid
        } else {
            right = mid - 1
        }
    }
    ans[1] = left
    return ans
}