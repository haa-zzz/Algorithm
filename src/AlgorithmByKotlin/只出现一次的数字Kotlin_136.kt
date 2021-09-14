package AlgorithmByKotlin

class 只出现一次的数字Kotlin_136 {
    fun singleNumber(nums: IntArray): Int {
        var k = 0
        for (num in nums) {
            k = k xor num
        }
        return k
    }
}