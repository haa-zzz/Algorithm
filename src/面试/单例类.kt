package 面试

/**
Kotlin -- 饿汉式
问题：
一开始就创建对象了，浪费了资源
 */
object Singleton1Kt {

}

/**
 * kotlin -- 懒汉式
 * 只是在使用的时候才会去创建对象
 * 但是每次访问都需要进行同步，效率不高
 */
//Kotlin实现

class SingleTon2 private constructor(){
    companion object {
        private var instance : SingleTon2? = null
            get() {
                if(field == null) {
                    field = SingleTon2()
                }
                return field
            }
        @Synchronized
        fun get(): SingleTon2 {
            return instance!!
        }
    }
}

//双重检验锁
//kotlin实现
class SingletonDemo private constructor() {
    companion object {
        val instance: SingletonDemo by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDemo()
        }
    }
}



