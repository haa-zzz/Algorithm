package 面试

class 死锁Kt {
    class DeanLock {
        object Main {
            var lock1 = Object()
            var lock2 = Object()
            @JvmStatic
            fun main(args: Array<String>) {
                Thread {
                    synchronized(lock1) {
                        println("占有object")
                        Thread.sleep(1000)
                        synchronized(lock2) { println("抢占other") }
                    }
                }.start()
                Thread {
                    synchronized(lock1) {
                        println("占有other")
                        synchronized(lock2) { println("抢占object") }
                    }
                }.start()
            }
        }
    }
}