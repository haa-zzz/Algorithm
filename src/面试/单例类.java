package 面试;

public class 单例类 {

}

/**
 java -- 饿汉式
 问题：
 一开始就创建对象了，浪费了资源
 */
class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1 (){}
    public static Singleton1 getInstance() {
        return instance;
    }
}

/**
 * java -- 懒汉式
 * 只是在使用的时候才会去创建对象
 * 但是每次访问都需要进行同步，效率不高
 */
class SingleTon2_ {
    private static SingleTon2_ singleTon2;
    private SingleTon2_(){}

    public static synchronized SingleTon2_ getInstance() {
        if(singleTon2 == null) {
            singleTon2 = new SingleTon2_();
        }
        return singleTon2;
    }
}

/**
 * java -- 双重检验锁
 */
class SingleTon3 {
    private volatile static SingleTon3 singleton3;
    /*
        加了volatile。原因在于 singleton3 = new SingleTon3();这一步其实包含了三个步骤
        1.给对象分配内存
        2.调用实例的构造方法，初始化代码块
        3.将对象指向分配的地址空间
     */
    private SingleTon3(){}
    public static SingleTon3 getInstance() {
        if(singleton3 == null) {    //第一层判空，减少不必要的同步。
            synchronized (SingleTon3.class) {
                if (singleton3 == null) {
                    //第二层判空， 保证单一对象。比如线程A执行到第一个if的时候，被线程B抢去了，线程B执行到if的时候，又被A抢回，
                    // 这个时候，如果不进行判空，就会创建两个对象
                    singleton3 = new SingleTon3();
                }
            }
        }
        return singleton3;
    }
}

