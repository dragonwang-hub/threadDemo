package demo.thread.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableOne implements Runnable {

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + ": 拿到了ReentrantLock锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + ": 释放了ReentrantLock锁");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": 获取锁失败。");
        }
    }
}
