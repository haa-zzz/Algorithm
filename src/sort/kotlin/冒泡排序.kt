package sort.kotlin

fun bubbleSort(array: Array<Int>) {
    val n = array.size
    for(i in 0 until n-1) {
        for(j in 0 until n-i-1) {
            if (array[j] > array[j + 1]) {
                array[j] = array[j] xor array[j + 1]
                array[j + 1] = array[j] xor array[j + 1]
                array[j] = array[j] xor array[j + 1]
            }
        }
    }
}

fun bubbleSortPro(array: Array<Int>) {
    val n = array.size
    for(i in 0 until n-1) {
        var boo = false
        for(j in 0 until n-i-1) {
            if (array[j] > array[j + 1]) {
                boo = true
                array[j] = array[j] xor array[j + 1]
                array[j + 1] = array[j] xor array[j + 1]
                array[j] = array[j] xor array[j + 1]
            }
        }
        if(!boo) {
            return
        }
    }
}