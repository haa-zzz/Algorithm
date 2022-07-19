package 面试

class MainKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            //一维数组：
            val array = IntArray(3) //长度为3的一维数组
            val array2 = Array(3) { it -> it * 2 } //[0,2,4]
            val array3 = emptyArray<Int>(); //空数组

            //多维数组
            val array2d = Array(3) { Array(3) { 0 } }  //3*3 的 Int数组
            val array2d1 = Array(3){IntArray(3)}
            val array3d = Array(3){Array(3){IntArray(3)}}
        }
    }
}
//object
object MainKt1 {
    @JvmStatic
    fun main(args: Array<String>) {

    }
}

//顶层函数
fun main() {

}