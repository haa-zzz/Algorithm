package 面试.常用数据结构.排序算法

/**
 * 希尔排序
 * 将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，是一种优化的直接插入排序
 * 先让数组中任意间隔为 gap 的元素有序，刚开始 gap 的大小可以是 gap = n / 2,接着让 gap = n / 4，
 * 让 gap 一直缩小，当 gap = 0 时，此时的数组就是有序的了。
 * - 时间复杂度：O(nlogn)
 * - 空间复杂度： O(1)
 * - 稳定性：不稳定
 * 参考博客：https://zhuanlan.zhihu.com/p/57088609
 */
fun hellSort(array: IntArray) {
    val len = array.size
    if (len < 2) {
        return
    }
    var cur: Int
    var gap = len / 2
    while (gap > 0) {
        //分成了gap组，前面0~gap-1分别是各组的第一个元素，可以认为是默认排好的，下标从gap开始做插入排序
        for (i in gap until len) {
            cur = array[i]
            var pre = i - gap
            while (pre >= 0 && array[pre] > cur) {
                array[pre + gap] = array[pre]
                pre -= gap
            }
            array[pre + gap] = cur
        }
        gap /= 2
    }
}