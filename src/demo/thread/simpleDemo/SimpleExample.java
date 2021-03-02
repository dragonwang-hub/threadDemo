package demo.thread.simpleDemo;

import java.time.LocalTime;

public class SimpleExample implements Runnable {

    public synchronized void methodOne() {
        common("methodOne");
    }

    public static synchronized void methodTwo() {
        commonStatic("methodTwo");
    }

    public void methodThree() {
        synchronized (this) {
            common("methodThree");
        }
    }

    public void methodFour() {
        synchronized (MultiInstance.class) {
            commonStatic("methodFour");
        }
    }

    private void common(String method) {
        System.out.println(method + ":" + LocalTime.now() + ":线程：" + Thread.currentThread().getName() + "正在执行 common 方法！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(method + ":" + LocalTime.now() + ":线程：" + Thread.currentThread().getName() + "执行完毕 common 方法！");
    }

    private static void commonStatic(String method) {
        System.out.println(method + ":" + LocalTime.now() + ":线程：" + Thread.currentThread().getName() + "正在执行 commonStatic 方法！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(method + ":" + LocalTime.now() + ":线程：" + Thread.currentThread().getName() + "执行完毕 commonStatic 方法！");
    }


    // example 1: 对象锁和类锁区别。不同线程执行不同对象的方法，其不会冲突（每个实例对象都有各自的对象锁）。但执行静态方法，会竞争类锁（一个类只有一个锁）
    @Override
    public void run() {
        // 只打开methodOne，两线程不会竞争锁
        methodOne();

        // 只打开methodTwo，两线程会竞争锁
        methodTwo();

        // 只打开methodThree，两线程不会竞争锁
        methodThree();

        // 只打开methodFour，，两线程会竞争锁
        methodFour();
    }


//    // example 2: 对象锁和类锁不会冲突，是两把锁。异步执行
//    @Override
//    public void run() {
//        String threadName = "Thread-0";
//        if (threadName.equals(Thread.currentThread().getName())) {
//            methodOne(); //一个线程执行这个方法
//        } else {
//            methodTwo(); //一个线程执行此方法
//        }
//    }
}
