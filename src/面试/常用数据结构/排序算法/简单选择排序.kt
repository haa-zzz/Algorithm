package 面试.常用数据结构.排序算法

/**
 * 简单选择排序
 *
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 *  - 时间复杂度： O（N^2）
 *  - 空间复杂度： O(1)
 *  - 稳定性：不稳定排序
 * @param array  待排序的数组
 */
fun selectionSort(array: Array<Int>) {
    val n = array.size
    if (n < 2) {
        return
    }
    for (i in 0 until n - 1) {
        var minIndex = i
        for (j in i + 1 until n) {
            if (array[j] < array[minIndex])
                minIndex = j
        }
        if (array[i] != array[minIndex]) {        //如果他俩相等，异或运算后两者都变为0
            array[i] = array[i] xor array[minIndex] //交换两个数
            array[minIndex] = array[i] xor array[minIndex]
            array[i] = array[i] xor array[minIndex]
        }
    }
}

/**
 * 简单选择排序的优化
 * 在每一次查找最小值的时候，也可以找到一个最大值，然后将两者分别放在它们应该出现的位置，减少遍历次数
 *
 * @param array
 */
fun SelectionSortPro(array: IntArray) {
    val n = array.size
    if (n < 2) {
        return
    }
    var left = 0
    var right = n - 1
    while (left < right) {
        var minIndex = left
        var maxIndex = right
        for (i in left..right) {
            if (array[minIndex] > array[i]) {
                minIndex = i
            }
            if (array[maxIndex] < array[i]) {
                maxIndex = i
            }
        }
        if (minIndex != left) {
            val temp = array[minIndex]
            array[minIndex] = array[left]
            array[left] = temp
        }
        //如果left索引位置为最大值，由于left和minIndex交换了，所以 maxIndex = minIndex;
        if (left == maxIndex) maxIndex = minIndex
        //还有一种情况，minIndex索引位置为最大值，说明最小值和最大值的索引相同，
        //即只剩最后一个元素了，此时可以不做处理
        if (maxIndex != right) {
            val temp = array[maxIndex]
            array[maxIndex] = array[right]
            array[right] = temp
        }
        left++
        right--
    }
}