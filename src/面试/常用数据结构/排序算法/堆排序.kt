package 面试.常用数据结构.排序算法

/**
 * 堆排序：
 * 堆排序（Heapsort） 是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，
 * 并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * - 时间复杂度：O(nlogn)）
 * - 空间复杂度： O(1)
 * - 稳定性：不稳定排序。因为在堆的调整过程中，关键字进行比较和交换所走的是该结点到叶子结点的一条路径，
 * 因此对于相同的关键字就可能出现排在后面的关键字被交换到前面来的情况
 *
 * @param array
 */

fun headSort(array: IntArray) {
    val n = array.size
    //构建大顶堆
    //从构建的二叉树的叶子节点的上一层节点开始下沉操作，一直到索引为0的位置，也就是根节点，
    //此时所有需要下沉的节点都下沉了，就变成了大顶堆
    for (i in (n - 2) / 2 downTo 0) {
        downAdjust(array, i, n - 1)
    }
    //进行堆排序
    for (i in n - 1 downTo 1) {
        // 把堆顶元素与最后一个元素交换
        val temp = array[i]
        array[i] = array[0]
        array[0] = temp
        // 把打乱的堆进行调整，恢复堆的特性（此时只需要让堆顶节点下沉，就可以构建大顶堆）
        downAdjust(array, 0, i - 1)
    }

}
//下沉（由于从下往上下沉，一趟下沉操作完成后，以下沉节点为根节点的堆一定变成大顶堆）
fun downAdjust(arr: IntArray, parent: Int, n: Int) {
    //临时保存要下沉的元素
    var parent = parent
    val temp = arr[parent]
    //定位左孩子节点的位置
    var child = 2 * parent + 1
    //开始下沉
    while (child <= n) {
        // 如果右孩子节点比左孩子大，则定位到右孩子
        if (child + 1 <= n && arr[child] < arr[child + 1]) child++
        // 如果孩子节点小于或等于父节点，则下沉结束
        if (arr[child] <= temp) break
        // 父节点进行下沉
        arr[parent] = arr[child]
        parent = child
        child = 2 * parent + 1
    }
    arr[parent] = temp
}