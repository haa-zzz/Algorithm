package AlgorithmByKotlin

import java.util.*
import kotlin.collections.ArrayList

/*
    给出一个区间的集合，请合并所有重叠的区间。
    intervals[i][0] <= intervals[i][1]
     */
/*
方法:排序加合并，把区间按第一个元素从小到大排序，排序后进行合并，具体的，记left为当前最小的起点，right为终点，
    如果当前终点大于下一个数组的起点的时候，比较当前终点和下一个终点的大小，取为right
    时间复杂度   O(N *log N) 主要是排序的开销
    空间复杂度   O(log n)
 */
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if(intervals.isEmpty()){
            return Array(0){ IntArray(2) }
        }
        Arrays.sort(intervals){ a:IntArray, b:IntArray -> a[0]-b[0]}
        val list : MutableList<IntArray> = ArrayList()
        var i = 0
        val n = intervals.size
        while(i < n){
            val left = intervals[i][0]
            var right = intervals[i][1]
            while( i < n-1 && intervals[i+1][0] <= right)   {
                i++
                right = intervals[i][0]
            }
            list.add( intArrayOf(left,right))
            i++
        }
        return list.toTypedArray()
    }
}
