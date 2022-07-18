package 面试;

public class 死锁 {
    class DeanLock {
        void fun() {
            new Thread(() -> {
                synchronized (DeanLock.class) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Object.class) {

                    }

                }
            }).start();

            new Thread(() -> {
                synchronized (Object.class) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (DeanLock.class) {

                    }
                }

            }).start();
        }
    }
}

