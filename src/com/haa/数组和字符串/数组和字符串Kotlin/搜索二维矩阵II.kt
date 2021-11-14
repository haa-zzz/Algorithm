package com.haa.数组和字符串.数组和字符串Kotlin

class 搜索二维矩阵II {
    /*
    也叫二维数组的查找
    编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    每行的元素从左到右升序排列。
    每列的元素从上到下升序排列。
     */
    /*
    方法：双指针，从左下角或者右上角找起，一个指针控制行，一个指针控制列。
    时间复杂度O（m+n）
    空间复杂度O(1)
     */
    class Solution {
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            val n = matrix.size
            val m = matrix[0].size
            var i = n-1
            var j = 0
            while(i >=0 && j < m){
                if(target == matrix[i][j]){
                    return true
                }
                else if(target < matrix[i][j]){
                    i--
                }else{
                    j++
                }
            }
            return false
        }
    }

}
class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val n = nums.size
        var number = n * (n - 1) / 2
        for(i in nums){
            number-=i
        }
        return -number

    }
}