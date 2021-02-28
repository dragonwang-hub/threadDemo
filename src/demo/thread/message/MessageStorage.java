package demo.thread.message;

import java.util.LinkedList;

public class MessageStorage {
    private int maxSize;
    private LinkedList<String> messages;

    public MessageStorage(int maxSize) {
        this.maxSize = maxSize;
        this.messages = new LinkedList<>();
    }

    public void set(String message) {
        synchronized (this) {
            while (messages.size() == maxSize) {
                try {
                    System.out.println("当前消息列表容量已满，请等待消费后再添加！");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            messages.add(message);
            System.out.println("添加消息至列表成功！消息为：" + message);
            this.notifyAll();
        }
    }

    public String get() {
        synchronized (this) {
            while (messages.isEmpty()) {
                try {
                    System.out.println("当前消息列表为空列表，请等待生产后再获取！");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String message = messages.poll();
            System.out.println("获取消息成功！消息为：" + message);
            this.notifyAll();
            return message;
        }

    }

}
