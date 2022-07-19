package 面试.常用数据结构.排序算法

/**
 * 归并排序
 * 将一个大的无序数组有序，我们可以把大的数组分成两个，然后对这两个数组分别进行排序，
 * 之后在把这两个数组合并成一个有序的数组。由于两个小的数组都是有序的，所以在合并的时候是很快的。
 * - 时间复杂度：O(nlog(n)）
 * - 空间复杂度： O(n)
 * - 稳定性：稳定排序。
 *
 * @param array 待排序的数组
 * @param left  要排序的第一个元素的索引(包括)
 * @param right 最后一个要排序的元素的索引(不包括)
 */

fun mergeSortMS(array: IntArray, left: Int, right: Int) {
    if(left < right-1) {
        //分割数组
        val mid = left + (right - left)/2
        //对左半部分进行排序
        mergeSortMS(array, left, mid)
        //对右半部分进行排序
        mergeSortMS(array, mid, right)
        //进行合并
        merge(array, left, mid, right)
    }
}

private fun merge(array: IntArray, left: Int, mid: Int, right: Int) {
    //先用一个临时数组把他们合并汇总起来
    val a = intArrayOf(right - left)
    var i = left
    var j = mid
    var k = 0
    while(i < mid && j < right) {
        if(array[i] < array[j]) {
            a[k++] = array[i++]
        } else {
            a[k++] = array[j++]
        }
    }
    while(i < mid)  a[k++] = array[i++]
    while(j < right)  a[k++] = array[j++]

    i = left
    for(j in 0 until k) {
        array[i++] = a[j]
    }

}