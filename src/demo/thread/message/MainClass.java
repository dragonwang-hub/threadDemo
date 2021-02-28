package demo.thread.message;

import java.util.ArrayList;

/**
 * 典型的应用场景是生产者-消费者模式，有一个固定大小的缓冲区存放消息，一个或者多个生产者线程把消息写入缓冲区；一个或者多个消费者从缓冲区获取消息。
 * 如果缓冲区满了，生产者就不能写入消息，并等待。如果缓冲区为空，消费者就不能获取消息，并等待。
 * wait()/notifyAll()
 */
public class MainClass {

    public static void main(String[] args) {
        MessageStorage messageStorage = new MessageStorage(10);
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread consumerThread = new Thread(new Consumer(messageStorage, i));
            threads.add(consumerThread);
        }
        for (int i = 0; i < 5; i++) {
            Thread producerThread = new Thread(new Producer(messageStorage, i));
            threads.add(producerThread);
        }
        for (int i = 0; i < threads.size(); i++) {
            System.out.println("第" + i + "个线程已启动");
            threads.get(i).start();
        }
    }
}
