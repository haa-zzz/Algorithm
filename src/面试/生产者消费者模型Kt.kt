package 面试

import java.lang.Thread.sleep
import java.util.*
import kotlin.concurrent.thread

class 生产者消费者模型Kt {
    val MAX_VALUE = 5
    private val buffer = LinkedList<Int>()
    private val lock = Object()
    fun produce(data: Int) {
        thread {
            synchronized(lock) {
                while (buffer.size >= MAX_VALUE) {
                    // 注意此处使用while不能使用if，因为有可能是被另一个生产线程而非消费线程唤醒，所以要再次检查buffer状态
                    // 如果生产消费两把锁，则不必担心此问题
                    lock.wait()
                }
                buffer.offer(data)
                // 此处使用notify有可能唤醒的是另一个生产线程从而造成死锁，所以必须使用notifyAll
                lock.notifyAll()
            }
        }
    }
    fun consume() {
        thread {
            synchronized(lock) {
                while (buffer.isEmpty()) {
                    lock.wait()
                }
                buffer.poll()
                lock.notifyAll()
            }
        }
    }

}