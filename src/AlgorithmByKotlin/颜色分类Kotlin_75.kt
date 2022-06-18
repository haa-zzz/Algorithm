package AlgorithmByKotlin

class 颜色分类Kotlin_75 {
    /*
    给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     */
    /*
    分析：双指针
        用两个指针left和right分别指向数组的起始位置和结束位置。在遍历的过程中，如果遇到0,就和left做交换，如果遇到2就与right做交换。

        注意细节：在i与right交换后，i位置可能还是0，或者2 ,此时不能直接跳过，还要继续做交换
     */
    fun sortColors(nums: IntArray): Unit {
        val n = nums.size
        var left = 0
        var right = n-1
        for( i in 0 .. right){
            while( i <= right && nums[i] == 2){
                swap(nums,i,right)
                right--
            }
            if(nums[i] == 0){
                swap(nums,i,left)
                left++
            }
        }
    }
    private fun swap(nums : IntArray, index : Int, i : Int ){
        val temp = nums[index]
        nums[index] = nums[i]
        nums[i] = temp
    }




}