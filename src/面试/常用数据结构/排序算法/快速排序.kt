package 面试.常用数据结构.排序算法

/**
 * 快速排序
 * 取一个记录作为枢轴，经过一趟排序将整段序列分为两个部分，使得数轴左侧都小于枢轴、右侧都大于枢轴；
 * 再对这两部分继续进行排序使整个序列达到有序
 * 1. 时间复杂度：O( nlogn ）
 * 2. 空间复杂度： O(logn)
 * 3. 稳定性：不稳定排序。因为关键字的比较和交换是跳跃进行的。
 *
 * @param array 待排序的数组
 * @param left  要排序的第一个元素的索引(包括)
 * @param right 最后一个要排序的元素的索引(不包括)
 */
fun quickSortMS(array: IntArray, left: Int, right: Int) {
    while(left < right-1) {
        val pivot = partitonMS(array, left, right-1)
        quickSortMS(array, left, pivot)
        quickSortMS(array, pivot+1, right)
    }
}
fun partitonMS(array: IntArray, left: Int, right: Int): Int {
    var low = left
    var high = right
    val key = array[low]
    while(low < high) {
        while(low < high && array[high] >= key) high--
        swapMS(array, low, high)
        while(low < high && array[low] <= key) low++
        swapMS(array, low, high)
    }
    return low
}

private fun swapMS(array: IntArray, a: Int, b: Int) {
    val temp = array[a]
    array[a] = array[b]
    array[b] = temp
}


/**
 * 优化：
 *  1.优化选取轴 - 三数取中法
    2.优化不必要的交换。交换可以用替换代替
    3.优化小数组的排序，对于很小和部分有序的数组，快排不然插排好
    4.优化递归过程：采用尾递归优化递归过
 */

const val MAX_LENGTH_INSERT_SORT: Int = 7 //数组长度阈值

fun quickSortMSPro(array: IntArray, left: Int, right: Int) {
    var left = left
    while(left < right-1) {
        val key = findKeyPro(array, left, right-1)
        //进行分割
        quickSortMSPro(array, left, key)
        left = key + 1
        //递归一次后，low就失去作用，可以让 low = pivot+1，加上while循环相当于quickSort(array, pivot + 1, right);
    }
}

private fun findKeyPro(array: IntArray, left: Int, right: Int) : Int {
    var low = left
    var high = right
    val mid = low + (high - low) / 2

    if (array[low] > array[high]) swapMS(array, low, high)
    if (array[mid] > array[high]) swapMS(array, mid, high)
    if (array[mid] > array[low]) swapMS(array, low, mid)
    val pivotKey = array[low] //首先选最左边的元素记为中轴元素

    while (low < high) {
        while (low < high && array[high] >= pivotKey) high--
        array[low] = array[high] //采用替换而不是交换的方式进行操作
        while (low < high && array[low] <= pivotKey) low++
        array[high] = array[low] //采用替换而不是交换的方式进行操作
    }
    array[low] = pivotKey //将枢轴数值替换回array[low]
    return low //返回枢轴所在位置

}